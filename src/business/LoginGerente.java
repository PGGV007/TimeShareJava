package business;
import classesBasicas.Gerente;
import dados.IRepositorio;
import exceptions.ObjectOutsideArrayException;
import exceptions.UnregisteredGerenteException;
import exceptions.WrongPasswordException;


public class LoginGerente {
	
	IRepositorio repositorio; 
	
	public LoginGerente(IRepositorio repositorio) {
		this.repositorio = repositorio; 
	}
	
	public boolean efetuarLogin(String id, String senha) throws WrongPasswordException, UnregisteredGerenteException, ObjectOutsideArrayException  {
		
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
