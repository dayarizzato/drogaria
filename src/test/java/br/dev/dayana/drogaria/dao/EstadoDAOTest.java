package br.dev.dayana.drogaria.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.dev.dayana.drogaria.domain.Estado;

public class EstadoDAOTest {
	@Test
	//@Ignore // ele é um teste mas vai ser ignorado
	public void salvar() {
		Estado estado = new Estado();
		estado.setNome("Rio de Janeiro");
		estado.setSigla("RJ");

		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(estado);
	}

	@Test
	@Ignore
	public void listar() {
		EstadoDAO estadoDAO = new EstadoDAO();
		List<Estado> resultado = estadoDAO.listar();

		System.out.println("Total de registros encontrados:" + resultado.size());

		for (Estado estado : resultado) { // vai exibir um a um o resultado
			System.out.println(estado.getSigla() + "-" + estado.getNome());// percorre a lista uma a uma

		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigo = 2L; // L - long
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);

		if (estado == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			System.out.println("Resgitro encontrado!");
		}

		System.out.println(estado.getSigla() + "-" + estado.getNome());
	}

	@Test
	@Ignore
	public void excluir() { // como o estado tem filhos(é pai) não pode ser excluído
		Long codigo = 1L; // L - long
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo); // pesquisa

		if (estado == null) {
			System.out.println("Nenhum registro encontrado!");
		} else {
			estadoDAO.excluir(estado);
			System.out.println("Resgitro removido!");
			System.out.println(estado.getSigla() + "-" + estado.getNome());
		}

	}

	@Test
	@Ignore
	public void editar(){
		Long codigo = 3L;
		EstadoDAO estadoDAO = new EstadoDAO();
		Estado estado = estadoDAO.buscar(codigo);
		
		if(estado == null){
			System.out.println("Nenhum registro encontrado");
		}else{
			System.out.println("Registro editado - Antes:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
			
			estado.setNome("Santa Catarina");
			estado.setSigla("SC");
			estadoDAO.editar(estado);
			
			System.out.println("Registro editado - Depois:");
			System.out.println(estado.getCodigo() + " - " + estado.getSigla() + " - " + estado.getNome());
		}
				
	}

}
