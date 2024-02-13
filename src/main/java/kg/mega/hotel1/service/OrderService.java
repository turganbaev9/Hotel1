package kg.mega.hotel1.service;

import kg.mega.hotel1.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO save(OrderDTO orderDTO);
    OrderDTO update(OrderDTO orderDTO);
    OrderDTO findById(Long id);
    List<OrderDTO> findAll();
    void delete(Long id);
}