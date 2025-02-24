package business;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import classesBasicas.Propriedade;
import classesBasicas.Registro;
import dados.IRepositorio;


public  class AvailabilityReport {
	
	IRepositorio repositorioReserva;
	
	public AvailabilityReport(IRepositorio repositorioReserva){
		this.repositorioReserva =  repositorioReserva; 
	}
	
	
	public  Set<Registro> selling(Propriedade propriedade){// método que avalia os registros disponíveis para venda de uma propriedade
		
		Registro[] registros = propriedade.getRegistros();
		HashSet<Registro> selable = new HashSet<Registro>(); 
		
		for(Registro r : registros){
			if(r.getForSale()) {
				selable.add(r);
			}
		}
		
		return selable;
	}
	
	public  Set<Registro> availableForReserve(Propriedade propriedade){ //método que retorna os registros (semanas) disponíveis para reserva em uma propriedade
		
		Registro[] registros = propriedade.getRegistros();
		HashSet<Registro> available = new HashSet<Registro>(); 
		
		for(Registro r : registros) {
			if(r.getAvailabe()) {
				available.add(r); 
			}
		}
		
		return available; 
	}
	
	@SuppressWarnings("unchecked")
	public Set<Map<LocalDate,LocalDate>> occupiedDates(Propriedade propriedade, int ano){
		
		HashSet<Object>  cloneReserva= (HashSet<Object>) repositorioReserva;
		Map<LocalDate,LocalDate> datas = new HashMap<LocalDate,LocalDate>(); 
		HashSet<Map<LocalDate,LocalDate>>  datasOcupadas = new HashSet<Map<LocalDate,LocalDate>>();
		
		for(Object obj : cloneReserva) {
			Reserva r = (Reserva) obj; 
			
			if(!r.getAtivo()) { //verifica se o  registro está ativo dentro do repositório 
				if((r.getRegistro().getPropriedade().equals(propriedade))){ //if verifica se a propriedade do registro em questão é a mesma do argumento
					datas.put(r.getDataInicial(), (r.getDataInicial()).plusDays(6));  //coloca a data inicial e final no map 
				}
			}
			datasOcupadas.add(datas); 
		}
		return datasOcupadas; 
	}
	
}
