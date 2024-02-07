package kg.mega.hotel1.dto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class OrderDTO {
    Long id;

    List<ClientDTO> client;

    List<DiscountDTO> discount;
    List< PriceDTO> price;

    RoomDTO room;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate dateTimeFrom;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate dateTimeTo;
    Double priceBeforeDiscount;
    Double priceWithDiscount;
}

