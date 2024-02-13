package kg.mega.hotel1.service.Impl;

import kg.mega.hotel1.crud.DiscountRepo;
import kg.mega.hotel1.crud.RoomRepo;
import kg.mega.hotel1.dto.DiscountDTO;
import kg.mega.hotel1.mapper.DiscountMapper;
import kg.mega.hotel1.model.Discount;
import kg.mega.hotel1.model.Room;
import kg.mega.hotel1.service.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepo discountRepo;
    private  final RoomRepo roomRepo;
    @Override
    public DiscountDTO save(DiscountDTO discountDTO) {
        Discount discount= DiscountMapper.INSTANCE.toEntity(discountDTO);
        Room room=roomRepo.findById(discountDTO.getRoom().getId()).orElseThrow(()->new NoSuchElementException("room with Id"+discountDTO.getRoom().getId()+"not found"));
        LocalDate startDate=discountDTO.getStartDate();
        LocalDate endDate=discountDTO.getEndDate();
        Integer countdays= Math.toIntExact(ChronoUnit.DAYS.between(startDate, endDate));
        discount.setCountDays(countdays);
        discount.setRoom(room);
        discountRepo.save(discount);
        return DiscountMapper.INSTANCE.toDTO(discount);
    }

    @Override
    public DiscountDTO update(DiscountDTO discountDTO) {
        Discount find=discountRepo.findById(discountDTO.getId()).orElseThrow(()->new EntityNotFoundException("discount with this ID" + discountDTO.getId()+ "not found")) ;
        Optional.ofNullable(discountDTO.getDisc()).ifPresent(find::setDisc);
        Optional.ofNullable(discountDTO.getCountDays()).ifPresent(find::setCountDays);
        Optional.ofNullable(discountDTO.getNameDisc()).ifPresent(find::setNameDisc);
        Optional.ofNullable(discountDTO.getStartDate()).ifPresent(find::setStartDate);
        Optional.ofNullable(discountDTO.getEndDate()).ifPresent(find::setEndDate);
        Discount updated=discountRepo.save(find);
        return DiscountMapper.INSTANCE.toDTO(updated);
    }

    @Override
    public DiscountDTO findById(Long id) {
        Discount find=discountRepo.findById(id).orElseThrow(() -> new  EntityNotFoundException("discount with this ID"+id+"not found"));

        return DiscountMapper.INSTANCE.toDTO(find);
    }

    @Override
    public List<DiscountDTO> findAll() {
        List<Discount> discounts=discountRepo.findAll();
        return  DiscountMapper.INSTANCE.toDTOList(discounts);
    }

    @Override
    public void delete(Long id) {
        discountRepo.deleteById(id);
    }
}