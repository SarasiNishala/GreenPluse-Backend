package lk.ijse.gdse68.greenplusebackend.service;

import lk.ijse.gdse68.greenplusebackend.customObj.StaffResponse;
import lk.ijse.gdse68.greenplusebackend.dto.impl.FieldDTO;
import lk.ijse.gdse68.greenplusebackend.dto.impl.StaffDTO;

import java.util.List;

public interface StaffService {
    void saveStaff(StaffDTO staffDTO);
    void updateStaff(StaffDTO staffDTO, String staffId);
    void deleteStaff(String staffId);
    List<FieldDTO> getAllStaff();
    StaffResponse getStaff(String staffId);
}
