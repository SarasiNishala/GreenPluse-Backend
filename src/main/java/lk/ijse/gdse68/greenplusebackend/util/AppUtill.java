package lk.ijse.gdse68.greenplusebackend.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

public class AppUtill {

    /**
     * Convert a MultipartFile to a Base64-encoded string.
     *
     * @param image the MultipartFile to convert
     * @return the Base64-encoded string
     * @throws IllegalArgumentException if the input image is null
     */
    public static String toBase64(MultipartFile image) {
        if (image == null || image.isEmpty()) {
            throw new IllegalArgumentException("Invalid image file: The file is null or empty.");
        }

        try {
            byte[] imageBytes = image.getBytes();
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (IOException e) {
            throw new RuntimeException("Failed to convert image to Base64 due to an I/O error.", e);
        }
    }

    /**
     * Convert a byte array to a Base64-encoded string.
     *
     * @param imageBytes the byte array to convert
     * @return the Base64-encoded string
     * @throws IllegalArgumentException if the byte array is null or empty
     */
    public static String toBase64(byte[] imageBytes) {
        if (imageBytes == null || imageBytes.length == 0) {
            throw new IllegalArgumentException("Invalid byte array: The array is null or empty.");
        }

        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
