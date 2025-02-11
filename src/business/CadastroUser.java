package business;

import dados.IRepositorio;
import exceptions.ObjectOutsideArrayException;
import classesBasicas.User;
import exceptions.UserAlreadyExists;

public class CadastroUser {
	
	private IRepositorio repositorio; 
	
	public void cadastrar(User a) throws UserAlreadyExists {
		if(a == null) {
			throw new IllegalArgumentException("Parâmetro inválido"); 
		}
		else {
			if(this.existe(a) == false) {
				this.repositorio.adicionar(a);
			}else {
				throw new UserAlreadyExists();  
			}
		}
	}
	
	public boolean existe(User a)  {
		return repositorio.existe(a.getIdUser()); 
	}
	
	public void descadastrar(String id) throws ObjectOutsideArrayException {
		Object obj = repositorio.procurar(id); 
		
		
		if(obj != null) {
			repositorio.retirar(obj);
		}
		
	}
	
	public void atualizar(User a) throws ObjectOutsideArrayException {
		if(a != null) {
			repositorio.atualizar(a);
		}
	}
	
}
