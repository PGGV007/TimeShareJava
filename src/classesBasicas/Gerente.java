package classesBasicas;

public class Gerente extends Pessoa {
	
	private final String idGerente; 
	
	public Gerente(String cpf, String nome){
		super(cpf,nome); 
		this.idGerente = GeradorId.geradorHexId(16); ; 
	}

	public String getIdGerente() {
		return idGerente;
	}

	
}
