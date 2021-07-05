package br.com.casadocodigo.controller;

import br.com.casadocodigo.controller.request.BookRequest;
import br.com.casadocodigo.controller.response.BookResponse;
import br.com.casadocodigo.model.Author;
import br.com.casadocodigo.model.Book;
import br.com.casadocodigo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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

    @GetMapping
    @Transactional
    public ResponseEntity<List<Book>> listBook(){
        List<Book> list = bookRepository.findAll();
        return ResponseEntity.ok(list);
    }

}
