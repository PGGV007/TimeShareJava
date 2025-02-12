package dados;

import java.util.HashSet;
import java.util.Set; 

import exceptions.ObjectOutsideArrayException;

public abstract class RepositorioGenericoSet implements IRepositorio {
	
	 protected Set<Object> repositorio = new HashSet<>(); 

	@Override
	public void atualizar(Object obj) 	throws ObjectOutsideArrayException {
		
		if(repositorio.contains(obj)) {
			repositorio.remove(obj);
			repositorio.add(obj); 
		}else {
			throw new ObjectOutsideArrayException(); 
		}

	}

	@Override
	public void retirar(Object obj) throws ObjectOutsideArrayException {

		if(repositorio.contains(obj)) {
			repositorio.remove(obj); 
		}else {
			throw new ObjectOutsideArrayException(); 
		}
	}

	@Override
	public void listar() {
		
		for(Object obj : repositorio) {
			System.out.println(obj); 
		}

	}

	@Override
	public void adicionar(Object obj) {
		
		repositorio.add(obj);

	}

	@Override
	public Object procurar(String id) throws ObjectOutsideArrayException {
		
		//terá que ser feito em específico para todas as classe que lidaremos 
		
		return null;
	}

	@Override
	public boolean existe(String id) {
		
		//terá que ser feito em específico para todas as classe que lidaremos 
		
		return false;
	}

}
