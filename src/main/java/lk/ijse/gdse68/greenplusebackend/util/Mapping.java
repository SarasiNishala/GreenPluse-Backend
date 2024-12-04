package lk.ijse.gdse68.greenplusebackend.util;

import lk.ijse.gdse68.greenplusebackend.dto.impl.FieldDTO;
import lk.ijse.gdse68.greenplusebackend.dto.impl.StaffDTO;
import lk.ijse.gdse68.greenplusebackend.entity.FieldEntity;
import lk.ijse.gdse68.greenplusebackend.entity.StaffEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    //Field matters mapping
    public FieldDTO convertToFieldDTO(FieldEntity fieldEntity) {
        return modelMapper.map(fieldEntity, FieldDTO.class);
    }
    public FieldEntity convertToFieldEntity(FieldDTO fieldDTO) {
        return modelMapper.map(fieldDTO, FieldEntity.class);
    }
    public List<FieldDTO> convertToFieldDTOList(List<FieldEntity> fields) {
        return modelMapper.map(fields, new TypeToken<List<FieldDTO>>(){}.getType());
    }

    //Staff matters mapping
    public StaffDTO convertToStaffDTO(StaffEntity staffEntity) {
        return modelMapper.map(staffEntity, StaffDTO.class);
    }
    public StaffEntity convertToStaffEntity(StaffDTO staffDTO) {
        return modelMapper.map(staffDTO, StaffEntity.class);
    }
    public List<StaffDTO> convertToStaffDTOList(List<StaffEntity> staffEntities) {
        return modelMapper.map(staffEntities, new TypeToken<List<StaffDTO>>(){}.getType());
    }
}
