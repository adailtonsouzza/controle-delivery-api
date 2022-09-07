package br.com.acert.controledeliveryapi.repositories;

import br.com.acert.controledeliveryapi.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
