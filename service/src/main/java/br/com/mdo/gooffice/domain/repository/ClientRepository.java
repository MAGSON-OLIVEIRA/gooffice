package br.com.mdo.gooffice.domain.repository;

import br.com.mdo.gooffice.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Cliente, String> {}
