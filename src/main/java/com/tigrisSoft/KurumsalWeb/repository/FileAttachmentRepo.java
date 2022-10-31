package com.tigrisSoft.KurumsalWeb.repository;

import com.tigrisSoft.KurumsalWeb.entites.FileAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface FileAttachmentRepo extends JpaRepository<FileAttachment,String> {

    List<FileAttachment> findByDateBeforeAndProjectNull(Date date);
}
