package br.com.caelum.livraria.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.interceptor.Interceptors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.caelum.livraria.interceptador.LogInterceptador;
import br.com.caelum.livraria.modelo.Autor;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@Interceptors({LogInterceptador.class})
public class AutorDao {	

	@PersistenceContext
	private EntityManager manager;
	
	@PostConstruct
	public void aposCriacao(){
		System.out.println("Criou uma instancia de AutorDAO");
	}

	//@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void salva(Autor autor) {
		
		//System.out.println("Salvando o AutorDAO");
		
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		manager.persist(autor); 
		
		//System.out.println("Salvou o AutorDAO");
		
		//throw new RuntimeException("Serviço externo deu erro!");
	}
	
	public List<Autor> todosAutores() {
		return manager.createQuery("Select a from Autor a ", Autor.class).getResultList();
	}

	public Autor buscaPelaId(Integer autorId) {
		Autor autor = this.manager.find(Autor.class, autorId);
		return autor;
	}
	
}
