package main;

 import java.time.LocalDate;

import business.Transfer;
import classesBasicas.Propriedade;
import classesBasicas.Registro;
 import classesBasicas.User;
 import dados.IRepositorio;
 import dados.RepositorioRegistroSet;
 import dados.RepositorioUserSet;
import exceptions.ObjectOutsideArrayException;

public class TesteTransfer {

	public static void main(String[] args) {
		
		IRepositorio repositorioRegi = new RepositorioRegistroSet();
		IRepositorio repositorioUser = new RepositorioUserSet();
		
		LocalDate date = LocalDate.now(); 
		Transfer t = new Transfer(repositorioRegi,repositorioUser); 
		Propriedade propriedade = new Propriedade("Praia","bonita","Rural",100,20, date); 
		
		User u = new User("123", "jonh");
		User j = new User("321", "joshua");
		Registro r = new Registro(((byte)1), propriedade, u);
		
		repositorioRegi.adicionar(r);
		repositorioUser.adicionar(j);
		repositorioUser.adicionar(u);
		try {
			t.transfer(u.getIdUser(), r.getIdRegistro());
			//t.transfer(j.getIdUser(), r.getIdRegistro());
		} catch (ObjectOutsideArrayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(r.getOwner());
		
		

	}

}
