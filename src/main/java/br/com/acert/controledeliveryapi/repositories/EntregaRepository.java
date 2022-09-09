package br.com.acert.controledeliveryapi.repositories;

import br.com.acert.controledeliveryapi.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntregaRepository extends JpaRepository<Entrega, Long> {
}
