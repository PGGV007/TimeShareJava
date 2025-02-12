package business;

import classesBasicas.Propriedade;
import classesBasicas.Registro;
import dados.IRepositorio;
import exceptions.ObjectOutsideArrayException;
import exceptions.UnregisteredGerenteException; 
import exceptions.UnregisteredPropriedadeException;
import exceptions.PropriedadeAlreadyExistsException;

public class CadastroPropriedade {
	

	private IRepositorio repositorioPropriedade ;
	private IRepositorio repositorioGerente; 
	private IRepositorio repositorioRegistro; 
	private Registro[] registros; 
	
	public CadastroPropriedade(IRepositorio repositorioPropriedade,IRepositorio repositorioGerente, IRepositorio repositorioRegistro ) {
		this.repositorioGerente = repositorioGerente; 
		this.repositorioPropriedade = repositorioPropriedade; 
		this.repositorioRegistro = repositorioRegistro; 
		this.registros = new Registro[52]; 
	}
	
	

	
	public  void cadastrar(String idGerente, Propriedade propriedade) throws UnregisteredGerenteException, PropriedadeAlreadyExistsException{
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
		
		 for(int i = 0; i<52;i++) { //estabelecimento dos registros inerentes à propriedade 
			 registros[i].setPropriedade(propriedade);
			 registros[i].setUser(null);
			 for(byte j = 0; j<52;j++) {
				 registros[j].setFraction((byte) (j+1));
			 }
			 
			 propriedade.addRegistros(registros[i], i); //alocação dos registros dentro da propriedade relacionada 
			 this.repositorioRegistro.adicionar(propriedade); //alocação dos registros dentro do repositório geral 
			 
		 }
		 
		
	}
	
	public void descadastrar(String idGerente, String idPropriedade) throws UnregisteredGerenteException, UnregisteredPropriedadeException, ObjectOutsideArrayException {
		
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
				repositorioPropriedade.retirar((Propriedade)repositorioPropriedade.procurar(idPropriedade));//retira a propriedade do reposirório 
				for(int i = 0; i<52;i++){
					repositorioRegistro.retirar(registros[i]);//retira todos os registros relacionados à propriedade do repositório 
				}
				 
			}
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
