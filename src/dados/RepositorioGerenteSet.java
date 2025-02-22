package dados;

import exceptions.EmptyArchiveException;
import exceptions.ObjectOutsideArrayException;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import classesBasicas.Gerente; 

public class RepositorioGerenteSet extends RepositorioGenericoSet implements IRepositorio {
	
	private static final long serialVersionUID = -8629751220091699815L;

	public RepositorioGerenteSet(String arquivo) {
		super(arquivo); 
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Object procurar(String id) throws ObjectOutsideArrayException, ClassNotFoundException, IOException, EmptyArchiveException {
		
		boolean teste = false; 
		Gerente j = null; ; 
		Set<Object> clone = (Set<Object>)carregarDados(getArquivo());
		for(Object obj : clone) {
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
	
	@SuppressWarnings("unchecked")
	@Override 
	public boolean existe(String id) throws ClassNotFoundException, IOException {
		
		boolean teste = false; 
		Set<Object> clone;
		try {
			
			clone = (Set<Object>)carregarDados(getArquivo());
		} catch (EmptyArchiveException e) {
			return false; 	
		} catch (ClassCastException e) {
			return false;
		}
		for(Object obj : clone) {
			Gerente p = (Gerente) obj; 
			teste = p.getIdGerente().equals(id); 
		    if(teste == true) { 
		    	break; 
		    }
		}
		
		return teste; 
		 
	}
	
	
}
