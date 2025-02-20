package dados;

import java.io.Serializable;

import business.Transfer;
import exceptions.ObjectOutsideArrayException;

public class RepositorioTransferSet extends RepositorioGenericoSet implements IRepositorio, Serializable {
	
	private static final long serialVersionUID = -2214290752826870568L;
	
	public RepositorioTransferSet(String arquivo) {
		super(arquivo); 
	}

	@Override
	public Object procurar(String id) throws ObjectOutsideArrayException {
		
		boolean teste = false; 
		Transfer j = null; ; 
		
		for(Object obj : repositorio) {
			Transfer p = (Transfer) obj; 
		   teste = p.getIdTransfer().equals(id); 
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
			Transfer p = (Transfer) obj; 
			teste = p.getIdTransfer().equals(id); 
		    if(teste == true) { 
		    	break; 
		    }
		}
		
		return teste; 
	}
	
}
