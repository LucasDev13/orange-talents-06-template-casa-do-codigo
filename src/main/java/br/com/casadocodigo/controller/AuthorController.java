package br.com.casadocodigo.controller;

import br.com.casadocodigo.config.validation.ValidatorEmail;
import br.com.casadocodigo.model.Author;
import br.com.casadocodigo.repository.AuthorRepository;
import br.com.casadocodigo.request.AuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private ValidatorEmail validatorEmail;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(validatorEmail);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> saveAuthor(@Valid @RequestBody AuthorRequest authorRequest){
        authorRepository.save(authorRequest.toModel());
        return ResponseEntity.ok().build();
    }
}
