package exceptions;


public class PropriedadeAlreadyExistsException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7298545420408670171L;

	public PropriedadeAlreadyExistsException() {
		System.out.println("Propriedade já fora cadastrada"); 
	}
	
}
