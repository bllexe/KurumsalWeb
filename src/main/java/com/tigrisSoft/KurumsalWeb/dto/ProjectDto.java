package com.tigrisSoft.KurumsalWeb.dto;

import com.tigrisSoft.KurumsalWeb.entites.FileAttachment;
import com.tigrisSoft.KurumsalWeb.entites.Project;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectDto {
    private Long id;

    private String name;

    private long timestamp;

   // private StaffDto staff;

    private FileAttachmentDto fileAttachment;

    public ProjectDto(Project project){
        this.setId(project.getId());
        this.setName(project.getName());
        this.setTimestamp(project.getCreateDate().getTime());
       // this.setStaff(new StaffDto(project.getStaff()));
        if (project.getFileAttachment()!=null){
            this.fileAttachment=new FileAttachmentDto(project.getFileAttachment());
        }

    }

}
