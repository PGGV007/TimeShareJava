package business;

import classesBasicas.User;

import java.io.IOException;
import java.io.Serializable;

import classesBasicas.GeradorId;
import classesBasicas.Registro;
import dados.IRepositorio;
import exceptions.EmptyArchiveException;
import exceptions.ObjectOutsideArrayException;

public class Transfer implements Serializable {
	

	private static final long serialVersionUID = -5755980943068625147L;
	private IRepositorio repositorioRegistro; 
	private IRepositorio repositorioUser;  
	private final  String id; 
	
	
	
	public Transfer(IRepositorio repositorioRegistro, IRepositorio repositorioUser){
		this.repositorioRegistro = repositorioRegistro;
		this.repositorioUser = repositorioUser; 
		this.id = GeradorId.geradorHexId(6);
	}
	
	public void transfer(String idUser, String idRegistro) throws ObjectOutsideArrayException, ClassNotFoundException, IOException, EmptyArchiveException 
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

	public String getIdTransfer() {
		return id;
	}	
	
}
