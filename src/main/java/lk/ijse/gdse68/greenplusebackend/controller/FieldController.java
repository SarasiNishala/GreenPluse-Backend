package lk.ijse.gdse68.greenplusebackend.controller;

import lk.ijse.gdse68.greenplusebackend.customObj.FieldResponse;
import lk.ijse.gdse68.greenplusebackend.dto.impl.FieldDTO;
import lk.ijse.gdse68.greenplusebackend.exeption.DataPersistFailedException;
import lk.ijse.gdse68.greenplusebackend.exeption.FieldNotFoundException;
import lk.ijse.gdse68.greenplusebackend.service.FieldSrvice;
import lk.ijse.gdse68.greenplusebackend.util.AppUtill;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/v1/field")
@RequiredArgsConstructor
@CrossOrigin
public class FieldController {
    @Autowired
    private final FieldSrvice fieldSrvice;

    @GetMapping( value = "allfields", produces = MediaType.APPLICATION_JSON_VALUE )
    public List<FieldDTO> getAllFields(){  //http://localhost:8080/notetaker/api/v1/note/allnotes
        return fieldSrvice.getAllField();
    }

    @GetMapping(value = "/{fieldCode}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public FieldResponse getNote(@PathVariable("noteId") String fieldCode){ //http://localhost:8080/notetaker/api/v1/note/1
        return fieldSrvice.getField(fieldCode);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> saveField(
            @RequestPart("field_name") String fieldName,
            @RequestPart("location") String location,
            @RequestPart("extent_size") String extentSizeString,
            @RequestPart("image_1") MultipartFile image1,
            @RequestPart("image_2") MultipartFile image2
    ) {
        try {
            // Validate and format "location" string
            String[] coordinates = location.split(",");
            if (coordinates.length != 2) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Invalid location format
            }
            String formattedLocation = coordinates[0].trim() + "," + coordinates[1].trim();

            // Convert extent size to Double
            Double extentSize;
            try {
                extentSize = Double.parseDouble(extentSizeString);
            } catch (NumberFormatException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Invalid extent size format
            }

            // Convert images to Base64 strings
            String base64Image1 = AppUtill.toBase64(image1);
            String base64Image2 = AppUtill.toBase64(image2);

            // Build the FieldDTO object
            FieldDTO buildFieldDTO = FieldDTO.builder()
                    .fieldCode(null) // Assume fieldCode is auto-generated
                    .fieldName(fieldName)
                    .fieldLocation(formattedLocation) // Save as "latitude,longitude"
                    .extentSize(extentSize)
                    .fieldImage1(base64Image1)
                    .fieldImage2(base64Image2)
                    .build();

            // Send to the Service layer
            fieldSrvice.saveField(buildFieldDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);

        } catch (DataPersistFailedException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteField(@PathVariable("id") String field_id){
        try {
            fieldSrvice.deleteField(field_id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (FieldNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping(value = "/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Void> updateField(
            @PathVariable("id") String id,
            @RequestPart("field_name") String fieldName,
            @RequestPart("location") String location,
            @RequestPart("extent_size") String extentSizeString,
            @RequestPart("image_1") MultipartFile image1,
            @RequestPart("image_2") MultipartFile image2
    ) {
        try {
            // Validate and format "location" string
            String[] coordinates = location.split(",");
            if (coordinates.length != 2) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Invalid location format
            }
            String formattedLocation = coordinates[0].trim() + "," + coordinates[1].trim();

            // Convert extent size to Double
            Double extentSize;
            try {
                extentSize = Double.parseDouble(extentSizeString);
            } catch (NumberFormatException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Invalid extent size format
            }

            // Convert images to Base64 strings
            String base64Image1 = AppUtill.toBase64(image1);
            String base64Image2 = AppUtill.toBase64(image2);

            // Build the FieldDTO object
            FieldDTO updateFieldDTO = FieldDTO.builder()
                    .fieldCode(id)
                    .fieldName(fieldName)
                    .fieldLocation(formattedLocation) // Save as "latitude,longitude"
                    .extentSize(extentSize)
                    .fieldImage1(base64Image1)
                    .fieldImage2(base64Image2)
                    .build();

            // Send to the Service layer
            fieldSrvice.updateField(updateFieldDTO, id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (FieldNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
