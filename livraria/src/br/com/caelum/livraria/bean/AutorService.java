package br.com.caelum.livraria.bean;

import java.util.List;

import javax.ejb.Stateful;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import br.com.caelum.livraria.dao.AutorDao;
import br.com.caelum.livraria.modelo.Autor;

@Stateful
public class AutorService {

	@Inject 
	AutorDao dao;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void adiciona(Autor autor) {
		
		this.dao.salva(autor);
		//throw new RuntimeException("[ERRO] Erro lançado para testar o rollback da transação.");
		
		throw new LivrariaException();
		
	}
	
	public List<Autor> todosAutores(){
		
		return this.dao.todosAutores();
	}
	
}
