package br.com.acert.controledeliveryapi.repositories;

import br.com.acert.controledeliveryapi.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
