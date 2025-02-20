package dados;

import exceptions.EmptyArchiveException;
import exceptions.ObjectOutsideArrayException;

import java.io.IOException;
import java.util.List;

import classesBasicas.Registro;

public class RepositorioRegistroSet extends RepositorioGenericoSet implements IRepositorio {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -3521366911367174311L;
	
	public RepositorioRegistroSet(String arquivo) {
		super(arquivo); 
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object procurar(String id) throws ObjectOutsideArrayException, ClassNotFoundException, IOException, EmptyArchiveException {
		
		boolean teste = false; 
		Registro j = null; ; 
		List<Object> clone = (List<Object>)carregarDados(getArquivo());
		for(Object obj : clone) {
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
			Registro p = (Registro) obj; 
			teste = p.getIdRegistro().equals(id); 
		    if(teste == true) { 
		    	break; 
		    }
		}
		
		return teste; 
		 
	}
	
	
}
