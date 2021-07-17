package br.dev.dayana.drogaria.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
public class Cliente extends GenericDomain {

	@Column(nullable = false)
	@Temporal(TemporalType.DATE) // escolhe se é data, hora ou os dois
	private Date dataCadastro; // onde guarda data e hora

	@Column(nullable = false)
	private Boolean liberado;

	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;// chave estrangeira

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getLiberado() {
		return liberado;
	}

	public void setLiberado(Boolean liberado) {
		this.liberado = liberado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}


