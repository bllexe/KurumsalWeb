package com.tigrisSoft.KurumsalWeb.service.imp;

import com.tigrisSoft.KurumsalWeb.dto.StaffDto;
import com.tigrisSoft.KurumsalWeb.dto.StaffUpdateDto;
import com.tigrisSoft.KurumsalWeb.entites.Staff;
import com.tigrisSoft.KurumsalWeb.error.NotFoundException;
import com.tigrisSoft.KurumsalWeb.repository.StaffRepository;
import com.tigrisSoft.KurumsalWeb.service.StaffService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Pageable;

@Service
public class StaffServiceImpl implements StaffService {

     StaffRepository staffRepository;
     FileAttachmentServiceImpl fileAttachmentServiceImpl;

     //PasswordEncoder passwordEncoder;

    public StaffServiceImpl(StaffRepository staffRepository, FileAttachmentServiceImpl fileAttachmentServiceImpl) {
        this.staffRepository = staffRepository;
        this.fileAttachmentServiceImpl = fileAttachmentServiceImpl;
    }


    @Override
    public Staff createStaff(Staff staff) {
        //staff.setPassword(this.passwordEncoder.encode(staff.getPassword()));
        staff.setCreateDate(new Date(System.currentTimeMillis()));
        return staffRepository.save(staff);
    }


    @Override
    public Page<Staff> getAllStaff(Pageable pageable) {
        return staffRepository.findAll(pageable);
    }


    @Override
    public Boolean deleteStaff(String username) {
        Staff inDb=staffRepository.findByUsername(username);
        fileAttachmentServiceImpl.deleteAllStoredFilesForUser(inDb);
        staffRepository.delete(inDb);
        return true;
    }


    @Override
    public Staff updateStaff(String username, StaffUpdateDto updatedStaff) {
        Staff inDb=getByUserName(username);
        inDb.setName(updatedStaff.getName());
        inDb.setSurname(updatedStaff.getSurname());
       //inDb.setProfileImage(updatedStaff.getProfileImage());
        inDb.setJob(updatedStaff.getJob());
        inDb.setAge(updatedStaff.getAge());
        inDb.setWorkStatus(updatedStaff.getWorksStatus());

        if (updatedStaff.getProfileImage() !=null) {
            String oldImage = inDb.getProfileImage();
            try {
                String storadFileName = fileAttachmentServiceImpl.writeBase64EncodedStringToFile(updatedStaff.getProfileImage());
                inDb.setProfileImage(storadFileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            fileAttachmentServiceImpl.deleteProfileImage(oldImage);
        }
        return staffRepository.save(inDb);
    }

    @Override
    public List<Staff> activeStaff() {
        return null;
    }

    @Override
    public List<Staff> passiveStaff() {
        return null;
    }

    @Override
    public Staff getByUserName(String username) {
        Staff inDb=staffRepository.findByUsername(username);
        if (inDb==null){
            throw new NotFoundException();
        }
        return inDb;
    }
}
