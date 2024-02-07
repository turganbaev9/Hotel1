package kg.mega.hotel1.dto;
import kg.mega.hotel1.model.Category;
import lombok.Data;

import java.util.List;

@Data
public class RoomDTO {

    Long id;
    Integer rooms;
    Boolean isAvailable;
    ClientDTO client;
    Category category;
}
