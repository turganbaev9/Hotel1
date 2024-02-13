package kg.mega.hotel1.service.Impl;

import kg.mega.hotel1.crud.ClientRepo;
import kg.mega.hotel1.dto.ClientDTO;
import kg.mega.hotel1.mapper.ClientMapper;
import kg.mega.hotel1.model.Client;
import kg.mega.hotel1.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepo clientRepo;
    @Override
    public ClientDTO save(ClientDTO clientDTO) {
        Client client=ClientMapper.INSTANCE.toEntity(clientDTO);
        LocalDate currentDate=LocalDate.now();
        LocalDate birthDate=client.getBirthData();
        Long reallyage= ChronoUnit.YEARS.between(currentDate,birthDate);
        client.setAge(Math.toIntExact(reallyage));
        clientRepo.save(client);
        return ClientMapper.INSTANCE.toDTO(client);
    }

    @Override
    public ClientDTO update(ClientDTO clientDTO) {
        Client exist=clientRepo.findById(clientDTO.getId()).orElseThrow(()->new EntityNotFoundException("Client with this ID" + clientDTO.getId()+"not found"));
        if (clientDTO.getName()!=null){
            exist.setName(clientDTO.getName());
        }if (clientDTO.getAge()!=null){
            exist.setAge(clientDTO.getAge());
        }if (clientDTO.getBirthData()!=null){
            exist.setBirthData(clientDTO.getBirthData());
        }if (clientDTO.getWithFamily()!=null){
            exist.setWithFamily(clientDTO.getWithFamily());
        }if (clientDTO.getReasonForCome()!=null){
            exist.setReasonForCome(clientDTO.getReasonForCome());
        }
        Client updated=clientRepo.save(exist);
        return ClientMapper.INSTANCE.toDTO(updated);
    }

    @Override
    public ClientDTO findById(Long id) {
        Client find=clientRepo.findById(id).get();
        return ClientMapper.INSTANCE.toDTO(find);
    }

    @Override
    public List<ClientDTO> findAll() {
        List<Client>find=clientRepo.findAll();
        return
                ClientMapper.INSTANCE.toDTOList(find);
    }

    @Override
    public void delete(Long id) {
        clientRepo.deleteById(id);
    }
}

