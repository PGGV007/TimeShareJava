package classesBasicas;

public class Gerente extends Pessoa {
	
	private String idGerente; 
	
	Gerente(String cpf, String nome, String idGerente){
		super(cpf,nome); 
		this.idGerente = idGerente; 
	}

	public String getIdGerente() {
		return idGerente;
	}

	public void setIdGerente(String idGerente) {
		this.idGerente = idGerente;
	}
	
	
	
}
