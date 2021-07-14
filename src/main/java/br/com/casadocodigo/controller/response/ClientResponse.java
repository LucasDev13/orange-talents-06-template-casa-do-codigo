package br.com.casadocodigo.controller.response;

import br.com.casadocodigo.model.Client;

public class ClientResponse {

    private Long id;

    public ClientResponse(Client client){
        id = client.getId();
    }

    public Long getId() {
        return id;
    }
}
