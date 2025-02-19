package exceptions;

public class WeekNotAvailableException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5044648991005100964L;

	public WeekNotAvailableException(){
		System.out.println("A semana em questão não está disponível");
	}
	
}
