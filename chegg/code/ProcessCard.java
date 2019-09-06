package chegg.code;

public class ProcessCard {
	
	public static void main(String args[]){
		
		final double transactionAmount = 28.20;
		
		CreditCard creditCard = new CreditCard(123, 212.90);
		
		boolean isAuthorizedUser = creditCard.isTransactionAuthorised("ASDJA(*!@#12312#!ASDA");
		
		if(isAuthorizedUser){
			boolean isSucess = creditCard.payBill(transactionAmount);
			
			if(isSucess){
				System.out.println("Transaction Success :: Credit Card has gone through ");
			}else{
				System.out.println("Transaction Failure :: Credit Card has failed");
			}
		}
	}

}
