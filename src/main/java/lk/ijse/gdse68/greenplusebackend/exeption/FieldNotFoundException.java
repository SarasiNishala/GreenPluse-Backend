package lk.ijse.gdse68.greenplusebackend.exeption;

public class FieldNotFoundException extends RuntimeException {
    public FieldNotFoundException() {
        super();
    }

    public FieldNotFoundException(String message) {
        super(message);
    }

    public FieldNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
