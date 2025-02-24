package main;
import classesBasicas.User;
import dados.IRepositorio;
import dados.RepositorioReservaSet;
import dados.RepositorioUserSet;
import exceptions.EmptyArchiveException;
import exceptions.ObjectOutsideArrayException;
import exceptions.UnregisteredUserException;
import exceptions.WrongPasswordException;

import java.io.IOException;

import business.LoginUser;
import business.Reserva;

public class TesteLogin {

	public static void main(String[] args) {
		
		User u = new User("123","Jonh","321");
		IRepositorio repositorio = new RepositorioUserSet("arquivo_user.dat"); 
		RepositorioReservaSet repositorioReserva = new RepositorioReservaSet("arquivo_registro.dat"); 
		//Reserva r = new Reserva(); 
		try {
			repositorio.adicionar(u);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LoginUser login = new LoginUser(repositorio, repositorioReserva);
		
		try {
			login.efetuarLogin( u.getIdUser(), "0");
			System.out.println("Sucesso");
			System.out.println(u.getIdUser());
		} catch (WrongPasswordException e) {
			
			e.printStackTrace();
			System.out.println("Senha errada");
		} catch (UnregisteredUserException e) {
			
			e.printStackTrace();
			System.out.println("User não registrado");
		} catch (ObjectOutsideArrayException e) {
			
			e.printStackTrace();
			System.out.println("Objeto fora do repositorio");
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
		
	}

}
