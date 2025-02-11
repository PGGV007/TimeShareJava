package business;

import classesBasicas.User;
import classesBasicas.Registro;


public class Reserva {
	
	private User userDemanda; 
	private Registro registro; 
	
	public Reserva(User user, Registro registro) {
		this.registro = registro; 
		this.userDemanda = user; 
	}
	
	public void reservar(User userDemanda) {
		if(!userDemanda.equals(registro.getOwner())) {
			
		}
	}
	/*
	 * Classe incompleta (não testar) 
	 * */
	
	
	
}
