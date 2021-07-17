package br.dev.dayana.drogaria.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import br.dev.dayana.drogaria.util.HibernateUtil;

/*
 * Como tenho 11 itens no pacote domain, preciso referenciar de uma forma genérica eles
 */
public class GenericDAO<Entidade> {// Este nome genérico dado ele interpreta como se fosse um tipo e eu posso gerar
									// objetos a partir desse tipo

	private Class<Entidade> classe;// toda vez que alguém instanciar o DAO eu quero que o 'classe' descubra p class

	@SuppressWarnings("unchecked")
	public GenericDAO() {// faço um contrutor onde ele chama o comando
		this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];// pega classe filha
	}

	public void salvar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;// tipo transaction controla transações- ou faz tudo ou faz nada
		try {
			transacao = sessao.beginTransaction();// se der algum problema ele não faz, ele desfaz as coisas
			sessao.save(entidade);// passo o objeto entidade e salvo ele aqui
			transacao.commit();// confirmo transação

		} catch (RuntimeException erro) {// para desfazer preciso do catch
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;// repropago o erro
		} finally {// se der certo ou errado ele fecha a sessão
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked") // LISTAR
	public List<Entidade> listar() {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {// começo a fazer a listagem
			Criteria consulta = sessao.createCriteria(classe); // realiza consulta - chamo a classe para que ela obtenha
																// o class
			List<Entidade> resultado = consulta.list();
			return resultado;// guarda todos os objetos que eu tenho
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	@SuppressWarnings("unchecked") // BUSCAR
	public Entidade buscar(Long codigo) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		try {// começo a fazer a listagem
			Criteria consulta = sessao.createCriteria(classe); // restrições no criterio
			consulta.add(Restrictions.idEq(codigo));// id eq - pega o valor digitado e compara com a chave primaria da
													// sua entidade
			Entidade resultado = (Entidade) consulta.uniqueResult(); // unic result - usado quando voce só retorna 1
			return resultado;// guarda todos os objetos que eu tenho
		} catch (RuntimeException erro) {
			throw erro;
		} finally {
			sessao.close();
		}
	}

	public void excluir(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;// tipo transaction controla transações- ou faz tudo ou faz nada
		try {
			transacao = sessao.beginTransaction();// se der algum problema ele não faz, ele desfaz as coisas
			sessao.delete(entidade);// passo o objeto entidade e deleto ele aqui
			transacao.commit();// confirmo transação

		} catch (RuntimeException erro) {// para desfazer preciso do catch
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;// repropago o erro
		} finally {// se der certo ou errado ele fecha a sessão
			sessao.close();
		}
	}

	public void editar(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		Transaction transacao = null;// tipo transaction controla transações- ou faz tudo ou faz nada
		try {
			transacao = sessao.beginTransaction();// se der algum problema ele não faz, ele desfaz as coisas
			sessao.update(entidade);// passo o objeto entidade e atualizo ele aqui
			transacao.commit();// confirmo transação

		} catch (RuntimeException erro) {// para desfazer preciso do catch
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;// repropago o erro
		} finally {// se der certo ou errado ele fecha a sessão
			sessao.close();
		}
	}

	public void merge(Entidade entidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();// abre sessão
		Transaction transacao = null;// tipo transaction controla transações- ou faz tudo ou faz nada
		try {
			transacao = sessao.beginTransaction();// se der algum problema ele não faz, ele desfaz as coisas
			sessao.merge(entidade);// passo o objeto entidade e salvo ele aqui
			transacao.commit();// confirmo transação

		} catch (RuntimeException erro) {// para desfazer preciso do catch
			if (transacao != null) {
				transacao.rollback();
			}
			throw erro;// repropago o erro
		} finally {// se der certo ou errado ele fecha a sessão
			sessao.close();
		}
	}
}
