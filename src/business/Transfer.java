package business;

import classesBasicas.User;
import classesBasicas.Registro;
import dados.IRepositorio;
import exceptions.ObjectOutsideArrayException;

public class Transfer {
	
	private IRepositorio repositorioRegistro; 
	private IRepositorio repositorioUser;  
	
	
	public Transfer(IRepositorio repositorioRegistro, IRepositorio repositorioUser){
		this.repositorioRegistro = repositorioRegistro;
		this.repositorioUser = repositorioUser; 
	}
	
	public void transfer(String idUser, String idRegistro) throws ObjectOutsideArrayException 
	{
		if(idUser != null && repositorioUser.existe(idUser) && !(((Registro)repositorioRegistro.procurar(idRegistro)).getOwner()).equals(((User)repositorioUser.procurar(idUser))) ) {
			if(repositorioRegistro.existe(idRegistro)) {
				Registro r = (Registro)repositorioRegistro.procurar(idRegistro);
				r.setUser((User)repositorioUser.procurar(idUser));
				r.setForSale(false);
			}else {
				throw new IllegalArgumentException("Registro inválido"); 
			}
		}else {
			throw new  IllegalArgumentException("Usuário inválido"); 
		}
		
	}	
	
}
