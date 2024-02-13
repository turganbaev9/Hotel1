package kg.mega.hotel1.service.Impl;

import kg.mega.hotel1.crud.ClientRepo;
import kg.mega.hotel1.crud.OrderRepo;
import kg.mega.hotel1.crud.RoomRepo;
import kg.mega.hotel1.dto.OrderDTO;
import kg.mega.hotel1.dto.RoomDTO;
import kg.mega.hotel1.mapper.OrderMapper;
import kg.mega.hotel1.mapper.RoomMapper;
import kg.mega.hotel1.model.Client;
import kg.mega.hotel1.model.Room;
import kg.mega.hotel1.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoomServiceImpl implements RoomService {
    private final RoomRepo repo;
    private final ClientRepo clientRepo;
    private final OrderRepo orderRepo;

    @Override
    public RoomDTO save(RoomDTO roomDTO) {
        Room room = RoomMapper.INSTANCE.toEntity(roomDTO);
        Client client = clientRepo.findById(roomDTO.getClient().getId()).orElseThrow(() -> new NoSuchElementException("client with this Id" + roomDTO.getClient().getId() + "not found"));
        room.setClient(client);
        repo.save(room);

        return RoomMapper.INSTANCE.toDTO(room);
    }

    @Override
    public RoomDTO update(RoomDTO roomDTO) {
        Room room = repo.findById(roomDTO.getId()).orElseThrow(() -> new EntityNotFoundException("room with ID" + roomDTO.getId() + "not found"));
        Optional.ofNullable(roomDTO.getRooms()).ifPresent(room::setRooms);
        Optional.ofNullable(roomDTO.getCategory()).ifPresent(room::setCategory);
        Optional.ofNullable(roomDTO.getIsAvailable()).ifPresent(room::setIsAvailable);
        Room updated = repo.save(room);
        return RoomMapper.INSTANCE.toDTO(updated);
    }

    @Override
    public RoomDTO findById(Long id) {
        Room finded = repo.findById(id).get();

        return RoomMapper.INSTANCE.toDTO(finded);
    }

    @Override
    public List<RoomDTO> findAll() {
        List<Room> rooms = repo.findAll();
        return RoomMapper.INSTANCE.toDTOList(rooms);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    @Override
    public boolean isAvailable(RoomDTO roomDTO, LocalDate startDate, LocalDate endDate) {
        LocalDate now = LocalDate.now();
        List<OrderDTO> allOrders = OrderMapper.INSTANCE.toDTOList(orderRepo.findAll());
        for (OrderDTO order : allOrders) {
            if (order.getRoom().getId().equals(roomDTO.getId())) {
                if (order.getDateTimeFrom().isBefore(now) && startDate.isAfter(now)) {
                    if (startDate.isAfter(order.getDateTimeFrom()) && startDate.isBefore(order.getDateTimeTo()))
                        if ((startDate.isAfter(order.getDateTimeFrom()) && startDate.isBefore(order.getDateTimeTo()))
                                || (endDate.isAfter(order.getDateTimeFrom()) && endDate.isBefore(order.getDateTimeTo()))
                                || (startDate.isBefore(order.getDateTimeFrom()) && endDate.isAfter(order.getDateTimeTo()))) {
                            System.out.println("комната занята в указанный период");
                            return false;
                        }
                }
            }
        }
        return true;
    }
}
