package br.com.acert.controledeliveryapi.repositories;

import br.com.acert.controledeliveryapi.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
