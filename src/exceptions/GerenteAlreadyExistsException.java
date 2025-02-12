package exceptions;

public class GerenteAlreadyExistsException extends Exception {
	
	public GerenteAlreadyExistsException() {
		System.out.println("Gerente já cadastrado");
	}
}
