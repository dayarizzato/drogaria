package br.dev.dayana.drogaria.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Entity
public class Cidade extends GenericDomain{//cidade herda o código de genericDomain
	
	@Column(length = 50, nullable = false)
	private String nome;
	
	@ManyToOne // muitos para um - muitas cidades tem um estado
	@JoinColumn(nullable = false)//para chave estrangeira não posso usar @column, personaliza propriedades de colunas que são chaves estrangeiras
	private Estado estado; // vai ser a chave estrangeira - no framework ele é um objeto q esta ligado

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	
}
