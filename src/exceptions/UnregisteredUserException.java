package exceptions;

public class UnregisteredUserException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6856572177761572344L;

	public UnregisteredUserException() {
		System.out.println("Usuário não registrado");
	}
	
}
