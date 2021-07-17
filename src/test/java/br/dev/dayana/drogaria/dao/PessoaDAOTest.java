package br.dev.dayana.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.dev.dayana.drogaria.domain.Pessoa;

public class PessoaDAOTest {
	@Test
	
	public void salvar() {

		Pessoa pessoa = new Pessoa();

		pessoa.setNome("Ana");
		pessoa.setCpf("20512566839");
		pessoa.setRg("802583292");
		pessoa.setRua("Antonio João");
		pessoa.setNumero(new Short("10"));
		pessoa.setBairro("Jardim Planalto");
		pessoa.setCep("01040-180");
		pessoa.setComplemento("");
		pessoa.setTelefone("18-25621320");
		pessoa.setCelular("18-992587878");
		pessoa.setEmail("ana@gmail.com");
		PessoaDAO pessoaDAO = new PessoaDAO();
		pessoaDAO.salvar(pessoa);

		System.out.println("Pessoa cadastrada com sucesso!");
	}

	@Test
	@Ignore
	public void listar() {

		PessoaDAO pessoaDAO = new PessoaDAO();
		List<Pessoa> resultado = pessoaDAO.listar();

		System.out.println("Total de registros encontrados: " + resultado.size());

		for (Pessoa pessoa : resultado) {
			System.out.println(pessoa.getNome() + (" - ") + pessoa.getCpf() + (" - ") + pessoa.getRg() + (" - ")
					+ pessoa.getRua() + (" - ") + pessoa.getNumero() + (" - ") + pessoa.getBairro() + (" - ")
					+ pessoa.getCep() + (" - ") + pessoa.getComplemento() + (" - ") + pessoa.getTelefone() + (" - ")
					+ pessoa.getCelular() + (" - ") + pessoa.getEmail());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 3L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		if (pessoa == null) {
			System.out.println("Registro não encontrado!");
		} else {
			System.out.println("Registro encontrado!");
		}
		System.out.println(pessoa.getNome() + (" - ") + pessoa.getCpf() + (" - ") + pessoa.getRg() + (" - ")
				+ pessoa.getRua() + (" - ") + pessoa.getNumero() + (" - ") + pessoa.getBairro() + (" - ")
				+ pessoa.getCep() + (" - ") + pessoa.getComplemento() + (" - ") + pessoa.getTelefone() + (" - ")
				+ pessoa.getCelular() + (" - ") + pessoa.getEmail());
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 3L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		if (pessoa == null) {
			System.out.println("Registro não encontrado!");
		} else {
			pessoaDAO.excluir(pessoa);
			System.out.println("Registro deletado!");

		}

	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigo);

		if (pessoa == null) {
			System.out.println("Registro não encontrado!");
		} else {
			System.out.println("Registro editado");

			pessoa.setNome("Mary");
			pessoa.setCpf("20593566839");
			pessoa.setRg("802586792");
			pessoa.setRua("Antonio Augusto");
			pessoa.setNumero(new Short("20"));
			pessoa.setBairro("Jardim Antonia");
			pessoa.setCep("06440-180");
			pessoa.setComplemento("Torre Bella 221");
			pessoa.setTelefone("18-36921320");
			pessoa.setCelular("18-996259878");
			pessoa.setEmail("antonia@gmail.com");
			pessoaDAO.editar(pessoa);

		}

	}

}
