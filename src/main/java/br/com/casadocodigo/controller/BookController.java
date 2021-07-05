package br.com.casadocodigo.controller;

import br.com.casadocodigo.controller.request.BookRequest;
import br.com.casadocodigo.model.Category;
import br.com.casadocodigo.repository.BookRepository;
import br.com.casadocodigo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> saveBook(@RequestBody @Valid BookRequest bookRequest){
        bookRepository.save(bookRequest.toModel(entityManager));
        return ResponseEntity.ok().build();
    }
}
