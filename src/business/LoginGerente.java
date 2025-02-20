package business;
import java.io.IOException;

import classesBasicas.Gerente;
import dados.IRepositorio;
import exceptions.EmptyArchiveException;
import exceptions.ObjectOutsideArrayException;
import exceptions.UnregisteredGerenteException;
import exceptions.WrongPasswordException;


public class LoginGerente {
	
	IRepositorio repositorio; 
	
	public LoginGerente(IRepositorio repositorio) {
		this.repositorio = repositorio; 
	}
	
	public boolean efetuarLogin(String id, String senha) throws WrongPasswordException, UnregisteredGerenteException, ObjectOutsideArrayException, ClassNotFoundException, IOException, EmptyArchiveException  {
		
		if(repositorio.existe(id)) { 
			
			if(((Gerente)repositorio.procurar(id)).getSenha().equals(senha)) {
				return true; 
			}else {
				throw new WrongPasswordException(); 
			}
			
		}else {
			throw new UnregisteredGerenteException(); 
		}
		
		
	}
	
}
