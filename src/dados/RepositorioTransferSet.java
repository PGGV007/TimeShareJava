package dados;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import business.Transfer;
import exceptions.EmptyArchiveException;
import exceptions.ObjectOutsideArrayException;

public class RepositorioTransferSet extends RepositorioGenericoSet implements IRepositorio, Serializable {
	
	private static final long serialVersionUID = -2214290752826870568L;
	
	public RepositorioTransferSet(String arquivo) {
		super(arquivo); 
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object procurar(String id) throws ObjectOutsideArrayException, ClassNotFoundException, IOException, EmptyArchiveException {
		
		boolean teste = false; 
		Transfer j = null; ; 
		List<Object> clone = (List<Object>)carregarDados(getArquivo());
		for(Object obj : clone) {
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
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean existe(String id) throws ClassNotFoundException, IOException, EmptyArchiveException {
		boolean teste = false; 
		List<Object> clone;
		try {
			
			clone = (List<Object>)carregarDados(getArquivo());
		} catch (EmptyArchiveException e) {
			System.out.println("rodou");
			return false; 	
		} catch (ClassCastException e) {
			return false;
		}
		for(Object obj : clone) {
			Transfer p = (Transfer) obj; 
			teste = p.getIdTransfer().equals(id); 
		    if(teste == true) { 
		    	break; 
		    }
		}
		
		return teste; 
	}
	
}
