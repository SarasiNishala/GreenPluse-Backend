package lk.ijse.gdse68.greenplusebackend.customObj;

import java.io.Serializable;

public class UserErrorResponse implements UserResponse, Serializable {
    private int errorCode;
    private String errorMessage;
}
