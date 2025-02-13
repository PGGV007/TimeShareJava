package exceptions;

public class PaymentNotCompletedException extends Exception {
	
	public PaymentNotCompletedException(){
		System.out.println("Pagamento não foi conluído");
	}
	
}
