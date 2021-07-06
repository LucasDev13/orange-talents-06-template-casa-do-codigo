package br.com.casadocodigo.controller;

import br.com.casadocodigo.controller.request.BookRequest;
import br.com.casadocodigo.controller.response.BookResponse;
import br.com.casadocodigo.controller.response.BookResponseDetail;
import br.com.casadocodigo.model.Book;
import br.com.casadocodigo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    @GetMapping(value = "/{id}")
    public ResponseEntity<BookResponseDetail> detailById(@PathVariable Long id){
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent()){
            return ResponseEntity.ok(new BookResponseDetail(book.get()));
        }
        return ResponseEntity.notFound().build();
    }

}