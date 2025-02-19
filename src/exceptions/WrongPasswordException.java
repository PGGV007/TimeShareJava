package exceptions;

public class WrongPasswordException extends Exception  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1913477070690250120L;

	public WrongPasswordException() {
		System.out.println("Senha digitada está incorreta");
	}
	
}
