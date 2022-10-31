package com.tigrisSoft.KurumsalWeb.service;

import com.tigrisSoft.KurumsalWeb.dto.StaffDto;
import com.tigrisSoft.KurumsalWeb.dto.StaffUpdateDto;
import com.tigrisSoft.KurumsalWeb.entites.Staff;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface StaffService {
    Page<Staff> getAllStaff(Pageable pageable);

    Staff createStaff(Staff staff);

    Boolean deleteStaff(String username);

    Staff updateStaff(String username, StaffUpdateDto staffDto);

    List<Staff> activeStaff();

    List<Staff> passiveStaff();

    Staff getByUserName(String username);
}
