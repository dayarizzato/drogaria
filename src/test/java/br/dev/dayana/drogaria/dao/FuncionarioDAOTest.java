package br.dev.dayana.drogaria.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.dev.dayana.drogaria.domain.Funcionario;
import br.dev.dayana.drogaria.domain.Pessoa;

public class FuncionarioDAOTest {
	@Test
	@Ignore
	public void salvar() {

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = new Funcionario();

		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);

		funcionario.setCarteiraTrabalho("565656");
		funcionario.setDataAdmissao(new Date());
		funcionario.setPessoa(pessoa);
		funcionarioDAO.salvar(funcionario);

	}

	@Test
	@Ignore
	public void listar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> resultado = funcionarioDAO.listar();

		System.out.println("Total de registros encontrados: " + resultado.size());

		for (Funcionario funcionario : resultado) {
			System.out.println(funcionario.getCarteiraTrabalho() + funcionario.getDataAdmissao()
					+ funcionario.getPessoa().getNome());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1L);

		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			System.out.println("Registro encontrado!");
			System.out.println(funcionario.getCarteiraTrabalho() + funcionario.getDataAdmissao()
					+ funcionario.getPessoa().getNome());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1L);

		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			funcionarioDAO.excluir(funcionario);
			System.out.println("Registro  excluído!");
			System.out.println(funcionario.getCarteiraTrabalho() + funcionario.getDataAdmissao()
					+ funcionario.getPessoa().getNome());
		}
	}
	@Test
	public void editar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(3L);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1L);

		if (funcionario == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println(funcionario.getCarteiraTrabalho() + funcionario.getDataAdmissao()
					+ funcionario.getPessoa().getNome());

			funcionario.setCarteiraTrabalho("454545");
			funcionario.setDataAdmissao(new Date());
			funcionario.setPessoa(pessoa);

		}
	}
}