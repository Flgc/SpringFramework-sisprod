package com.uerjzo.sisprod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.uerjzo.sisprod.entity.Produto;

public interface IProdutoRepository extends JpaRepository<Produto, Long> {

	@Query("select p from Produto p order by p.nome asc")
	List<Produto> findAllOrderedByNome();

	@Query("select p.id as id, p.nome as nome from Produto p where nome = :nome")
	Produto findByNome(@Param("nome") String nome);

	@Modifying
	@Query("update Produto p set p.nome = ?2 where p.id = ?1")
	int update(Long id, String nome);

	@Modifying
	@Query("delete Produto p where p.id = ?1")
	int delete(Long id);

}