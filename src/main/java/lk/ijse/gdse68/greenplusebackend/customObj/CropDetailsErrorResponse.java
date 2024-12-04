package lk.ijse.gdse68.greenplusebackend.customObj;

import java.io.Serializable;

public class CropDetailsErrorResponse implements CropDetailsResponse, Serializable {
    private int errorCode;
    private String errorMessage;
}
