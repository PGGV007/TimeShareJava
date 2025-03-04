package business;

import java.io.IOException;

import classesBasicas.Propriedade;
import classesBasicas.Registro;
import dados.IRepositorio;
import exceptions.EmptyArchiveException;
import exceptions.ObjectOutsideArrayException;
import exceptions.UnregisteredGerenteException; 
import exceptions.UnregisteredPropriedadeException;
import exceptions.PropriedadeAlreadyExistsException;

public class CadastroPropriedade {
	

	private IRepositorio repositorioPropriedade ;
	private IRepositorio repositorioGerente; 
	private IRepositorio repositorioRegistro;  
	
	public CadastroPropriedade(IRepositorio repositorioPropriedade,IRepositorio repositorioGerente, IRepositorio repositorioRegistro ) {
		this.repositorioGerente = repositorioGerente; 
		this.repositorioPropriedade = repositorioPropriedade; 
		this.repositorioRegistro = repositorioRegistro; 
	}
	
	

	
	public  void cadastrar(String idGerente, Propriedade propriedade) throws UnregisteredGerenteException, PropriedadeAlreadyExistsException, ClassNotFoundException, IOException, EmptyArchiveException{
		if(propriedade != null) {
			if(repositorioGerente.existe(idGerente) == true ) {
				 
				if(this.existe(propriedade) != true) {
					repositorioPropriedade.adicionar(propriedade); 
					Registro[] reg = propriedade.getRegistros(); 
					for(int i = 0; i<52; i++) {
						repositorioRegistro.adicionar(reg[i]);
					}
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
	
	public void descadastrar(String idGerente, String idPropriedade) throws UnregisteredGerenteException, UnregisteredPropriedadeException, ObjectOutsideArrayException, ClassNotFoundException, IOException, EmptyArchiveException {
		
		boolean teste = false; 
		Propriedade propriedade = (Propriedade) repositorioPropriedade.procurar(idPropriedade); 
		Registro[] registros = propriedade.getRegistros(); 
		for(int i = 0; i< 52; i++) {
			teste = registros[i].getReservado();
			if(teste == true) {
				break; 
			}
		}
		
		if(teste == true) {
			throw new IllegalArgumentException("A propriedade em questão não pode ser descadastrada, há reservas efetuadas."); 
		}else {
			if(checkId(idGerente,idPropriedade) == true) {
				Propriedade p = (Propriedade)repositorioPropriedade.procurar(idPropriedade);
				repositorioPropriedade.retirar(p);//retira a propriedade do reposirório 
				for(int i = 0; i<52;i++){
					repositorioRegistro.retirar(registros[i]);//retira todos os registros relacionados à propriedade do repositório 
				}
				 
			}
		}
		
	}
	
	public void atualizar(String idGerente, Propriedade propriedade) throws UnregisteredGerenteException, UnregisteredPropriedadeException, ObjectOutsideArrayException, ClassNotFoundException, IOException, EmptyArchiveException{
		if(checkId(idGerente,propriedade.getIdPropriedade()) == true) {
			repositorioPropriedade.atualizar(propriedade);
		}
	}
	
	private boolean checkId(String idGerente, String idPropriedade)  throws UnregisteredGerenteException, UnregisteredPropriedadeException, ClassNotFoundException, IOException, EmptyArchiveException {
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
	
	public boolean existe(Propriedade a) throws ClassNotFoundException, IOException, EmptyArchiveException {
		return repositorioPropriedade.existe(a.getIdPropriedade()); 
	}
	
	
	
	
}
