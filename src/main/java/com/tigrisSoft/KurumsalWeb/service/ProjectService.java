package com.tigrisSoft.KurumsalWeb.service;

import com.tigrisSoft.KurumsalWeb.dto.ProjectDto;
import com.tigrisSoft.KurumsalWeb.dto.ProjectSubmitDto;
import com.tigrisSoft.KurumsalWeb.entites.Project;
import com.tigrisSoft.KurumsalWeb.entites.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProjectService {
    void save(ProjectSubmitDto project, Staff staff);
    Page<Project> getAllProject(Pageable page);
    Page<Project> getProjectByUsername(String username, Pageable pageable);//controller istenen dto geti donus project olacak donus controller map leniyor.
    void deleteProject(long id);

}
