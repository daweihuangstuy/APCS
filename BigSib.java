//Dawei Huang
//Due: 09/23/16
//Period 4 APCS w/ Mr. Brown Mykolyk
//HW#7 -- On BigSib Individuality and the Elimination of Radio Fuzz

public class BigSib {
    private String helloMsg;

    //constructor with parameters
    public BigSib(String message){
     	helloMsg = message;
	}

    //default constructor
    public BigSib(){
       	helloMsg = "Hiya";
    }
    
/*
// Code from Previous HW#7
    public void setHelloMsg ( String message ) {
	helloMsg = message; 
 }
*/
    public String greet(String person) {
	return(helloMsg + ' ' +  person);
 }
}

