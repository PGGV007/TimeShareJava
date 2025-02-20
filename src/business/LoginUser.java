package business;
import classesBasicas.User;
import dados.IRepositorio;
import exceptions.ObjectOutsideArrayException;
import exceptions.UnregisteredUserException;
import exceptions.WrongPasswordException;


public class LoginUser {
	
	IRepositorio repositorio; 
	
	public LoginUser(IRepositorio repositorio) {
		this.repositorio = repositorio; 
	}
	
	public boolean efetuarLogin( String id, String senha) throws WrongPasswordException, UnregisteredUserException, ObjectOutsideArrayException  {
		
		if(repositorio.existe(id)) { 
			
			if(((User)repositorio.procurar(id)).getSenha().equals(senha)) {
				return true; 
			}else {
				throw new WrongPasswordException(); 
			}
			
		}else {
			throw new UnregisteredUserException(); 
		}
		
		
	}
	
}
