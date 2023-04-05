package com.bek.warehouse.repository;

import com.bek.warehouse.entity.AttachmentContent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent, Integer> {

    AttachmentContent findByAttachmentId(Integer attachment_id);

    void deleteByAttachmentId(Integer attachment_id);

}
