package kg.mega.hotel1.service.Impl;

import kg.mega.hotel1.crud.OrderRepo;
import kg.mega.hotel1.dto.OrderDTO;
import kg.mega.hotel1.mapper.OrderMapper;
import kg.mega.hotel1.model.Order;
import kg.mega.hotel1.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        Order order= OrderMapper.INSTANCE.toEntity(orderDTO);
        orderRepo.save(order);
        return OrderMapper.INSTANCE.toDTO(order);
    }

    @Override
    public OrderDTO update(OrderDTO orderDTO) {
        Order find=orderRepo.findById(orderDTO.getId()).orElseThrow(()->new EntityNotFoundException("order with ID"+orderDTO.getId()+"not found"));
        Optional.ofNullable(orderDTO.getDateTimeFrom()).ifPresent(find::setDateTimeFrom);
        Optional.ofNullable(orderDTO.getDateTimeTo()).ifPresent(find::setDateTimeTo);
        Optional.ofNullable(orderDTO.getPriceBeforeDiscount()).ifPresent(find::setPriceBeforeDiscount);
        Optional.ofNullable(orderDTO.getPriceWithDiscount()).ifPresent(find::setPriceWithDiscount);
        Order updated=orderRepo.save(find);
        return OrderMapper.INSTANCE.toDTO(updated);
    }

    @Override
    public OrderDTO findById(Long id) {
        Order finded=orderRepo.findById(id).get();

        return OrderMapper.INSTANCE.toDTO(finded);
    }

    @Override
    public List<OrderDTO> findAll() {
        List<Order> orders=orderRepo.findAll();
        return OrderMapper.INSTANCE.toDTOList(orders);
    }

    @Override
    public void delete(Long id) {
        orderRepo.deleteById(id);

    }
}
