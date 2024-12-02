package lk.ijse.gdse68.greenplusebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EquipmentDTO {
    private String equipmentId;
    private String name;
    private String type;
    private String status;
    private String fieldCode;
    private String staffId;
}
