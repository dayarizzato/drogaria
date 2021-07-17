package br.dev.dayana.drogaria.dao;



import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.dev.dayana.drogaria.domain.Fabricante;

public class FabricanteDAOTest {
	@Test
	@Ignore 
	public void salvar() {
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Cimed");

		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.salvar(fabricante);
	}

	@Test
	@Ignore
	public void listar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		List<Fabricante> resultado = fabricanteDAO.listar();

		System.out.println("Total de registros encontrados: " + resultado.size());

		for (Fabricante fabricante : resultado) {
			System.out.println(fabricante.getDescricao());
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);

		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			System.out.println("Resgitro encontrado!");
		}

		System.out.println(fabricante.getDescricao());

	}

	@Test
	@Ignore
	public void excluir() {
	    Long codigo = 5L;
	    FabricanteDAO fabricanteDAO = new FabricanteDAO();
	    Fabricante fabricante = fabricanteDAO.buscar(codigo);
			
		if (fabricante == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			fabricanteDAO.excluir(fabricante);
			System.out.println("Resgitro removido!");
			System.out.println(fabricante.getDescricao() + "-" );
			}
			
	}
	@SuppressWarnings("null")
	@Test
	@Ignore
	public void editar(){
		
		Long codigo = 1L;
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigo);
		
		if(fabricante == null) {
			System.out.println("Nenhum registro editado!");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}else {
			
			fabricante.setDescricao("Chevrolet");
			fabricanteDAO.editar(fabricante);
					
			System.out.println("Registro editado!");
			System.out.println(fabricante.getCodigo() + " - " + fabricante.getDescricao());
		}
		
	}
	@Test
	@Ignore
	public void mergeIncluir() {
//		Fabricante fabricante = new Fabricante();// verifica se o id existe no banco
//		fabricante.setDescricao("Fabricante A");// se estiver vazio ele faz uma inserção
//
//		FabricanteDAO fabricanteDAO = new FabricanteDAO();
//		fabricanteDAO.merge(fabricante);
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();// update
		Fabricante fabricante = fabricanteDAO.buscar(5L);
		fabricante.setDescricao("Fabricante B");
		fabricanteDAO.merge(fabricante);
	}
}
