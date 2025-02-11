package business;

import classesBasicas.User;
import classesBasicas.Registro;

public class Transfer {
	
	private User userDestino; 
	private User userOferta; 
	private Registro registro; 
	
	
	Transfer(User destino, User oferta, Registro registro){
		this.registro = registro; 
		this.userDestino = destino;
		this.userOferta = oferta; 
	}
	
	public void transfer(User destino, Registro registro)
	{
		if(destino != null) {
			registro.setUser(destino);
		}else {
			throw new  IllegalArgumentException("Usuátrio inválido"); 
		}
		
	}	
	
}
