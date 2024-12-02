package lk.ijse.gdse68.greenplusebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StaffDTO {
    private String staffId;
    private String firstName;
    private String lastName;
    private String designation;
    private String gender;
    private String joinedDate;
    private Date dob;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String address5;
    private String contactNo;
    private String email;
    private String role;
}
