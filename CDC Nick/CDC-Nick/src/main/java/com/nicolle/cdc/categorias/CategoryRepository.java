package com.nicolle.cdc.categorias;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends CrudRepository<Categoria, Long>{
	

	Optional<Categoria> findById(Long Id);

	Optional<Categoria> findByNome(String nome);

}
