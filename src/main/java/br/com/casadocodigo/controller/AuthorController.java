package br.com.casadocodigo.controller;

import br.com.casadocodigo.dto.AuthorDto;
import br.com.casadocodigo.model.Author;
import br.com.casadocodigo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> save(@Valid @RequestBody AuthorDto authorDto){
        Author author = new Author(authorDto);
        authorRepository.save(author);
        return ResponseEntity.ok().build();
    }
}
