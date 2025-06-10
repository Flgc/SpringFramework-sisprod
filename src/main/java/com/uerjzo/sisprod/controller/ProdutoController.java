package com.uerjzo.sisprod.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.uerjzo.sisprod.entity.Produto;
import com.uerjzo.sisprod.service.IProdutoService;

@Controller
public class ProdutoController {
	@Autowired
	private IProdutoService produtoService;

	@GetMapping("/home")
	public String save() {
		return "sisprod.html";
	}

	@GetMapping("/produto/listar/{id}")
	public String findById(Model model, @PathVariable Long id) {
		model.addAttribute("produto", produtoService.findById(id));

		return "listarProdutos.html";
	}

	@GetMapping("/produto/listar/{nome}")
	public String findById(Model model, @PathVariable String nome) {
		model.addAttribute("produto", produtoService.findByNome(nome));

		return "listarProdutos.html";
	}

	@GetMapping("/produto/listar")
	public String findAll(Model model) {		
		model.addAttribute("produto", produtoService.findAllOrderedByNome());

		return "listarProdutos.html";
	}

	@GetMapping("/produto/inserir")
	public String inserir(Model model) {

		Produto produto = new Produto();
		model.addAttribute("produto", produto);

		return "inserirProduto.html";
	}

	@PostMapping("/produto/salvar")
	public String save(Model model, @ModelAttribute("produto") Produto produto) {

		produtoService.save(produto);

		return "redirect:/home";
	}

	@GetMapping("/produto/alterar/{id}")
	public String inserir(Model model, @PathVariable Long id) {

		model.addAttribute("produto", produtoService.findById(id));

		return "alterarProduto.html";
	}

	@PostMapping("produto/salvar/{id}")
	public String save(Model model, @ModelAttribute("produto") Produto produto, @PathVariable Long id) {

		produtoService.update(produto, id);

		return "redirect:/home";
	}

	@GetMapping("/produto/excluir/{id}")
	public String excluir(Model model, @PathVariable Long id) {

		produtoService.delete(id);

		return "redirect:/home";
	}
}
