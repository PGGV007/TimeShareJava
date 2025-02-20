package dados;

import exceptions.EmptyArchiveException;
import exceptions.ObjectOutsideArrayException;

import java.io.IOException;
import java.util.List;

import classesBasicas.Propriedade;

public class RepositorioPropriedadeSet extends RepositorioGenericoSet implements IRepositorio {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3406448142133621039L;
	
	public RepositorioPropriedadeSet(String arquivo) {
		super(arquivo); 
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object procurar(String id) throws ObjectOutsideArrayException, ClassNotFoundException, IOException, EmptyArchiveException {
		
		boolean teste = false; 
		Propriedade j = null; ; 
		List<Object> clone = (List<Object>)carregarDados(getArquivo());
		for(Object obj : clone) {
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
			Propriedade p = (Propriedade) obj; 
			teste = p.getIdPropriedade().equals(id); 
		    if(teste == true) { 
		    	break; 
		    }
		}
		
		return teste; 
		 
	}
	
}
