package br.com.caelum.livraria.interceptador;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
/**/
public class LogInterceptador {

	@AroundInvoke
	public Object interceptador(InvocationContext context) throws Exception {
		
		long millis =  System.currentTimeMillis();
	
		Object o = context.proceed();
		
		String metodo = context.getMethod().getName();
		
		String nomeClasse = context.getTarget().getClass().getSimpleName();
		
		System.out.println(nomeClasse + ", " + metodo);
		System.out.println("Tempo gasto:  " + (System.currentTimeMillis() - millis));

		return o;
	}
	
}
