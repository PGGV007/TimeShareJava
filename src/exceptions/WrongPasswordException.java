package exceptions;

public class WrongPasswordException extends Exception  {
	
	public WrongPasswordException() {
		System.out.println("Senha digitada está incorreta");
	}
	
}
