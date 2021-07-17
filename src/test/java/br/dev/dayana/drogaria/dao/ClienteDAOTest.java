package br.dev.dayana.drogaria.dao;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.dev.dayana.drogaria.domain.Cliente;
import br.dev.dayana.drogaria.domain.Pessoa;

public class ClienteDAOTest {
	@Test

	public void salvar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);

		Cliente cliente = new Cliente();
		cliente.setDataCadastro(new Date());// uso quando quero que apareça a data somente, padrão americano
		cliente.setLiberado(true);
		cliente.setPessoa(pessoa);

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);

		System.out.println("Cliente salvo com sucesso!");
	}

	@Test
	@Ignore
	public void listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.listar();

		System.out.println("Total de registros encontrados: " + resultado.size());

		for (Cliente cliente : resultado) {
			System.out.println(cliente.getDataCadastro() + " - " + cliente.getLiberado() + " - " + cliente.getPessoa());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if (cliente == null) {
			System.out.println("Cliente não encontrado!");
		} else {
			System.out.println("Cliente encontrado!");
		}
		System.out.println(cliente.getDataCadastro() + " - " + cliente.getLiberado() + " - " + cliente.getPessoa());
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);

		if (cliente == null) {
			System.out.println("Cliente não encontrado!");
		} else {
			clienteDAO.excluir(cliente);
			System.out.println("Cliente deletado!");

		}
	}
	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigo);
		
		if (cliente == null) {
			System.out.println("Registro não encontrado!");
		} else {
			System.out.println("Registro editado");
			
			cliente.setDataCadastro(new Date());
			cliente.setLiberado(false);
			clienteDAO.editar(cliente);
		}
	}

}
