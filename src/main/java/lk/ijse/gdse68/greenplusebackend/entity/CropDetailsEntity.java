package lk.ijse.gdse68.greenplusebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "crop_details")
public class CropDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int logCode;
    private Date logDate;
    private String logDetails;
    @Column(columnDefinition = "LONGTEXT")
    private String observedImage;
    @ManyToOne
    @JoinColumn(name = "staffId")
    private StaffEntity staff;
    @ManyToOne
    @JoinColumn(name = "fieldCode")
    private FieldEntity field;
    @ManyToOne
    @JoinColumn
    private CropEntitiy crop;
}
