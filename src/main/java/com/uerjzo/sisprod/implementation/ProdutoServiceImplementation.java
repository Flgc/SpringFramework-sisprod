package com.uerjzo.sisprod.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uerjzo.sisprod.entity.Produto;
import com.uerjzo.sisprod.repository.IProdutoRepository;
import com.uerjzo.sisprod.service.IProdutoService;

@Service
public class ProdutoServiceImplementation implements IProdutoService {

	@Autowired
	private IProdutoRepository repository;

	@Override
	public Produto findById(Long id) {
		return repository.getReferenceById(id);
	}

	@Override
	public Produto findByNome(String nome) {
		return repository.findByNome(nome);
	}

	@Override
	public List<Produto> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Produto> findAllOrderedByNome() {
		return repository.findAllOrderedByNome();
	}

	@Override
	public List<Produto> findAllByNome(String nome) {
		Produto p = new Produto();
		p.setNome(nome);
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase();
		Example<Produto> example = Example.of(p, matcher);
		return repository.findAll(example);
	}

	@Transactional(readOnly = false)
	@Override
	public void save(Produto produto) {
		repository.save(produto);
	}

	@Transactional(readOnly = false)
	@Override
	public int update(Produto produto, Long id) {
		return repository.update(id, produto.getNome());
	}

	@Transactional(readOnly = false)
	@Override
	public int delete(Long id) {
		return repository.delete(id);
	}

}
