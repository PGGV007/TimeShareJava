package business;

import classesBasicas.Gerente;
import classesBasicas.Propriedade;
import dados.IRepositorio;
import exceptions.ObjectOutsideArrayException;
import exceptions.UnregisteredGerenteException; 
import exceptions.UnregisteredPropriedadeException;

public class CadastroPropriedade {
	

	private IRepositorio repositorio; 
	
	
	/*public CadastroPropriedade(Gerente gerente, Propriedade propriedade) {
		this.gerente = gerente; 
		this.propriedade = propriedade; 
	}*/
	
	public void cadastrar(String idGerente, Propriedade propriedade) throws UnregisteredGerenteException{
		if(propriedade != null) {
			if(repositorio.existe(idGerente) == true ) {
				repositorio.adicionar(propriedade);
			}else {
				throw new UnregisteredGerenteException();  
			}
		}else {
			throw new IllegalArgumentException("Propriedade inválida"); 
		}
	}
	
	public void descadastrar(String idGerente, String idPropriedade) throws UnregisteredGerenteException, UnregisteredPropriedadeException, ObjectOutsideArrayException {
		if(checkId(idGerente,idPropriedade) == true) {
			repositorio.adicionar((Propriedade)repositorio.procurar(idPropriedade));
		}
	}
	
	public void atualizar(String idGerente, String idPropriedade) throws UnregisteredGerenteException, UnregisteredPropriedadeException, ObjectOutsideArrayException{
		if(checkId(idGerente,idPropriedade) == true) {
			repositorio.atualizar((Propriedade)repositorio.procurar(idPropriedade));
		}
	}
	
	private boolean checkId(String idGerente, String idPropriedade)  throws UnregisteredGerenteException, UnregisteredPropriedadeException {
		if(repositorio.existe(idGerente) == true) {
			if(repositorio.existe(idPropriedade)== true) {
				return true; 
			}else {
				throw new UnregisteredPropriedadeException();
			}
		}else {
			throw new UnregisteredGerenteException(); 
		}
	}
	
	
	
	
}
