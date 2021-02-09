package com.desafio.clients.controller;

import com.desafio.clients.dtos.ClientDTO;
import com.desafio.clients.dtos.ClientsResponseDTO;
import com.desafio.clients.dtos.ResponseDTO;
import com.desafio.clients.services.impl.ClientsServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1/clients")
public class ClientsAPIController {
    private final ClientsServiceImpl clientsService;

    public ClientsAPIController(ClientsServiceImpl clientsService) {
        this.clientsService = clientsService;
    }

    @GetMapping(path="/get/all")
    public ClientsResponseDTO getAllClients(){
        return clientsService.getAllClient();
    }

    @GetMapping(path="/get/{province}")
    public ClientsResponseDTO getClientsByProvince(@PathVariable String province){
        return clientsService.getClientByProvince(province);
    }

    @PostMapping(value = "/add")
    public ResponseDTO addClient(@RequestBody ClientDTO request){
        return clientsService.addClient(request);
    }


}
