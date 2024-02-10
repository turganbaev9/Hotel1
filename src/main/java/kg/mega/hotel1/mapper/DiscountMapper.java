package kg.mega.hotel1.mapper;

import kg.mega.hotel1.dto.DiscountDTO;
import kg.mega.hotel1.model.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DiscountMapper {
    DiscountMapper INSTANCE= Mappers.getMapper(DiscountMapper.class);
    Discount toEntity(DiscountDTO discountDTO);
    DiscountDTO toDTO(Discount discount);
    List<Discount> toEntityList(List<DiscountDTO> discountDTOS);
    List<DiscountDTO>toDTOList(List<Discount>discounts);

}
