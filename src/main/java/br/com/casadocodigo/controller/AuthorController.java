package br.com.casadocodigo.controller;

import br.com.casadocodigo.config.validation.ValidatorEmail;
import br.com.casadocodigo.dto.AuthorDto;
import br.com.casadocodigo.model.Author;
import br.com.casadocodigo.repository.AuthorRepository;
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
    public ResponseEntity<?> save(@Valid @RequestBody AuthorDto authorDto){
        authorRepository.save(authorDto.toModel());
        return ResponseEntity.ok().build();
    }
}
