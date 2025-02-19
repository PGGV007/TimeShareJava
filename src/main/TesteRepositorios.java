package main;
import dados.IRepositorio;
import dados.RepositorioGerenteSet;
import dados.RepositorioUserSet;
import classesBasicas.Gerente;
import classesBasicas.User;

public class TesteRepositorios {
	
	public static void  main(String [] args) {
		
		Gerente g = new Gerente("joão","123","321"); 
		User u = new User("Joshua","321","123"); 
		
		IRepositorio repUser= new RepositorioUserSet();
		IRepositorio repGer = new RepositorioGerenteSet(); 
		
		repUser.adicionar(u);
		repGer.adicionar(g);
		
		repUser.listar();
		
	}
	
}
