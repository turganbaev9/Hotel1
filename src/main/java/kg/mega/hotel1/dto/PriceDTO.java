package kg.mega.hotel1.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PriceDTO {
    Long id;
    Double price;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate startDate;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate endDate;

    DiscountDTO discount;
}

