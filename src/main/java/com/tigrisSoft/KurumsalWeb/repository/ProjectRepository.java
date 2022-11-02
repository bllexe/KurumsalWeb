package com.tigrisSoft.KurumsalWeb.repository;

import com.tigrisSoft.KurumsalWeb.entites.Project;
import com.tigrisSoft.KurumsalWeb.entites.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long> {
    //Page<Project> findByStaff(String username, Pageable pageable);
}
