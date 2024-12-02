package lk.ijse.gdse68.greenplusebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "field")
public class FieldEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fieldCode;
    private String fieldName;
    private Point fieldLocation;
    private Double extentSize;
    @Column(columnDefinition = "LONGTEXT")
    private String fieldImage1;
    @Column(columnDefinition = "LONGTEXT")
    private String fieldImage2;
    @OneToMany(mappedBy = "field")
    private List<FieldStaff> fieldStaffs = new ArrayList<>();
    @OneToMany(mappedBy = "field")
    private List<EquipmentEntity> equipments = new ArrayList<>();
    @OneToMany(mappedBy = "field" , cascade = CascadeType.ALL)
    private List<CropEntitiy> crops;
    @OneToMany(mappedBy = "field", cascade = CascadeType.ALL)
    private List<CropDetailsEntity> cropDetails;
}
