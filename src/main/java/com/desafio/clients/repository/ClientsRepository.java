package com.desafio.clients.repository;

import com.desafio.clients.dtos.ClientDTO;

import java.util.List;

public interface ClientsRepository {

    Boolean addClient(ClientDTO client);
    List<ClientDTO> getAllClient();
    List<ClientDTO>  getClientByProvince(String province);
}
