package business;

import classesBasicas.Propriedade;
import dados.IRepositorio;
import exceptions.ObjectOutsideArrayException;
import exceptions.UnregisteredGerenteException; 
import exceptions.UnregisteredPropriedadeException;
import exceptions.PropriedadeAlreadyExistsException;

public class CadastroPropriedade {
	

	private IRepositorio repositorioPropriedade;
	private IRepositorio repositorioGerente; 
	
	
	public CadastroPropriedade(IRepositorio repositorioPropriedade, IRepositorio repositorioGerente) {
		this.repositorioGerente = repositorioGerente; 
		this.repositorioPropriedade = repositorioPropriedade; 
	}
	
	public void cadastrar(String idGerente, Propriedade propriedade) throws UnregisteredGerenteException, PropriedadeAlreadyExistsException{
		if(propriedade != null) {
			if(repositorioGerente.existe(idGerente) == true ) {
				if(this.existe(propriedade) != true) {
					repositorioPropriedade.adicionar(propriedade);
				}else {
					throw new PropriedadeAlreadyExistsException(); 
				}
			}else {
				throw new UnregisteredGerenteException();  
			}
		}else {
			throw new IllegalArgumentException("Propriedade inválida"); 
		}
	}
	
	public void descadastrar(String idGerente, String idPropriedade) throws UnregisteredGerenteException, UnregisteredPropriedadeException, ObjectOutsideArrayException {
		if(checkId(idGerente,idPropriedade) == true) {
			repositorioPropriedade.adicionar((Propriedade)repositorioPropriedade.procurar(idPropriedade));
		}
	}
	
	public void atualizar(String idGerente, String idPropriedade) throws UnregisteredGerenteException, UnregisteredPropriedadeException, ObjectOutsideArrayException{
		if(checkId(idGerente,idPropriedade) == true) {
			repositorioPropriedade.atualizar((Propriedade)repositorioPropriedade.procurar(idPropriedade));
		}
	}
	
	private boolean checkId(String idGerente, String idPropriedade)  throws UnregisteredGerenteException, UnregisteredPropriedadeException {
		if(repositorioGerente.existe(idGerente) == true) {
			if(repositorioPropriedade.existe(idPropriedade)== true) {
				return true; 
			}else {
				throw new UnregisteredPropriedadeException();
			}
		}else {
			throw new UnregisteredGerenteException(); 
		}
	}
	
	private boolean existe(Propriedade a) {
		return repositorioPropriedade.existe(a.getIdPropriedade()); 
	}
	
	
	
	
}
