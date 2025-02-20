package main;

 import java.io.IOException;
import java.time.LocalDate;

import business.Transfer;
import classesBasicas.Propriedade;
import classesBasicas.Registro;
 import classesBasicas.User;
 import dados.IRepositorio;
 import dados.RepositorioRegistroSet;
 import dados.RepositorioUserSet;
import exceptions.EmptyArchiveException;
import exceptions.ObjectOutsideArrayException;

public class TesteTransfer {

	public static void main(String[] args) {
		
		IRepositorio repositorioRegi = new RepositorioRegistroSet("arquivo_registro.dat");
		IRepositorio repositorioUser = new RepositorioUserSet("arquivo_user.dat");
		
		LocalDate date = LocalDate.now(); 
		Transfer t = new Transfer(repositorioRegi,repositorioUser); 
		Propriedade propriedade = new Propriedade("Praia","bonita","Rural",100,20, date); 
		
		User u = new User("123", "jonh","123");
		User j = new User("321", "joshua","123");
		Registro r = new Registro(((byte)1), propriedade, u);
		
		try {
			repositorioRegi.adicionar(r);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			repositorioUser.adicionar(j);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			repositorioUser.adicionar(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t.transfer(u.getIdUser(), r.getIdRegistro());
			//t.transfer(j.getIdUser(), r.getIdRegistro());
		} catch (ObjectOutsideArrayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		
		System.out.println(r.getOwner());
		
		

	}

}
