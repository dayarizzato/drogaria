package br.dev.dayana.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.dev.dayana.drogaria.domain.Fabricante;
import br.dev.dayana.drogaria.domain.ItemVenda;
import br.dev.dayana.drogaria.domain.Produto;

public class ItemVendaDAOTest {

	@Test
	@Ignore
	public void salvar() {

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(new Long("4"));

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(new Long("4")); // ou (3L)

		ItemVenda itemVenda = new ItemVenda();
		itemVenda.setQuantidade(new Short("30"));
		itemVenda.setPrecoParcial(new BigDecimal("30.00"));

		itemVenda.setProduto(produto);
		itemVenda.setFabricante(fabricante);

		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		itemVendaDAO.salvar(itemVenda);

		System.out.println("Produto salvo com sucesso!");
	}

	@Test
	@Ignore
	public void listar() {

		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		List<ItemVenda> itensVenda = itemVendaDAO.listar();

		for (ItemVenda itemVenda : itensVenda) {
			System.out.println(itemVenda.getCodigo() + itemVenda.getProduto().getDescricao());
		}

	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 1L;

		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(codigo);

		if (itemVenda == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado");
			System.err.println(itemVenda.getCodigo() + itemVenda.getProduto().getDescricao());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 1L;

		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(codigo);

		if (itemVenda == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			itemVendaDAO.excluir(itemVenda);
			System.out.println("Resgitro removido!");
			System.out.println(itemVenda.getCodigo() + itemVenda.getProduto().getDescricao());
		}

	}
	@Test
	public void editar() {
		Long codigo = 2L;

		ItemVendaDAO itemVendaDAO = new ItemVendaDAO();
		ItemVenda itemVenda = itemVendaDAO.buscar(codigo);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(new Long("3")); // ou (3L)
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(new Long("3"));
		
		if (itemVenda == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro editado - Antes:");
			System.out.println(itemVenda.getCodigo() + itemVenda.getProduto().getDescricao());
			
			itemVenda.setCodigo(codigo);
			itemVenda.setProduto(produto);
			itemVenda.setFabricante(fabricante);
			itemVenda.setPrecoParcial(new BigDecimal("20.00"));
			itemVenda.setQuantidade(new Short("10"));
			itemVendaDAO.editar(itemVenda);
			
		}
	}
}