package br.com.caelum.livraria.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.caelum.livraria.modelo.Livro;

@Stateless
public class LivroDao {

	@PersistenceContext
	private EntityManager manager;
	
	public void salva(Livro livro) {
		manager.persist(livro);
	}
	
	public List<Livro> todosLivros() {
		return manager.createQuery("Select l from Livro l ", Livro.class).getResultList();
	}
	
	public List<Livro> livrosPeloNome(String nome){
		
		TypedQuery<Livro> query = manager.createQuery("select l form livro where l.titulo like :pTitulo", Livro.class)
				.setParameter("Titulo", "%"+ nome + "%");
		
		return query.getResultList();
	}
	
}
