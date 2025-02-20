package dados;

import exceptions.EmptyArchiveException;
import exceptions.ObjectOutsideArrayException;

import java.io.IOException;
import java.util.List;

import classesBasicas.User;

public class RepositorioUserSet extends RepositorioGenericoSet implements IRepositorio {

	
	private static final long serialVersionUID = 128181906860523572L;
	
	public RepositorioUserSet(String arquivo) {
		super(arquivo); 
	}

	@Override
	public Object procurar(String id) throws ObjectOutsideArrayException, ClassNotFoundException, IOException, EmptyArchiveException {
		
		boolean teste = false; 
		User j = null; ; 
		@SuppressWarnings("unchecked")
		List<Object> clone = (List<Object>)carregarDados(getArquivo());
		for(Object obj : clone) {
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
			User p = (User) obj; 
			teste = p.getIdUser().equals(id); 
		    if(teste == true) { 
		    	break; 
		    }
		}
		
		return teste; 
		 
	}
	
	
}
