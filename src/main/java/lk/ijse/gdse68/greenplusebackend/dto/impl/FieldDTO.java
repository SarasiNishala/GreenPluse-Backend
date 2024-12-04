package lk.ijse.gdse68.greenplusebackend.dto.impl;

import lk.ijse.gdse68.greenplusebackend.customObj.FieldResponse;
import lk.ijse.gdse68.greenplusebackend.dto.SupperDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FieldDTO implements SupperDTO, FieldResponse {
    private String fieldCode;
    private String fieldName;
    private String fieldLocation;
    private Double extentSize;
    private String fieldImage1;
    private String fieldImage2;
}


