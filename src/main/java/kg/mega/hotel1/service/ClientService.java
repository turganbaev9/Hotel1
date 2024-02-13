package kg.mega.hotel1.service;

import kg.mega.hotel1.dto.ClientDTO;

import java.util.List;

public interface ClientService {
ClientDTO save(ClientDTO clientDTO);
ClientDTO update(ClientDTO clientDTO);
ClientDTO findById(Long id);
List<ClientDTO>findAll();
void  delete(Long id);
}
