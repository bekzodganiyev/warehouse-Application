package com.bek.warehouse.controller;

import com.bek.warehouse.payload.Result;
import com.bek.warehouse.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @PostMapping("/upload")
    public Result upload(MultipartHttpServletRequest request){
        return attachmentService.upload(request);
    }

    @GetMapping
    public Result getAllAttachment(){
        return attachmentService.getAllAttachment();
    }

    @GetMapping("/{id}")
    public Result getAttachmentById(@PathVariable Integer id){
        return attachmentService.getAttachmentById(id);
    }

    @PutMapping("/{id}")
    public Result editAttachment(@PathVariable Integer id, @RequestParam MultipartFile file){
        return attachmentService.editAttachment(id,file);
    }

    @DeleteMapping("/{id}")
    public Result deleteAttachment(@PathVariable Integer id){
        return attachmentService.deleteAttachment(id);
    }


}
