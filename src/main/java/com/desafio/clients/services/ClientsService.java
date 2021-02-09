package com.desafio.clients.services;

import com.desafio.clients.dtos.ClientDTO;
import com.desafio.clients.dtos.ClientsResponseDTO;
import com.desafio.clients.dtos.ResponseDTO;

import java.util.List;

public interface ClientsService {

    ResponseDTO addClient(ClientDTO client);
    ClientsResponseDTO getAllClient();
    ClientsResponseDTO  getClientByProvince(String province);
}
