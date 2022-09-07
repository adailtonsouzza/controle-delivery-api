package br.com.acert.controledeliveryapi.repositories;

import br.com.acert.controledeliveryapi.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
