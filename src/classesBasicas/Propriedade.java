package classesBasicas;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map; 

public class Propriedade {
	
	private String nome; 
	private String localization;
	private String description; 
	private int capacidade; 
	private double price; 
	private String idPropriedade; 
	private Registro registroPropriedade; 
	private LocalDate dataInicial; 
	private int anoBase;
	private Map<Integer, LocalDate> semanas; 
	
	
	
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
	}
	
	private void inicializarSemanas() {
        for (int i = 1; i <= 52; i++) {
            semanas.put(i, dataInicial.plusWeeks(i - 1)); 
        }
    }
	
	public LocalDate getSemana(int numSemana, int ano) {
		if(numSemana<1 || numSemana>52) {
			throw new IllegalArgumentException("Número da semana deve estar entre 1 e 52."); 
		}
		
		int diferencaAnos = ano - anoBase; 
		
		LocalDate dataSemana = semanas.get(numSemana).plusYears(diferencaAnos); 
		
		return dataSemana; 
		
	}
	
	public Registro getRegistro() {
		return this.registroPropriedade; 
	}
	
	public void setRegistro(Registro registro) {
		this.registroPropriedade = registro; 
	}
	
	public String getIdPropriedade() {
		return this.idPropriedade; 
	}
	
	public void setIdPropriedade(String id) {
		this.idPropriedade = id; 
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
	
	
}
