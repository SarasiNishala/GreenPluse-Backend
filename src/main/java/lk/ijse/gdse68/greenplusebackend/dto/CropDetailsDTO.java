package lk.ijse.gdse68.greenplusebackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CropDetailsDTO {
    private String logCode;
    private Date logDate;
    private String logDetails;
    private String observedImage;
    private String staffId;
    private String fieldCode;
    private String cropCode;
}
