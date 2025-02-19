package dados;

import exceptions.ObjectOutsideArrayException;
import classesBasicas.User;

public class RepositorioUserSet extends RepositorioGenericoSet implements IRepositorio {

	/**
	 * 
	 */
	private static final long serialVersionUID = 128181906860523572L;

	@Override
	public Object procurar(String id) throws ObjectOutsideArrayException {
		
		boolean teste = false; 
		User j = null; ; 
		
		for(Object obj : repositorio) {
			User p = (User) obj; 
		   teste = p.getIdUser().equals(id); 
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
			User p = (User) obj; 
			teste = p.getIdUser().equals(id); 
		    if(teste == true) { 
		    	break; 
		    }
		}
		
		return teste; 
		 
	}
	
	
}
