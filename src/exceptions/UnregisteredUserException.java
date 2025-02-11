package exceptions;

public class UnregisteredUserException extends Exception{
	
	public UnregisteredUserException() {
		System.out.println("Usuário não registrado");
	}
	
}
