//Dawei Huang
//Due: 09/28/16
//Period 4 APCS w/ Mr. Brown Mykolyk
//HW#10 -- CMYM


public class BankKiosk{
	public static void main(String[] args){
	    BankAccount dawei = new BankAccount();
	    dawei.setAttributes("Dawei Huang", "123456789", 1234, 123456789, 765.33);
	    dawei.deposit(324.1231);
	    dawei.withdraw(1.0001);
	    dawei.print();
	}
}
