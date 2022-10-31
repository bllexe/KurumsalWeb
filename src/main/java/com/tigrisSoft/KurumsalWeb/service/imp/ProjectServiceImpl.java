package com.tigrisSoft.KurumsalWeb.service.imp;

import com.tigrisSoft.KurumsalWeb.dto.ProjectDto;
import com.tigrisSoft.KurumsalWeb.dto.ProjectSubmitDto;
import com.tigrisSoft.KurumsalWeb.entites.FileAttachment;
import com.tigrisSoft.KurumsalWeb.entites.Project;
import com.tigrisSoft.KurumsalWeb.entites.Staff;
import com.tigrisSoft.KurumsalWeb.repository.FileAttachmentRepo;
import com.tigrisSoft.KurumsalWeb.repository.ProjectRepository;
import com.tigrisSoft.KurumsalWeb.service.FileAttachmentService;
import com.tigrisSoft.KurumsalWeb.service.ProjectService;
import com.tigrisSoft.KurumsalWeb.service.StaffService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.Optional;

public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    StaffServiceImpl staffServiceImpl;
    FileAttachmentRepo fileAttachmentRepo;
    FileAttachmentService fileAttachmentService;

    public ProjectServiceImpl(ProjectRepository projectRepository, StaffServiceImpl staffServiceImpl, FileAttachmentRepo fileAttachmentRepo, FileAttachmentService fileAttachmentService) {
        super();
        this.projectRepository = projectRepository;
        this.staffServiceImpl = staffServiceImpl;
        this.fileAttachmentRepo = fileAttachmentRepo;
        this.fileAttachmentService = fileAttachmentService;
    }

    @Override
    public void save(ProjectSubmitDto projectSubmitDto, Staff staff) {
        Project project=new Project();
        project.setName(projectSubmitDto.getName());
        project.setCreateDate(new Date());
        project.setStaff(staff);
        projectRepository.save(project);
        Optional<FileAttachment> optionalFileAttachment = fileAttachmentRepo.findById(projectSubmitDto.getAttachmentId());//hata olabilir.
        if(optionalFileAttachment.isPresent()){
            FileAttachment fileAttachment= optionalFileAttachment.get();
            fileAttachment.setProject(project);
            fileAttachmentRepo.save(fileAttachment);
        }

    }

    @Override
    public Page<Project> getAllProject(Pageable page) {
        return projectRepository.findAll(page);
    }

    @Override
    public Page<Project> getProjectByUsername(String username, Pageable pageable) {
        Staff inDb=staffServiceImpl.getByUserName(username);
        return projectRepository.findByUser(inDb,pageable);
    }

    @Override
    public void deleteProject(long id) {
        Project inDb=projectRepository.getReferenceById(id);
        if(inDb.getFileAttachment() !=null){
            String fileName=inDb.getFileAttachment().getName();
            fileAttachmentService.deleteAttachmentFile(fileName);        }
        projectRepository.deleteById(id);
    }
}
