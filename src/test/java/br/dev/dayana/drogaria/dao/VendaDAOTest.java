package br.dev.dayana.drogaria.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.dev.dayana.drogaria.domain.Cliente;
import br.dev.dayana.drogaria.domain.Funcionario;
import br.dev.dayana.drogaria.domain.Venda;

public class VendaDAOTest {

	@Test
	@Ignore
	public void salvar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(1L);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1L);

		VendaDAO vendaDAO = new VendaDAO();

		Venda venda = new Venda();

		venda.setHorario(new Date());
		venda.setPrecoTotal(new BigDecimal("300.00"));
		venda.setCliente(cliente);
		venda.setFuncionario(funcionario);

		vendaDAO.salvar(venda);

		System.out.println("Venda cadastrada com sucesso!");

	}

	@Test
	@Ignore
	public void listar() {
		VendaDAO vendaDAO = new VendaDAO();
		List<Venda> resultado = vendaDAO.listar();

		System.out.println("Total de registros encontrados: " + resultado.size());

		for (Venda venda : resultado) {
			System.out.println(venda.getHorario() + " -  " + venda.getPrecoTotal() + " -  " + venda.getCliente()
					+ " -  " + venda.getFuncionario());
		}

	}

	@Test
	@Ignore
	public void buscar() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(1L);

		if (venda == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			System.out.println("Registro encontrado!");
			System.out.println(venda.getHorario() + " -  " + venda.getPrecoTotal() + " -  " + venda.getCliente()
					+ " -  " + venda.getFuncionario());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(1L);

		if (venda == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			vendaDAO.excluir(venda);
			System.out.println("Registro  excluído!");
			System.out.println(venda.getHorario() + " -  " + venda.getPrecoTotal() + " -  " + venda.getCliente()
					+ " -  " + venda.getFuncionario());
		}
	}
	
	@Test
	public void editar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(3L);

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		Funcionario funcionario = funcionarioDAO.buscar(1L);

		VendaDAO vendaDAO = new VendaDAO();
		Venda venda = vendaDAO.buscar(2L);

		if (venda == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println(venda.getHorario() + " -  " + venda.getPrecoTotal() + " -  "
					+ venda.getCliente().getPessoa().getNome() + " -  " + venda.getFuncionario().getPessoa().getNome());

			venda.setHorario(new Date());
			venda.setPrecoTotal(new BigDecimal("700.00"));
			venda.setCliente(cliente);
			venda.setFuncionario(funcionario);
			vendaDAO.editar(venda);

		}
	}

}
