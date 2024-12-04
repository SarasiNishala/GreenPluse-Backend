package lk.ijse.gdse68.greenplusebackend.service;

import lk.ijse.gdse68.greenplusebackend.customObj.FieldErrorResponse;
import lk.ijse.gdse68.greenplusebackend.customObj.FieldResponse;
import lk.ijse.gdse68.greenplusebackend.dao.FieldDAO;
import lk.ijse.gdse68.greenplusebackend.dto.impl.FieldDTO;
import lk.ijse.gdse68.greenplusebackend.entity.FieldEntity;
import lk.ijse.gdse68.greenplusebackend.exeption.DataPersistFailedException;
import lk.ijse.gdse68.greenplusebackend.exeption.FieldNotFoundException;
import lk.ijse.gdse68.greenplusebackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FieldServiceIMPL implements FieldSrvice{
    @Autowired
    private FieldDAO fieldDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveField(FieldDTO fieldDTO) {
        fieldDTO.setFieldCode(generateNextFieldId());
        FieldEntity fieldEntity = mapping.convertToFieldEntity(fieldDTO);
        FieldEntity save = fieldDAO.save(fieldEntity);
        if(save != null){
            throw new DataPersistFailedException("Field save failed");
        }
    }

    @Override
    public void updateField(FieldDTO fieldDTO, String fieldCode) {
        Optional<FieldEntity> tmpField = fieldDAO.findById(fieldCode);
        if(tmpField.isPresent()){
            throw new FieldNotFoundException("Field not found");
        }else {
            tmpField.get().setFieldName(fieldDTO.getFieldName());
            tmpField.get().setExtentSize(fieldDTO.getExtentSize());
            tmpField.get().setFieldImage1(fieldDTO.getFieldImage1());
            tmpField.get().setFieldImage2(fieldDTO.getFieldImage2());
            tmpField.get().setFieldLocation(fieldDTO.getFieldLocation());
        }
    }

    @Override
    public void deleteField(String field_code){
        Optional<FieldEntity> byId = fieldDAO.findById(field_code);
        if (!byId.isPresent()) {
            throw new FieldNotFoundException("Field not found");
        }else {
            fieldDAO.deleteById(field_code);
        }
    }

    @Override
    public List<FieldDTO> getAllField() {
        List<FieldEntity> allField = fieldDAO.findAll();
        return mapping.convertToFieldDTOList(allField);
    }

    @Override
    public FieldResponse getField(String field_code) {
        if(fieldDAO.existsById(field_code)){
            return mapping.convertToFieldDTO(fieldDAO.getReferenceById(field_code));
        }else {
            return new FieldErrorResponse(0, "Field Not Found");
        }

    }

    private String generateNextFieldId() {
        if (fieldDAO.count() == 0) {
            return "F001";
        } else {
            String lastId = String.valueOf(fieldDAO.findAll().get(fieldDAO.findAll().size() - 1).getFieldCode());
            int newId = Integer.parseInt(lastId.substring(1)) + 1;
            if (newId < 10) {
                return "F00" + newId;
            } else if (newId < 100) {
                return "F0" + newId;
            } else {
                return "F" + newId;
            }
        }
    }
}
