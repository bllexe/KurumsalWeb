package com.tigrisSoft.KurumsalWeb.repository;

import com.tigrisSoft.KurumsalWeb.dto.StaffDto;
import com.tigrisSoft.KurumsalWeb.entites.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRepository extends JpaRepository<Staff,Long> {
    Staff findByUsername(String username);
}
