package br.com.caelum.livraria.webservice;

import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.jws.WebResult;
import javax.jws.WebService;

import br.com.caelum.livraria.dao.LivroDao;
import br.com.caelum.livraria.modelo.Livro;

@WebService
@Stateful
public class LivrariaWS {

	@Inject
	LivroDao dao;

	@WebResult(name="autores")
	public List<Livro> getLivrosPeloNome(String nome){

		System.out.println("Livrariaws: Procurando pelo nome : " + nome);
		
		return dao.livrosPeloNome(nome);
	}
	
}
