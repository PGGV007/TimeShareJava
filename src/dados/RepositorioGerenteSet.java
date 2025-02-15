package dados;

import exceptions.ObjectOutsideArrayException;
import classesBasicas.Gerente; 

public class RepositorioGerenteSet extends RepositorioGenericoSet implements IRepositorio {
	
	@Override
	public Object procurar(String id) throws ObjectOutsideArrayException {
		
		boolean teste = false; 
		Gerente j = null; ; 
		
		for(Object obj : repositorio) {
			Gerente p = (Gerente) obj; 
		   teste = p.getIdGerente().equals(id); 
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
			Gerente p = (Gerente) obj; 
			teste = p.getIdGerente().equals(id); 
		    if(teste == true) { 
		    	break; 
		    }
		}
		
		return teste; 
		 
	}
	
	
}
