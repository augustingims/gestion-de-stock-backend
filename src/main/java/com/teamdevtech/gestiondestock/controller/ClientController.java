package com.teamdevtech.gestiondestock.controller;

import com.teamdevtech.gestiondestock.controller.api.ClientApi;
import com.teamdevtech.gestiondestock.dto.ClientDto;
import com.teamdevtech.gestiondestock.services.ClientService;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController implements ClientApi {

  private final ClientService clientService;

  public ClientController(ClientService clientService) {
    this.clientService = clientService;
  }

  @Override
  public ClientDto save(ClientDto dto) {
    return clientService.save(dto);
  }

  @Override
  public ClientDto findById(Integer id) {
    return clientService.findById(id);
  }

  @Override
  public List<ClientDto> findAll() {
    return clientService.findAll();
  }

  @Override
  public void delete(Integer id) {
    clientService.delete(id);
  }
}
