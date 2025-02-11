package exceptions;

public class UserAlreadyExistsException extends Exception {
	
	 public UserAlreadyExistsException() {
		System.out.println("Usuário já cadastrado."); 
	}

}
