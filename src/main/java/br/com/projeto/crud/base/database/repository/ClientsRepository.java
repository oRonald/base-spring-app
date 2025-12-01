package br.com.projeto.crud.base.database.repository;

import br.com.projeto.crud.base.database.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ClientsRepository extends JpaRepository<Clients, UUID> {

    Optional<Clients> findById(UUID id);
}
