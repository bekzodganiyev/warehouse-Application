package com.bek.warehouse.service;

import com.bek.warehouse.entity.Attachment;
import com.bek.warehouse.entity.AttachmentContent;
import com.bek.warehouse.payload.Result;
import com.bek.warehouse.repository.AttachmentContentRepository;
import com.bek.warehouse.repository.AttachmentRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;

    @Autowired
    AttachmentContentRepository attachmentContentRepository;

    @SneakyThrows
    public Result upload(MultipartHttpServletRequest request) {
        Iterator<String> fileNames = request.getFileNames();
        MultipartFile file = request.getFile(fileNames.next());
        Attachment attachment = new Attachment();
        assert file != null;
        attachment.setName(file.getOriginalFilename());
        attachment.setSize(file.getSize());
        attachment.setContentType(file.getContentType());
        Attachment savedAttachment = attachmentRepository.save(attachment);
        AttachmentContent attachmentContent = new AttachmentContent();
        attachmentContent.setBytes(file.getBytes());
        attachmentContent.setAttachment(savedAttachment);
        attachmentContentRepository.save(attachmentContent);
        return new Result("File saved !!!",true,savedAttachment.getId());
    }

    public Result getAllAttachment() {
        List<Attachment> attachmentList = attachmentRepository.findAll();
        return new Result("Attachment list",true,attachmentList);
    }

    public Result getAttachmentById(Integer id) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
//        return optionalAttachment.isPresent()?new Result("Attachment by id",true,optionalAttachment.get()):new Result("Attachment not found",false);
        return optionalAttachment.map(attachment -> new Result("Attachment by id", true, attachment)).orElseGet(() -> new Result("Attachment not found", false));
    }

    @SneakyThrows
    public Result editAttachment(Integer id, MultipartFile file) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            Attachment editingAttachment = optionalAttachment.get();
            editingAttachment.setSize(file.getSize());
            editingAttachment.setName(file.getOriginalFilename());
            editingAttachment.setContentType(file.getContentType());
            Attachment editedAttachment = attachmentRepository.save(editingAttachment);
            AttachmentContent attachmentContentByAttachmentId = attachmentContentRepository.findByAttachmentId(id);
            attachmentContentByAttachmentId.setAttachment(editedAttachment);
            attachmentContentByAttachmentId.setBytes(file.getBytes());
            attachmentContentRepository.save(attachmentContentByAttachmentId);
            return new Result("edit Attachment",true,editedAttachment);
        }
        return new Result("Not edit",false);
    }

    public Result deleteAttachment(Integer id) {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            AttachmentContent byAttachmentId = attachmentContentRepository.findByAttachmentId(id);
            attachmentContentRepository.deleteByAttachmentId(id);
            attachmentRepository.deleteById(id);
            return new Result("Deleted attachment",true);
        }
        return new Result("Attachment not found",false);
    }
}
