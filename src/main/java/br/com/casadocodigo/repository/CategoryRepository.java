package br.com.casadocodigo.repository;

import br.com.casadocodigo.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
