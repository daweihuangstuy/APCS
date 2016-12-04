//Dawei Huang   Team: The Train (to success) Members: Eric Zhang, James Zhang, Dawei Huang
//APCS1 pd4
//HW12 -- Mo Money Mo Problems
//2016-10-3


public class BankAccount{
	
	//intializing Instance Variables
	public String acctHolder;
	private String pswd;
	private int pin;
	public int acctNumber;
	private double balance;
	
	//default BankAccount Constructor
	public BankAccount() {
		acctHolder = "";
		pswd = "";
		pin = 0;
		acctNumber = 0;
		balance = 0;
	}
	
	//overloaded BankAccount Constructor
	public BankAccount(String name, String pass, int four, int number, double money){
		acctHolder = name;
		pswd = pass;
		pin = four;
		acctNumber = number;
		balance = money;
	}
	
	//set the name of the account
	public void setAcctHolder(String name){
		acctHolder = name;
	}
	
	//set the password of the account
	public void setPswd(String pass){
		pswd = pass;
	}
	
	//set the PIN of the account
	public void setPin(int four){
	    if (pin >= 1000 && pin <= 9998){
        
		pin = four;}
	    else{pin = 9999;
        
		System.out.println("error: invalid pin");}
	}
	
	//set the number of the account
	public void setAcctNumber(int number){
	    if (acctNumber >= 100000000 && acctNumber <= 999999998 ){
        
		acctNumber = number;}
	    else{acctNumber = 999999999;
	        
		System.out.println("error: invalid account number.");
	}
	}
	
	//set the balance of the account
    public void setBalance(double money){
		balance = money;
	}
	
	//deposit money into the bank
	public void deposit(double amount){
		balance += amount;
	}

	//withdraw money from the bank
	public boolean withdraw(double amount){
	    if ( 
		balance - amount >= 0)
		{balance -= amount;
		    return true;
	        }
	    else {
		System.out.println ("error: you don't got enough moolah, deposit some more.");
		return false;	
	    }}
	
	//print bank information
	public void print(){
		System.out.println("Holder Name: "+acctHolder);
		System.out.println("Password: "+pswd);
		System.out.println("PIN: " + pin);
		System.out.println("Account Number: " + acctNumber);
		System.out.println("Balance: " + balance);
	}
	
	//authenticating the PIN and number of the account
    public boolean authenticate(int pinNum, int acctNum){
	    if ( 
		pin == pinNum && acctNumber == acctNum)
		{return true;
	        }
	    else {
		System.out.println ("error: the pin and account number entered is incorrect. Try again.");
		return false;
	    }}
	
	//main method for purposes of testing the methods above
    public static void main(String[] args){
		BankAccount train = new BankAccount("TrainMan", "123pass", 4321, 123456789, 132.54);
		train.setAcctHolder("TrainMan");
		train.setPswd("abc123");
		train.setPin(1234);
		train.setAcctNumber(218493123);
		train.setBalance(1849293.23);
		train.deposit(1232.12);
		train.withdraw(13222.53);
		train.print();
		train.authenticate(1234, 218493123);
    }	    	    	
}