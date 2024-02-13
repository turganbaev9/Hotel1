package kg.mega.hotel1.service;

import kg.mega.hotel1.dto.PriceDTO;

import java.util.List;

public interface PriceService {
    PriceDTO save(PriceDTO priceDTO);
    PriceDTO update(PriceDTO priceDTO );
    PriceDTO findById(Long id);
    List<PriceDTO> findAll();
    void delete(Long id);
}
