package lk.ijse.gdse68.greenplusebackend.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FieldStaffDTO {
    private String field_staff_id;
    private String fieldCode;
    private StaffDTO staff;
    private  String assignedDate;
    private  String dueDate;
}
