package br.com.casadocodigo.controller;

import br.com.casadocodigo.controller.request.StateRequest;
import br.com.casadocodigo.repository.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/states")
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> saveState(@Valid @RequestBody StateRequest stateRequest){
            System.out.println(stateRequest.getNameState());
            stateRepository.save(stateRequest.toModel(entityManager));
           return ResponseEntity.ok().build();

//        return ResponseEntity.notFound().build();
    }
}
