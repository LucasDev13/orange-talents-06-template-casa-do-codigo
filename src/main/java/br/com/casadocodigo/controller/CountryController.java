package br.com.casadocodigo.controller;

import br.com.casadocodigo.controller.request.CountryRequest;
import br.com.casadocodigo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/countrys")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> saveCountry(@Valid @RequestBody CountryRequest countryRequest){
        if(countryRequest != null){
            countryRepository.save(countryRequest.toModel());
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
   }
}
