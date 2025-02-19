package exceptions;

public class ObjectOutsideArrayException extends Exception  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6551671033474498655L;

	public ObjectOutsideArrayException() {
		System.out.println("Item não presente no repositório"); 
	}
	

}
