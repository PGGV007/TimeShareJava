package exceptions;

public class UnregisteredGerenteException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2798477458999157178L;

	public UnregisteredGerenteException() {
		System.out.println("Id do gerente não registrado");
	}
	
}
