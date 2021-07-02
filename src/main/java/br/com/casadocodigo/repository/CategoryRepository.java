package br.com.casadocodigo.repository;

import br.com.casadocodigo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByNameCategory(String nameCategory);
}
