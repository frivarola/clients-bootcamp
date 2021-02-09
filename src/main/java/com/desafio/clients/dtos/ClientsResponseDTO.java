package com.desafio.clients.dtos;

import java.util.List;

public class ClientsResponseDTO {
    private String statusCode;
    private String message;
    private List<ClientDTO> result;

    public ClientsResponseDTO() {
    }

    public ClientsResponseDTO(String statusCode, String message, List<ClientDTO> result) {
        this.statusCode = statusCode;
        this.message = message;
        this.result = result;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<ClientDTO> getResult() {
        return result;
    }

    public void setResult(List<ClientDTO> result) {
        this.result = result;
    }
}
