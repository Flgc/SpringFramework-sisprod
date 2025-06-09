package com.uerjzo.sisprod.service;

import java.util.List;
import com.uerjzo.sisprod.entity.Produto;

public interface IProdutoService {

	/**
	 * Retorna as características de um dado produto <br />
	 * cujo atributo id é fornecido como parâmetro
	 * 
	 * @param id
	 * @return Produto
	 * 
	 **/

	public Produto findById(Long id);

	public Produto findByNome(String nome);

	public List<Produto> findAll();

	public List<Produto> findAllOrderedByNome();

	public List<Produto> findAllByNome(String nome);

	public void save(Produto produto);

	public int update(Produto produto, Long id);

	public int delete(Long id);

}
