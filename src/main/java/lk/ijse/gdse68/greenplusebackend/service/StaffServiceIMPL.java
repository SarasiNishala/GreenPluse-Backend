package lk.ijse.gdse68.greenplusebackend.service;

import lk.ijse.gdse68.greenplusebackend.customObj.StaffResponse;
import lk.ijse.gdse68.greenplusebackend.dao.StaffDAO;
import lk.ijse.gdse68.greenplusebackend.dto.impl.FieldDTO;
import lk.ijse.gdse68.greenplusebackend.dto.impl.StaffDTO;
import lk.ijse.gdse68.greenplusebackend.entity.StaffEntity;
import lk.ijse.gdse68.greenplusebackend.exeption.DataPersistFailedException;
import lk.ijse.gdse68.greenplusebackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StaffServiceIMPL implements StaffService {
    @Autowired
    private StaffDAO staffDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveStaff(StaffDTO staffDTO) {
        staffDTO.setStaffId(generateNextStaffId());
        StaffEntity staffEntity = mapping.convertToStaffEntity(staffDTO);
        StaffEntity save = staffDAO.save(staffEntity);
        if (save != null) {
            throw new DataPersistFailedException("Staff save failed");
        }
    }

    @Override
    public void updateStaff(StaffDTO staffDTO, String staffId) {

    }

    @Override
    public void deleteStaff(String staffId) {

    }

    @Override
    public List<FieldDTO> getAllStaff() {
        return List.of();
    }

    @Override
    public StaffResponse getStaff(String staffId) {
        return null;
    }
}
