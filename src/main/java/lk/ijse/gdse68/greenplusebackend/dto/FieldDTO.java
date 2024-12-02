package lk.ijse.gdse68.greenplusebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldDTO {
    private String fieldCode;
    private String fieldName;
    private Point fieldLocation;
    private Double extentSize;
    private String fieldImage1;
    private String fieldImage2;
}
