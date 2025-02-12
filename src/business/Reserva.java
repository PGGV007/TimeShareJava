package business;

import classesBasicas.User;
import classesBasicas.Registro;


public class Reserva {
	
	private User renter; 
	
	
	public void reservar(Registro registro, User userDemanda) {
		
		if(registro.getOwner().equals(userDemanda)) {
			registro.setReservado(false);
			this.setReter(userDemanda);
		}else {
			registro.getPriceReserva();
			if(this.pagamento()) {
				this.setReter(userDemanda);
				registro.setReservado(false);
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
