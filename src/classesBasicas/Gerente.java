package classesBasicas;

import java.util.Objects;

public class Gerente extends Pessoa {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6493816640950608342L;
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
	
	 @Override
	    public boolean equals(Object o) {
	        if (this == o) {return true;}
	        if (o == null  || !(o.getClass().equals(this.getClass()))) {
	        	return false; 
	        }
	        
	        Gerente g = (Gerente) o ; 
	        return this.getIdGerente().equals(g.getIdGerente()); 
	    }
	    
	    @Override
	    public int hashCode() {
	    	return Objects.hash(idGerente); 
	    }

	
}
