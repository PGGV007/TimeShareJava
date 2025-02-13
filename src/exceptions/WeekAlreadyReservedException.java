package exceptions;

public class WeekAlreadyReservedException extends Exception {
	
	public WeekAlreadyReservedException(){
		System.out.println("A semana em questão já fora reservada");
	}
	
}
