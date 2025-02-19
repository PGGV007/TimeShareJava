package dados;

import classesBasicas.Registro;
import classesBasicas.User;
import exceptions.ObjectOutsideArrayException;
import business.Reserva;

public class RepositorioReservaSet extends RepositorioGenericoSet implements IRepositorio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7235730711312171961L;
	
	@Override
	public Object procurar(String id) throws ObjectOutsideArrayException {
		
		boolean teste = false; 
		Reserva j = null; ; 
		
		for(Object obj : repositorio) {
			Reserva p = (Reserva) obj; 
		   teste = p.getIdReserva().equals(id); 
		   if(teste == true) {
			   j = p; 
			   break; 
		   }
		}
		
		if(j == null) {
			throw new ObjectOutsideArrayException(); 
		}
		return j;
		
	}
	
	@Override
	public boolean existe(String id) {
		
		boolean teste = false; 
		
		for(Object obj : repositorio) {
			Reserva p = (Reserva) obj; 
			teste = p.getIdReserva().equals(id); 
		    if(teste == true) { 
		    	break; 
		    }
		}
		
		return teste; 
		 
	}

}
