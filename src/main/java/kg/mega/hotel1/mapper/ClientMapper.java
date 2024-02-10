package kg.mega.hotel1.mapper;

import kg.mega.hotel1.dto.ClientDTO;
import kg.mega.hotel1.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientMapper {
ClientMapper INSTANCE= Mappers.getMapper(ClientMapper.class);
ClientDTO toDTO(Client client);
Client toEntity(ClientDTO clientDTO);
List<Client>toEntityList(List<ClientDTO>clientDTOS);

List<ClientDTO>toDTOList(List<Client>clients);
}
