package br.com.casadocodigo.controller;

import br.com.casadocodigo.repository.CategoryRepository;
import br.com.casadocodigo.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity<?> saveCategory(@RequestBody @Valid CategoryRequest categoryRequest){
        categoryRepository.save(categoryRequest.toModel());
        return ResponseEntity.ok().build();
    }
}
