package kg.mega.hotel1.mapper;

import kg.mega.hotel1.dto.PriceDTO;
import kg.mega.hotel1.model.Price;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PriceMapper {
    PriceMapper INSTANCE= Mappers.getMapper(PriceMapper.class);
    Price toEntity(PriceDTO priceDTO);
    PriceDTO toDTO(Price price);
    List<Price> toEntityList(List<PriceDTO>priceDTOS);
    List<PriceDTO>toDTOList(List<Price> prices);
}
