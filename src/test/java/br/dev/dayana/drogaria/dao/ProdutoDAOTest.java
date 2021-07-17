package br.dev.dayana.drogaria.dao;


import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.dev.dayana.drogaria.domain.Fabricante;
import br.dev.dayana.drogaria.domain.Produto;

public class ProdutoDAOTest {
	@Test
	
	public void salvar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(new Long("1")); // ou (3L)

		Produto produto = new Produto();
		produto.setDescricao("Desodorante Rexona");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("12.00"));
		produto.setQuantidade(new Short("20"));

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);

		System.out.println("Produto salvo com sucesso!");
	}

	@Test
	@Ignore
	public void listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();

		System.out.println("Total de registros encontrados: " + resultado.size());

		for (Fabricante fabricante : resultado) {
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 3L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro encontrado:");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigo = 2L;
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		if (produto == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			produtoDAO.excluir(produto);
			System.out.println("Resgitro removido!");
			System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + " - " + produto.getFabricante()
					+ " - " + produto.getPreco() + " - " + produto.getQuantidade());
		}

	}

	@Test
	@Ignore
	public void editar() {
		Long codigo = 1L;

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(new Long("2")); // ou (3L)

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigo);

		if (produto == null) {
			System.out.println("Nenhum registro encontrado");
		} else {
			System.out.println("Registro editado - Antes:");
			System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + " - " + produto.getFabricante()
					+ " - " + produto.getPreco() + " - " + produto.getQuantidade());

			produto.setDescricao("Tandrilax 50mg com 20 comprimidos");
			produto.setFabricante(fabricante);
			;
			produto.setPreco(new BigDecimal("30.90"));
			produto.setQuantidade(new Short("10"));
			produtoDAO.editar(produto);

			System.out.println("Registro editado - Depois:");
			System.out.println(produto.getCodigo() + " - " + produto.getDescricao() + " - " + produto.getFabricante()
					+ " - " + produto.getPreco() + " - " + produto.getQuantidade());
		}

	}
}
