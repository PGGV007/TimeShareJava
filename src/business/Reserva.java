package business;

import classesBasicas.User;
import dados.IRepositorio;
import classesBasicas.Registro;
import exceptions.WeekAlreadyReservedException;
import exceptions.EmptyArchiveException;
import exceptions.PaymentNotCompletedException;
import exceptions.WeekNotAvailableException;


import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;

import classesBasicas.GeradorId;



public class Reserva implements Serializable{

	private static final long serialVersionUID = 6488767664342405141L;
	private User renter; 
	private final String idReserva; 
	private boolean ativo; 
	private  final LocalDate dataInicial; 
	private final Registro registro; 
	
	public Reserva(Registro registro, User userDemanda, int ano) throws WeekAlreadyReservedException, PaymentNotCompletedException, WeekNotAvailableException {
		this.idReserva = GeradorId.geradorHexId(6); 
		this.reservar(registro, userDemanda);
		LocalDate dataInicial = ((registro.getPropriedade()).getSemana((int)(registro.getFraction()), ano));//pega a data referente ao ano da fração correspondente na propriedade
		this.dataInicial = dataInicial; 
		this.registro = registro; 
	}
	
	private void reservar(Registro registro, User userDemanda) throws WeekAlreadyReservedException, PaymentNotCompletedException, WeekNotAvailableException {
		
		
		if(registro.getOwner().equals(userDemanda)) {
			if(!registro.getReservado()) {
				this.setReter(userDemanda);
				registro.setReservado(true);
			}else {
				throw new WeekAlreadyReservedException(); 
			}
		}else {
			if(registro.getAvailabe() && !registro.getReservado()) {
				registro.getPriceReserva();
				if(this.pagamento()) {
					this.setReter(userDemanda);
					registro.setReservado(true);
				}else {
					throw new PaymentNotCompletedException(); 
				}
			}else {
				throw new WeekNotAvailableException(); 
			}
		}
		
	}
	
	public void retirarReserva(String id, IRepositorio rep, Registro reg) throws ClassNotFoundException, IOException, EmptyArchiveException {
		if(id.equals(renter.getIdUser()) && rep.existe(id)) {
			reg.setReservado(false);
		}
		//faz com que a reserva seja desativada.
		//ela não deixa de existir, no entanto, não pode mais ser usada
		//precisará de mais uma instância para reservar a mesma data
	}
	public boolean pagamento() {
		return true; 
	}
	
	public void setReter(User u) {
		this.renter = u; 
	}
	
	public User getRenter() {
		return this.renter; 
	}

	public String getIdReserva() {
		return idReserva;
	}

	public boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public LocalDate getDataInicial() {
		return dataInicial;
	}

	public Registro getRegistro() {
		return registro;
	}

	
	
	
	
	
}
