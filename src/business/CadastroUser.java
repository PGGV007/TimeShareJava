package business;

import dados.IRepositorio;
import exceptions.EmptyArchiveException;
import exceptions.ObjectOutsideArrayException;

import java.io.IOException;

import classesBasicas.User;
import exceptions.UserAlreadyExistsException;
import exceptions.UnregisteredUserException;

public class CadastroUser {
	
	private IRepositorio repositorio; 
	
	public CadastroUser(IRepositorio repositorio) {
		this.repositorio = repositorio; 
	}
	
	public void cadastrar(User a) throws UserAlreadyExistsException, IOException, ClassNotFoundException, EmptyArchiveException {
		if(a == null) {
			throw new IllegalArgumentException("Parâmetro inválido"); 
		}
		else {
			if(this.existe(a) == false) {
				this.repositorio.adicionar(a);
			}else {
				throw new UserAlreadyExistsException();  
			}
		}
	}
	
	public boolean existe(User a) throws ClassNotFoundException, IOException, EmptyArchiveException  {
		return repositorio.existe(a.getIdUser()); 
	}
	
	public void descadastrar(String id) throws ObjectOutsideArrayException, UnregisteredUserException, ClassNotFoundException, IOException, EmptyArchiveException {
		User u = (User) repositorio.procurar(id); 
		
		
		if(u != null) {
			if(repositorio.existe(id) ==true) {
				repositorio.retirar(u);
			}else {
				throw new UnregisteredUserException(); 
			}
		}else {
			throw new IllegalArgumentException("Id inválida"); 
		}
		
	}
	
	public void atualizar(String idUser) throws ObjectOutsideArrayException, UnregisteredUserException, ClassNotFoundException, IOException, EmptyArchiveException {
		if(idUser != null) {
			if(repositorio.existe(idUser) == true) {
				repositorio.atualizar((User)repositorio.procurar(idUser));
				System.out.println(repositorio.procurar(idUser));
			}else {
				throw new UnregisteredUserException(); 
			}
		}else {
			throw new UnregisteredUserException(); 
		}
	}
	
}
