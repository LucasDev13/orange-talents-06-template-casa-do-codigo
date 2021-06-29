package br.com.casadocodigo.repository;

import br.com.casadocodigo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
