package com.tigrisSoft.KurumsalWeb.dto;

import com.tigrisSoft.KurumsalWeb.entites.Staff;
import com.tigrisSoft.KurumsalWeb.util.FileType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
public class StaffDto {

    private String name;

    private String surname;

    //username update alani password ile beraber olabilir bu cikarilabilir.
    private String username;

    private String profileImage;

    private Date createDate;

    private String job;

    private int age;

    private boolean workStatus;

    public StaffDto(Staff staff){
        this.setName(staff.getName());
        this.setSurname(staff.getSurname());
        this.setUsername(staff.getUsername());
        this.setProfileImage(staff.getProfileImage());
        this.setCreateDate(staff.getCreateDate());
        this.setJob(staff.getJob());
        this.setAge(staff.getAge());
        this.setWorkStatus(staff.isWorkStatus());
    }


}
