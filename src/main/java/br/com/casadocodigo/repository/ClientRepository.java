package br.com.casadocodigo.repository;

import br.com.casadocodigo.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
