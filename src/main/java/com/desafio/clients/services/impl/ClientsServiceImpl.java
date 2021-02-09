package com.desafio.clients.services.impl;

import com.desafio.clients.dtos.ClientDTO;
import com.desafio.clients.dtos.ClientsResponseDTO;
import com.desafio.clients.dtos.ResponseDTO;
import com.desafio.clients.repository.impl.ClientsRepositoryImpl;
import com.desafio.clients.services.ClientsService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ClientsServiceImpl implements ClientsService {
    private final ClientsRepositoryImpl clientsDb;

    public ClientsServiceImpl(ClientsRepositoryImpl clientsDb) {
        this.clientsDb = clientsDb;
    }

    @Override
    public ResponseDTO addClient(ClientDTO client) {
        if(validateClient(client)){
            if(clientsDb.addClient(client)){
             return new ResponseDTO("00", "Se dio de alta correctamente el usuario");
            } else {
                return new ResponseDTO("99", "Ocurrio un error en la base de datos");
            }
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente invalido");
        }
    }

    @Override
    public ClientsResponseDTO getAllClient() {
        List<ClientDTO> queryResult = clientsDb.getAllClient();
        ClientsResponseDTO response = new ClientsResponseDTO();
        if(queryResult.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se obtuvieron resultados para la busqueda");
        } else {
            response.setResult(queryResult);
            response.setMessage("La consulta se realizo correctamente");
            response.setStatusCode("200");
        }

        return response;
    }

    @Override
    public ClientsResponseDTO getClientByProvince(String province) {
        List<ClientDTO> queryResult = clientsDb.getClientByProvince(province);
        ClientsResponseDTO response = new ClientsResponseDTO();
        if(queryResult.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se obtuvieron resultados para la busqueda");
        } else {
            response.setResult(queryResult);
            response.setMessage("La consulta se realizo correctamente");
            response.setStatusCode("200");
        }

        return response;
    }

    private boolean validateClient(ClientDTO client) {

        if(client.getFirstName() == null){
            return false;
        }
        if (client.getLastName() == null){
            return false;
        }
        if(client.getEmail() == null){
            return false;
        }
        if(client.getProvince() == null){
            return false;
        }

        return true;
    }
}
