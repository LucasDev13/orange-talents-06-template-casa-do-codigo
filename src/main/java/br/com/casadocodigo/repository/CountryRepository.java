package br.com.casadocodigo.repository;

import br.com.casadocodigo.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
