package lk.ijse.gdse68.greenplusebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "crop")
public class CropEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cropCode;
    private String cropCommonName;
    private String cropScientificName;
    @Column(columnDefinition = "LONGTEXT")
    private String cropImage;
    private String category;
    private String cropSeason;
    @ManyToOne
    @JoinColumn(name = "fieldCode")
    private FieldEntity field;
    @OneToMany(mappedBy = "crop", cascade = CascadeType.ALL)
    private List<CropDetailsEntity> cropDetails;

}
