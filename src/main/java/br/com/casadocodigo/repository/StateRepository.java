package br.com.casadocodigo.repository;

import br.com.casadocodigo.model.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
