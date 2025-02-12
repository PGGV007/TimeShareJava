package business;

import dados.IRepositorio;
import classesBasicas.Gerente;
import exceptions.GerenteAlreadyExistsException;
import exceptions.ObjectOutsideArrayException;
import exceptions.UnregisteredGerenteException;

public class CadastroGerente {
	
	IRepositorio repositorio; 
	
	public CadastroGerente(IRepositorio repositorio) {
		this.repositorio = repositorio; 
	}
	
	
	
	public boolean existe(Gerente gerente) {
		return repositorio.existe(gerente.getIdGerente()); 
	}
	
	public void cadastrar (Gerente gerente) throws GerenteAlreadyExistsException{
		
		if(gerente != null) {
			
			if(repositorio.existe(gerente.getIdGerente()) == false) {
				repositorio.adicionar(gerente);
			}else{
				throw new GerenteAlreadyExistsException(); 
			}
			
		}else {
			throw new IllegalArgumentException("Gerente inválido");
		}
		
	}
	
	public void descadastrar(String id) throws ObjectOutsideArrayException, UnregisteredGerenteException  {
		if(id != null) {
			
			if(repositorio.existe(id) == true) {
				repositorio.retirar(repositorio.procurar(id));
			}else {
				throw new UnregisteredGerenteException(); 
			}
			
		}else {
			throw new IllegalArgumentException("Id inválido");
		}
		
	}
	
	public void atualizar(String id) throws ObjectOutsideArrayException, UnregisteredGerenteException{
		
		if(id != null) {
			
			if(repositorio.existe(id) == true) {
				
				repositorio.atualizar(repositorio.procurar(id));
				
			}else {
				
				throw new UnregisteredGerenteException(); 
				
			}
			
		}else {
			
			throw new IllegalArgumentException("Id inválida"); 
			
		}
		
	}
	
}
