package br.dev.dayana.drogaria.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("serial") // serve para avisar o compilador para ignorar warnings tipo serial nessa classe
@MappedSuperclass // serve para dizer que a classe não corresponde a uma tabela, mas ela pode ser usada por outros para gerar tabelas
public class GenericDomain implements Serializable {
	@Id // serve para dizer para o código que ele é uma chave primária
	@GeneratedValue(strategy = GenerationType.AUTO) // as anotações podem ter propriedades, qdo ela tem propriedade
													// uso()
	// idendity é quando o cara digita
	// auto quando o banco vai gerenciar
	private Long codigo;

	public Long getCodigo() {// permissão para leitura
		return codigo;
	}

	public void setCodigo(Long codigo) {// permissão para escrita
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return String.format("%s[codigo=%d]", getClass().getSimpleName(), getCodigo());
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenericDomain other = (GenericDomain) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
}
