package com.desafio.clients.repository.impl;

import com.desafio.clients.dtos.ClientDTO;
import com.desafio.clients.repository.ClientsRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClientsRepositoryImpl implements ClientsRepository {
    private static List<ClientDTO> clientsDB;
    private static String pathDB = "src/main/java/com/desafio/clients/repository/clients.json";

    static {
        clientsDB = loadDatabase();
    }

    @Override
    public Boolean addClient(ClientDTO client) {
        return clientsDB.add(client);
    }

    @Override
    public List<ClientDTO> getAllClient() {
        List<ClientDTO> result = clientsDB;
        return result;
    }

    @Override
    public List<ClientDTO> getClientByProvince(String province) {
        List<ClientDTO> queryResult = new ArrayList<>();
        //clientsDB.stream().filter((ClientDTO c) -> c.getProvince().equals(province)).forEach(c -> queryResult.add(c));
        for (ClientDTO c :
                clientsDB) {
            if (province.equals(c.getProvince())) {
                queryResult.add(c);
            }
        }
        return queryResult;
    }

    private static List<ClientDTO> loadDatabase() {
        List<ClientDTO> clients = new ArrayList<>();
        File fileDb = null;

        try {
            fileDb = ResourceUtils.getFile(pathDB);
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<ClientDTO>> tf = new TypeReference<>() {
            };
            clients = mapper.readValue(fileDb, tf);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return clients;
    }

    private static void writeDatabase() {
        File fileDb = null;

        try {
            fileDb = ResourceUtils.getFile(pathDB);
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<ClientDTO>> tf = new TypeReference<>() {
            };
            mapper.writeValue(fileDb, clientsDB);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
