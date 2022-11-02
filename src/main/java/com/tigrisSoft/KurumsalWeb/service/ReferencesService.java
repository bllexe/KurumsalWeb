package com.tigrisSoft.KurumsalWeb.service;

import com.tigrisSoft.KurumsalWeb.dto.ReferenceSubmitDto;
import com.tigrisSoft.KurumsalWeb.dto.ReferencesDto;
import com.tigrisSoft.KurumsalWeb.entites.Reference;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ReferencesService {
    void addReference(ReferenceSubmitDto reference);

    Page<Reference> getAllReferences(Pageable pageable);

    Reference getOneReference(long id);

    void deleteReference(long id);
}
