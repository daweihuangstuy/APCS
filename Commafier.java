public class Commafier 
{

    /*=====================================
      String commafyR(int) -- inserts commas in a number, every 3rd digit,
      recursively.
      precondition:  n is non-negative integer
      postcondition: returns String version of n with commas inserted
      =====================================*/
    public static String commafyR( int n ) 
    {
		String stringN = Integer.toString(n);
		if (stringN.length() > 3){
			return(commafyR(n / 1000) + "," + stringN.substring(stringN.length() - 3,stringN.length()));
		}
		return stringN;
    }


    /*=====================================
      String commafyF(int) -- inserts commas in a number, every 3rd digit,
      using a FOR Loop.
      precondition:  n is non-negative integer
      postcondition: returns String version of n with commas inserted
      =====================================*/
    public static String commafyF( int n ) 
    {
		String newStringN = "";
		String stringN = Integer.toString(n);
		if (stringN.length() <= 3){
			return stringN;
		}
		for (int i = stringN.length() % 3; stringN.length() - 3 >= i; i+=3){
			newStringN += "," + stringN.substring(i , i + 3);
		}
		if (newStringN.substring(0,1).equals(",")){
			newStringN = newStringN.substring(1);
		}
		if (stringN.length() % 3 == 0){
			return newStringN;
		} 
		return (stringN.substring(0,stringN.length() % 3) + "," + newStringN);
	}
	
    public static void main( String[] args ) { 
	
	  // test calls for development:
	// System.out.println( "commafyR(1): " + commafyR(1) ); 
	// System.out.println( "commafyR(10): " + commafyR(10) ); 
	// System.out.println( "commafyR(101): " + commafyR(101) ); 
	// System.out.println( "commafyR(1000): " + commafyR(1000) ); 
	// System.out.println( "commafyR(12345): " + commafyR(12345) ); 
	// System.out.println( "commafyR(1234567890): " + commafyR(1234567890) ); 
 
	// System.out.println( "commafyF(1): " + commafyF(1) ); 
	// System.out.println( "commafyF(10): " + commafyF(10) ); 
	// System.out.println( "commafyF(101): " + commafyF(101) ); 
	// System.out.println( "commafyF(1000): " + commafyF(1000) ); 
	// System.out.println( "commafyF(12345): " + commafyF(12345) ); 
	// System.out.println( "commafyF(1234567890): " + commafyF(1234567890) ); 

	//code to handle command line input: 
	// (note, need only work for int CLI...)
	for( String intAsStr : args ) {
	    System.out.println( commafyF( Integer.parseInt(intAsStr ) ));
	}
	//or
	for( String intAsStr : args ) {
	    System.out.println( commafyR( Integer.parseInt(intAsStr ) ) );
	}
    }//end main

}//end class 