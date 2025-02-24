package classesBasicas;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects; 

public class Propriedade implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3495175078773917586L;
	private String nome; 
	private String localization;
	private String description; 
	private int capacidade; 
	private double price; 
	private final String idPropriedade; 
	private  Registro[] registros= new Registro[52];   //registros diretamente relacionados á prorpriedade 
	private LocalDate dataInicial; //data exata em que a propriedade fora vinculada 
	private int anoBase; //ano em que a propriedae fora vinculada 
	private Map<Integer, LocalDate> semanas; // map para vincular as semanas a datas 
	
	
	
	
	
	public Propriedade(String nome, String description, String localization, int capacidade, double price, LocalDate dataInicial) {
		 this.nome = nome; 
		 this.description = description; 
		 this.localization = localization; 
		 this.capacidade = capacidade; 
		 this.price = price; 
		 this.dataInicial = dataInicial;
		 this.anoBase = dataInicial.getYear();
		 this.semanas = new HashMap<>(); 
		 inicializarSemanas(); 
		 this.idPropriedade = GeradorId.geradorHexId(16);
		 for(int i = 0; i<52;i++) {
			 registros[i] = new Registro((byte)(i+1),this); 
		 }
	}
	
	
	public Registro[] getRegistros() {
		return this.registros; 
	}
	
	public void addRegistros(Registro registro,int i ) { //classe unicamente responsável por pôr os registros inicializados no cadastro dentro do atributo registros da classe
		this.registros[i] = registro; 
	}
	
	private void inicializarSemanas() {
        for (int i = 1; i <= 52; i++) {
            semanas.put(i, dataInicial.plusWeeks(i - 1)); 
        }
    }
	
	public LocalDate getSemana(int numSemana, int ano) { //classe responsável por retornar a data de início da semana operando conforme o ano  
		if(numSemana<1 || numSemana>52) {
			throw new IllegalArgumentException("Número da semana deve estar entre 1 e 52."); 
		}
		
		int diferencaAnos = ano - anoBase; 
		
		LocalDate dataSemana = semanas.get(numSemana).plusYears(diferencaAnos); 
		
		return dataSemana; 
		
	}
	
	
	
	
	public String getIdPropriedade() {
		return this.idPropriedade; 
	}
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getLocalization() {
		return localization;
	}


	public void setLocalization(String localization) {
		this.localization = localization;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getCapacidade() {
		return capacidade;
	}


	public void setCapacidade(int capacidade) {
		this.capacidade = capacidade;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override 
	public boolean equals(Object obj) {
		
		if (this == obj) {  
	        return true;
	    }
	    if (!(obj instanceof Propriedade)) { 
	        return false;
	    }
	    Propriedade p = (Propriedade) obj;
	    return this.getIdPropriedade() != null && this.getIdPropriedade().equals(p.getIdPropriedade());
	}
	
	@Override
	public String toString() {
		return "Capacidade Propriedade:" +" "+ this.getCapacidade();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(idPropriedade);
	}
	
	
	
}
