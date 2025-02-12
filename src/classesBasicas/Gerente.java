package classesBasicas;

public class Gerente extends Pessoa {
	
	private final String idGerente; 
	
	Gerente(String cpf, String nome, String idGerente){
		super(cpf,nome); 
		this.idGerente = GeradorId.geradorHexId(16); ; 
	}

	public String getIdGerente() {
		return idGerente;
	}

	
}
