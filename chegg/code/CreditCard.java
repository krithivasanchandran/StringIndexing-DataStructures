package chegg.code;

public class CreditCard {
	
	private double billBalance = 0.0;
	private double subscription = 0.0;
	private final String usertoken = "ASDJA(*!@#12312#!ASDA";
	private double outstandingbalance = 0.0;
	
	CreditCard(double Billbalance, double subscriptionamount){
		this.billBalance = Billbalance;
		this.subscription = subscriptionamount; 
	}
	
	/*
	 * True : Success - Credit Card has gone through
	 * False : Failure - Credit Card has failed 
	 */
	
	public boolean payBill(double transactionAmount){
		if(this.billBalance > transactionAmount){
			outstandingbalance = billBalance - transactionAmount ;
			System.out.println("Outstanding balance in your credit card is :: " + outstandingbalance);
			return true;
		}else{
			System.out.println("Insufficient Balance cannot process the transaction");
			return false;
		}
	}
	
	public boolean isTransactionAuthorised(String securityPassword){
		
		if(securityPassword != null && !(securityPassword.isEmpty()))  {
			if(securityPassword.equalsIgnoreCase(usertoken)){
				return true;
			}
		}
		return false;
	}
	
	public void printOutstandingBalance(){
		System.out.println(" Outstanding balance in your credit card is :: " + this.outstandingbalance);
	}
	
	public boolean isSuccess(){return true;}
	
	public boolean isFailure(){return false;}

}
