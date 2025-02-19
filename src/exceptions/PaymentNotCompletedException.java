package exceptions;

public class PaymentNotCompletedException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 935554568840210840L;

	public PaymentNotCompletedException(){
		System.out.println("Pagamento não foi conluído");
	}
	
}
