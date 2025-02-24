package business;

import dados.IRepositorio;

import java.io.IOException;

import classesBasicas.Gerente;
import exceptions.EmptyArchiveException;
import exceptions.GerenteAlreadyExistsException;
import exceptions.ObjectOutsideArrayException;
import exceptions.UnregisteredGerenteException;

public class CadastroGerente {
	
	IRepositorio repositorio; 
	
	public CadastroGerente(IRepositorio repositorio) {
		this.repositorio = repositorio; 
	}
	
	
	
	public boolean existe(Gerente gerente) throws ClassNotFoundException, IOException, EmptyArchiveException {
		return repositorio.existe(gerente.getIdGerente()); 
	}
	
	public void cadastrar (Gerente gerente) throws GerenteAlreadyExistsException, ClassNotFoundException, IOException, EmptyArchiveException{
		
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
	
	public void descadastrar(String id) throws ObjectOutsideArrayException, UnregisteredGerenteException, ClassNotFoundException, IOException, EmptyArchiveException  {
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
	
	public void atualizar(Gerente gerente) throws ObjectOutsideArrayException, UnregisteredGerenteException, ClassNotFoundException, IOException, EmptyArchiveException{
		
		if(gerente != null) {
			
			if(repositorio.existe(gerente.getIdGerente()) == true) {
				
				repositorio.atualizar(gerente);
				
			}else {
				
				throw new UnregisteredGerenteException(); 
				
			}
			
		}else {
			
			throw new IllegalArgumentException("Id inválida"); 
			
		}
		
	}
	
}
