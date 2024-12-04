package lk.ijse.gdse68.greenplusebackend.service;

import lk.ijse.gdse68.greenplusebackend.customObj.FieldResponse;
import lk.ijse.gdse68.greenplusebackend.dto.impl.FieldDTO;

import java.util.List;

public interface FieldSrvice {
    void saveField(FieldDTO fieldDTO);
    void updateField(FieldDTO fieldDTO, String fieldCode);
    void deleteField(String field_code) throws Exception;
    List<FieldDTO> getAllField();
    FieldResponse getField(String field_code);
}
