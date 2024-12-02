package lk.ijse.gdse68.greenplusebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "vehicale")
public class VehicleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vehicleCode;
    private String licensePlateNumber;
    private String vehicleCategory;
    private String fuelType;
    private String status;
    private String remarks;
    @ManyToOne
    @JoinColumn(name = "staffId")
    private StaffEntity staff;
}
