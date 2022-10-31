package com.tigrisSoft.KurumsalWeb.dto;

import com.tigrisSoft.KurumsalWeb.util.FileType;
import lombok.Data;

@Data
public class StaffUpdateDto {

    private String name;
    private String surname;
    @FileType(types = {"jpeg", "png"})
    private String profileImage;
    private String job;
    private int age;
    private Boolean  worksStatus;

}
