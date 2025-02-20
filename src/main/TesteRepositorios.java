package main;
import dados.IRepositorio;
import dados.RepositorioGerenteSet;
import dados.RepositorioUserSet;
import exceptions.EmptyArchiveException;

import java.io.IOException;

import classesBasicas.Gerente;
import classesBasicas.User;

public class TesteRepositorios {
	
	public static void  main(String [] args) {
		
		Gerente g = new Gerente("joão","123","321"); 
		User u = new User("Joshua","321","123"); 
		
		IRepositorio repUser= new RepositorioUserSet("arquivo_user.dat");
		IRepositorio repGer = new RepositorioGerenteSet("arquivo_gerente.dat"); 
		
		try {
			repUser.adicionar(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			repGer.adicionar(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			repUser.listar();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EmptyArchiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			repGer.listar();
		} catch (ClassNotFoundException | IOException | EmptyArchiveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
