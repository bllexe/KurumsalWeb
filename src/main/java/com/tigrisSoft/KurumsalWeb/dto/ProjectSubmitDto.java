package com.tigrisSoft.KurumsalWeb.dto;

import com.tigrisSoft.KurumsalWeb.entites.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectSubmitDto {
    private long id;

    private String name;

    //private String content; //bu eklenecek.

    private Date createDate;

    private FileAttachmentDto fileAttachment;


/*    public ProjectSubmitDto(Project project){
        this.setName(project.getName());
        this.setCreateDate(project.getCreateDate());
        // this.setStaff(new StaffDto(project.getStaff()));
        if (project.getFileAttachment()!=null){
            this.fileAttachment=new FileAttachmentDto(project.getFileAttachment());
        }

    }*/


}
