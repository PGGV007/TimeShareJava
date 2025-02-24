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
	
	public void transfer(String idUser, Registro re) throws ObjectOutsideArrayException, ClassNotFoundException, IOException, EmptyArchiveException 
	{
		if(re.getForSale()) {
		
			if(idUser != null && repositorioUser.existe(idUser) && !(((Registro)repositorioRegistro.procurar(re.getIdRegistro())).getOwner()).equals(((User)repositorioUser.procurar(idUser))) ) {
				if(repositorioRegistro.existe(re.getIdRegistro())) {
				
					re.setUser((User)repositorioUser.procurar(idUser));
					re.setForSale(false);
					repositorioRegistro.atualizar(re);
				}else {
					throw new IllegalArgumentException("Registro inválido"); 
				}
			}else {
				throw new  IllegalArgumentException("Usuário inválido"); 
			}
		}else {
			throw new IllegalArgumentException("Registro não está à venda");
		}
	}

	public String getIdTransfer() {
		return id;
	}	
	
}
