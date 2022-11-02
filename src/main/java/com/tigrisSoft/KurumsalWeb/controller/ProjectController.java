package com.tigrisSoft.KurumsalWeb.controller;

import com.tigrisSoft.KurumsalWeb.dto.ProjectDto;
import com.tigrisSoft.KurumsalWeb.dto.ProjectSubmitDto;
import com.tigrisSoft.KurumsalWeb.service.imp.ProjectServiceImpl;
import com.tigrisSoft.KurumsalWeb.util.ApiPaths;
import com.tigrisSoft.KurumsalWeb.util.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
public class ProjectController {

    @Autowired
    ProjectServiceImpl projectServiceImpl;

    @PostMapping("/add")
    GenericResponse createProject(@RequestBody ProjectSubmitDto project){
        projectServiceImpl.save(project);
        return new GenericResponse("Project created seccessfully");

    }

    @GetMapping("/getAll")
    Page<ProjectDto> getAllProject(Pageable page){
        return projectServiceImpl.getAllProject(page).map(ProjectDto::new);
    }

/* @GetMapping("/getByUser/{username}")
    Page<ProjectDto> getProjectByUser(@PathVariable(value = "username") String username,Pageable pageable){
        return projectServiceImpl.getProjectByUsername(username,pageable).map(ProjectDto::new);

    }*/

    @DeleteMapping("/delete/{id}")
    GenericResponse deleteProject(@PathVariable long id){
        projectServiceImpl.deleteProject(id);
        return new GenericResponse("Project Removed");
    }

}
