package br.com.acert.controledeliveryapi.repositories;

import br.com.acert.controledeliveryapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
