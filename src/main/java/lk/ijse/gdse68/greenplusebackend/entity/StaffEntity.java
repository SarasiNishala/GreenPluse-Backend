package lk.ijse.gdse68.greenplusebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "staff")
public class StaffEntity {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int staffId;
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
    @Column(unique = true)
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToMany(mappedBy = "staff")
    private List<FieldStaff> fieldStaffs = new ArrayList<>();
    @OneToMany(mappedBy = "staff")
    private List<VehicleEntity> vehicles = new ArrayList<>();
    @OneToMany(mappedBy = "staff")
    private List<EquipmentEntity> equipments = new ArrayList<>();
    @OneToMany(mappedBy = "staff", cascade = CascadeType.ALL)
    private List<CropDetailsEntity> cropDetails;
}
