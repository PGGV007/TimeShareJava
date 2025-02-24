package main;

import java.io.IOException;

import business.CadastroUser;
import classesBasicas.User;
import dados.IRepositorio;
import dados.RepositorioUserSet;
import exceptions.EmptyArchiveException;
import exceptions.ObjectOutsideArrayException;
import exceptions.UnregisteredUserException;
import exceptions.UserAlreadyExistsException;
public class TesteCadastroUser {

	public static void main(String[] args) {
		
		IRepositorio repositorioUser = new RepositorioUserSet("arquivo_user.dat"); 
		CadastroUser cadUser = new CadastroUser(repositorioUser); 
		
		User u = new User("456","Miguel","987");
		
		try {
			cadUser.cadastrar(u);
		}catch(IOException| ClassNotFoundException| EmptyArchiveException e){
			System.out.println("Problema de arquivamento 1"); 
			e.printStackTrace();
		}catch(UserAlreadyExistsException e) { 
			e.printStackTrace();
		}
		
		u.setNome("Joshua");
		
		try {
			cadUser.atualizar(u);
		}catch(IOException| ClassNotFoundException| EmptyArchiveException|ObjectOutsideArrayException| UnregisteredUserException e) {
			System.out.println("Problema de arquivamento 2"); 
			e.printStackTrace();
		}
		//System.out.println(u.getNome()); 
		try {
			repositorioUser.listar();
		} catch (ClassNotFoundException | IOException | EmptyArchiveException e) {
			e.printStackTrace();
		} 
		try {
			cadUser.descadastrar(u.getIdUser());
		}catch(IOException| ClassNotFoundException| EmptyArchiveException|ObjectOutsideArrayException| UnregisteredUserException e) {
			System.out.println("Problema de arquivamento 3"); 
			e.printStackTrace();
		}
		
		try {
			repositorioUser.listar();
		} catch (ClassNotFoundException | IOException | EmptyArchiveException e) {
			e.printStackTrace();
		} 
		
	}

}
