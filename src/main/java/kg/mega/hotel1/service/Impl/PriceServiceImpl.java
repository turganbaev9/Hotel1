package kg.mega.hotel1.service.Impl;

import kg.mega.hotel1.crud.PriceRepo;
import kg.mega.hotel1.dto.PriceDTO;
import kg.mega.hotel1.mapper.PriceMapper;
import kg.mega.hotel1.model.Price;
import kg.mega.hotel1.service.PriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriceServiceImpl implements PriceService {
    private final PriceRepo priceRepo;
    @Override
    public PriceDTO save(PriceDTO priceDTO) {

        Price price= PriceMapper.INSTANCE.toEntity(priceDTO);
        priceRepo.save(price);
        return PriceMapper.INSTANCE.toDTO(price);
    }

    @Override
    public PriceDTO update(PriceDTO priceDTO) {
        Price find=priceRepo.findById(priceDTO.getId()).orElseThrow(()->new EntityNotFoundException("price with ID"+priceDTO.getId()+"not found"));
        Optional.ofNullable(priceDTO.getPrice()).ifPresent(find::setPrice);
        Optional.ofNullable(priceDTO.getStartDate()).ifPresent(find::setStartDate);
        Optional.ofNullable(priceDTO.getEndDate()).ifPresent(find::setEndDate);
        Price updated=priceRepo.save(find);
        return PriceMapper.INSTANCE.toDTO(updated);
    }

    @Override
    public PriceDTO findById(Long id) {
        Price findP=priceRepo.findById(id).get();

        return PriceMapper.INSTANCE.toDTO(findP);
    }

    @Override
    public List<PriceDTO> findAll() {
        List<Price>prices=priceRepo.findAll();
        return PriceMapper.INSTANCE.toDTOList(prices);
    }

    @Override
    public void delete(Long id) {
        priceRepo.deleteById(id);
    }
}

