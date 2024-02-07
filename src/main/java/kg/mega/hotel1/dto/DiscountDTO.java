package kg.mega.hotel1.dto;



import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

import java.time.LocalDate;
@Data
public class DiscountDTO {
    Long id;
    String nameDisc;
    Double disc;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate startDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate endDate;
    Integer countDays;
    RoomDTO room;
}
