package com.uerjzo.sisprod.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "bd", name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_idproduto_seq")
	private Long idproduto;

	@Column(name = "nome", nullable = false)
	private String nome;

	public Produto() {
		super();
	}

	public Produto(Long idproduto) {
		super();
		this.idproduto = idproduto;
	}

	public Produto(Long idproduto, String nome) {
		super();
		this.idproduto = idproduto;
		this.nome = nome;
	}

	public Produto(String nome) {
		super();
		this.nome = nome;
	}

	public Long getIdproduto() {
		return idproduto;
	}

	public void setIdproduto(Long idproduto) {
		this.idproduto = idproduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idproduto, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(idproduto, other.idproduto) && Objects.equals(nome, other.nome);
	}
}