package kg.mega.hotel1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ClientDTO {
    Long id;
    String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate birthData;
    Integer age;
    Boolean withFamily;
    String reasonForCome;
}

