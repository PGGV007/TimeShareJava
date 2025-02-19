package classesBasicas;

public class Gerente extends Pessoa {
	
	private final String idGerente;
	private final String senha;
	
	public Gerente(String cpf, String nome, String senha){
		super(cpf,nome); 
		this.idGerente = GeradorId.geradorHexId(6); ; 
		this.senha = senha; 
	}

	public String getIdGerente() {
		return idGerente;
	}

	public String getSenha() {
		return senha;
	}

	
}
