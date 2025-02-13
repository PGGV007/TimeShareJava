package business;

import classesBasicas.User;
import classesBasicas.Registro;
import exceptions.WeekAlreadyReservedException;
import exceptions.PaymentNotCompletedException;
import exceptions.WeekNotAvailableException;



public class Reserva {
	
	private User renter; 
	
	
	public void reservar(Registro registro, User userDemanda) throws WeekAlreadyReservedException, PaymentNotCompletedException, WeekNotAvailableException {
		
		if(registro.getOwner().equals(userDemanda)) {
			if(registro.getReservado()) {
				this.setReter(userDemanda);
				registro.setReservado(true);
			}else {
				throw new WeekAlreadyReservedException(); 
			}
		}else {
			if(registro.getAvailabe() && registro.getReservado()) {
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
	
	public boolean pagamento() {
		return true; 
	}
	
	public void setReter(User u) {
		this.renter = u; 
	}
	
	public User getRenter() {
		return this.renter; 
	}
	
	
	
	
	
}
