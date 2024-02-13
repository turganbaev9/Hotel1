package kg.mega.hotel1.service;

import kg.mega.hotel1.dto.RoomDTO;

import java.time.LocalDate;
import java.util.List;

public interface RoomService {
    RoomDTO save(RoomDTO roomDTO);
    RoomDTO update(RoomDTO roomDTO );
    RoomDTO findById(Long id);
    List<RoomDTO> findAll();
    void delete(Long id);
    boolean isAvailable(RoomDTO roomDTO, LocalDate startDate, LocalDate endDate);
}

