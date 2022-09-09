package br.com.acert.controledeliveryapi.repositories;

import br.com.acert.controledeliveryapi.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
