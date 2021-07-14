package br.com.casadocodigo.controller;

import br.com.casadocodigo.controller.request.ClientRequest;
import br.com.casadocodigo.controller.response.ClientResponse;
import br.com.casadocodigo.model.Client;
import br.com.casadocodigo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/clients")
public class ClientController {

    @Autowired private ClientRepository clientRepository;
    @Autowired private EntityManager entityManager;

    @PostMapping
    public ResponseEntity<ClientResponse> saveClient(@RequestBody @Valid ClientRequest clientRequest){
        Client client = clientRepository.save(clientRequest.toModel(entityManager));
        return ResponseEntity.ok(new ClientResponse(client));
    }
}
