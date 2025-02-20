package dados;

import exceptions.ObjectOutsideArrayException;
import classesBasicas.Propriedade;

public class RepositorioPropriedadeSet extends RepositorioGenericoSet implements IRepositorio {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3406448142133621039L;
	
	public RepositorioPropriedadeSet(String arquivo) {
		super(arquivo); 
	}

	@Override
	public Object procurar(String id) throws ObjectOutsideArrayException {
		
		boolean teste = false; 
		Propriedade j = null; ; 
		
		for(Object obj : repositorio) {
			Propriedade p = (Propriedade) obj; 
		   teste = p.getIdPropriedade().equals(id); 
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
			Propriedade p = (Propriedade) obj; 
			teste = p.getIdPropriedade().equals(id); 
		    if(teste == true) { 
		    	break; 
		    }
		}
		
		return teste; 
		 
	}
	
}
