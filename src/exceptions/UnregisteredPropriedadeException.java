package exceptions;

public class UnregisteredPropriedadeException extends Exception  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8348031258448246237L;

	public UnregisteredPropriedadeException(){
		System.out.println("Propriedade não registrada"); 
	}
	
}
