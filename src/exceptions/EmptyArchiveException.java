package exceptions;

public class EmptyArchiveException extends Exception {


	private static final long serialVersionUID = 692185936407527346L;

	public EmptyArchiveException() {
		System.out.println("não há dados cadastrados no repositório");
	}
	
}
