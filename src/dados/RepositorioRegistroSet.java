package dados;

import exceptions.ObjectOutsideArrayException;
import classesBasicas.Registro;

public class RepositorioRegistroSet extends RepositorioGenericoSet implements IRepositorio {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3521366911367174311L;

	@Override
	public Object procurar(String id) throws ObjectOutsideArrayException {
		
		boolean teste = false; 
		Registro j = null; ; 
		
		for(Object obj : repositorio) {
			Registro p = (Registro) obj; 
		   teste = p.getIdRegistro().equals(id); 
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
			Registro p = (Registro) obj; 
			teste = p.getIdRegistro().equals(id); 
		    if(teste == true) { 
		    	break; 
		    }
		}
		
		return teste; 
		 
	}
	
	
}
