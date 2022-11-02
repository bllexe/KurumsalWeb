package com.tigrisSoft.KurumsalWeb.service.imp;

import com.tigrisSoft.KurumsalWeb.dto.ReferenceSubmitDto;
import com.tigrisSoft.KurumsalWeb.dto.ReferencesDto;
import com.tigrisSoft.KurumsalWeb.entites.FileAttachment;
import com.tigrisSoft.KurumsalWeb.entites.Reference;
import com.tigrisSoft.KurumsalWeb.error.NotFoundException;
import com.tigrisSoft.KurumsalWeb.repository.FileAttachmentRepo;
import com.tigrisSoft.KurumsalWeb.repository.ReferencesRepository;
import com.tigrisSoft.KurumsalWeb.service.ReferencesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ReferencesServiceImpl implements ReferencesService {

    @Autowired
    ReferencesRepository referencesRepository;
    FileAttachmentRepo fileAttachmentRepo;
    FileAttachmentServiceImpl fileAttachmentService;

    public ReferencesServiceImpl(ReferencesRepository referencesRepository,FileAttachmentRepo fileAttachmentRepo,FileAttachmentServiceImpl fileAttachmentService){
        this.referencesRepository=referencesRepository;
        this.fileAttachmentRepo=fileAttachmentRepo;
        this.fileAttachmentService=fileAttachmentService;
    }

    @Override
    public void addReference(ReferenceSubmitDto referenceSubmitDto) {
       Reference reference=new Reference();
       reference.setReferenceName(referenceSubmitDto.getReferenceName());
       reference.setCreateDate(new Date(System.currentTimeMillis()));
       referencesRepository.save(reference);
       Optional<FileAttachment> optionalFileAttachment=fileAttachmentRepo.findById(referenceSubmitDto.getAttachmentId());
       if (optionalFileAttachment.isPresent()){
           FileAttachment fileAttachment=optionalFileAttachment.get();
           fileAttachmentRepo.save(fileAttachment);
       }
    }

    @Override
    public Page<Reference> getAllReferences(Pageable pageable) {
        return referencesRepository.findAll(pageable);
    }

    @Override
    public Reference getOneReference(long id) {
        Optional<Reference> inDb=referencesRepository.findById(id);
        if (!inDb.isPresent()){
            throw new NotFoundException();
        }
        return referencesRepository.findById(id).get();

    }

    @Override
    public void deleteReference(long id) {
       Reference refInDb=referencesRepository.getReferenceById(id);

       if(refInDb.getFileAttachment()!=null){
           String filename=refInDb.getFileAttachment().getName();
           fileAttachmentService.deleteAttachmentFile(filename);
       }
       referencesRepository.deleteById(id);

    }
}
