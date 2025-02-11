package exceptions;

public class UnregisteredGerenteException extends Exception {
	
	public UnregisteredGerenteException() {
		System.out.println("Id do gerente não registrado");
	}
	
}
