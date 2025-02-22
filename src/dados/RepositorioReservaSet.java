package dados;


import exceptions.EmptyArchiveException;
import exceptions.ObjectOutsideArrayException;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import business.Reserva;
import classesBasicas.User;

public class RepositorioReservaSet extends RepositorioGenericoSet implements IRepositorio, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7235730711312171961L;
	
	public RepositorioReservaSet(String arquivo) {
		super(arquivo); 
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object procurar(String id) throws ObjectOutsideArrayException, ClassNotFoundException, IOException, EmptyArchiveException {
		
		boolean teste = false; 
		Reserva j = null; ; 
		Set<Object> clone = (Set<Object>)carregarDados(getArquivo());
		for(Object obj : clone) {
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
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(String id) throws ClassNotFoundException, IOException, EmptyArchiveException {
		
		boolean teste = false; 
		Set<Object> clone;
		try {
			
			clone = (Set<Object>)carregarDados(getArquivo());
		} catch (EmptyArchiveException e) {
			System.out.println("rodou");
			return false; 	
		} catch (ClassCastException e) {
			return false;
		}
		for(Object obj : clone) {
			Reserva p = (Reserva) obj; 
			teste = p.getIdReserva().equals(id); 
		    if(teste == true) { 
		    	break; 
		    }
		}
		
		return teste; 
		 
	}
	
	public Set<Reserva> procurarUser(User owner){
		
		Set<Reserva> reservas = new HashSet<Reserva>(); 
	
		if(owner != null) {
			
			for(Object obj : repositorio) {
				
				Reserva r = (Reserva) obj; 
				if(r.getRenter().equals(owner)) {
					reservas.add(r);
				}
				
			}
			
		}else {
			
		}
		return reservas; 
		
	}

}
