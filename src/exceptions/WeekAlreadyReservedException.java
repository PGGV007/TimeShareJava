package exceptions;

public class WeekAlreadyReservedException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4376942904082501440L;

	public WeekAlreadyReservedException(){
		System.out.println("A semana em questão já fora reservada");
	}
	
}
