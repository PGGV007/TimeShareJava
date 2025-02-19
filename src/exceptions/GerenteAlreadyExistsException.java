package exceptions;

public class GerenteAlreadyExistsException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -136193401758700529L;

	public GerenteAlreadyExistsException() {
		System.out.println("Gerente já cadastrado");
	}
}
