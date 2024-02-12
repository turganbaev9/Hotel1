package kg.mega.hotel1.mapper;

import kg.mega.hotel1.dto.RoomDTO;
import kg.mega.hotel1.model.Room;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface RoomMapper {

    RoomMapper INSTANCE= Mappers.getMapper(RoomMapper.class);
    Room toEntity(RoomDTO roomDTO);
    RoomDTO toDTO(Room room);
    List<Room> toEntity(List<RoomDTO> roomDTOS);
    List<RoomDTO>toDTOList(List<Room> rooms);}
