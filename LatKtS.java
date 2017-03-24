// Dawei Huang
// APCS2 pd5
// HW23 -- Stack: What Is It Good For?               well, this. 
// 2017-03-24


/*****************************************************
 * class LatKtS (LatKeysToSuccess)
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 * SKELETON
 *****************************************************/


public class LatKtS 
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s ) 
    { 
		Latkes stack = new Latkes(s.length());
		String retString = "";
		for(int i = 0; i < s.length(); i++){
			stack.push(s.substring(i, i + 1));
		}
		while(stack.isEmpty() == false){
			retString += stack.pop();
		}
		return retString;
    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s ) 
    { 
		if(s.equals("")){
			return true;
		}
		Latkes stack = new Latkes(s.length());  
		for(int i = 0; i < s.length(); i++){
			stack.push(s.substring(i, i + 1));
		}
		int curValue = 0;
		while(!stack.isEmpty()){
			String curString = stack.pop();
			if(curString.equals("(")){
				curValue += 1;
			}
			if(curString.equals(")")){
				curValue += -1;
			}
			if(curString.equals("[")){
				curValue += 100;
			}
			if(curString.equals("]")){
				curValue += -100;
			}
			if(curString.equals("{")){
				curValue += 10000;
			}
			if(curString.equals("}")){
				curValue += -10000;
			}
		}
		if(curValue == 0){
			return true;
		}
		return false;	
	}//end allMatched()


    //main method to test
    public static void main( String[] args ) { 

	//v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	System.out.println(flip("stressed"));
        System.out.println(allMatched( "({}[()])" )); //true
        System.out.println(allMatched( "([)]" ) ); //false
        System.out.println(allMatched( "(){([])}" ) ); //true
        System.out.println(allMatched( "](){([])}" ) ); //false
        System.out.println(allMatched( "(){([])}(" ) ); //false
        System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
          //^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^
    }

}//end class LatKtS
