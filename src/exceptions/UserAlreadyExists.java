package exceptions;

public class UserAlreadyExists extends Exception {
	
	 public UserAlreadyExists() {
		System.out.println("Usuário já cadastrado."); 
	}

}
