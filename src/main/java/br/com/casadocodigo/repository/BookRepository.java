package br.com.casadocodigo.repository;

import br.com.casadocodigo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
