package br.com.casadocodigo.controller;

import br.com.casadocodigo.config.validation.ValidatorNameCategory;
import br.com.casadocodigo.repository.CategoryRepository;
import br.com.casadocodigo.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ValidatorNameCategory validatorNameCategory;

    @InitBinder
    public void init(WebDataBinder binder){
        binder.addValidators(validatorNameCategory);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> saveCategory(@RequestBody @Valid CategoryRequest categoryRequest){
        categoryRepository.save(categoryRequest.toModel());
        return ResponseEntity.ok().build();
    }
}
