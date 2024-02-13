package kg.mega.hotel1.service;

import kg.mega.hotel1.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {
    DiscountDTO save(DiscountDTO discountDTO);
    DiscountDTO update(DiscountDTO discountDTO );
    DiscountDTO findById(Long id);
    List<DiscountDTO> findAll();
    void delete(Long id);
}
