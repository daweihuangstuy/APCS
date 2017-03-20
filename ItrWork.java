//Dawei Huang
//APCS2 pd5
//HW20 -- DeIteratour
//2017-03-20


/*****************************************************
 * class ItrWork -- skeleton
 * Allows for familiarization with iterators
 *****************************************************/

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

public class ItrWork
{
    //using FOREACH loop
    //returns a boolean to indicate whether key is present in L
    public static boolean foundA( Integer key, List<Integer> L ) 
    { 
	/*** YOUR IMPLEMENTATION HERE ***/
		for(Integer x : L){
			if (x == key){
				return true;
			}
		}
		return false;
    }


    //explicitly using an iterator
    //returns a boolean to indicate whether key is present in L
    public static boolean foundB( Integer key, List<Integer> L ) 
    { 
	/*** YOUR IMPLEMENTATION HERE ***/
		Iterator tempL = L.iterator();
		while(tempL.hasNext() == true){
			if(tempL.next() == key){
				return true;
			}
			else{
				tempL.remove();
			}
		}
		return false;
    }


    //using FOREACH loop
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsA( List<Integer> L ) 
    { 
	/*** YOUR IMPLEMENTATION HERE ***/
		List<Integer> returnL = new ArrayList<Integer>();
		for(Integer x : L){
			if((int)x % 2 == 1){
				returnL.add(x);
				System.out.println(x);
			}
		}
		return returnL;
    }


    //explicitly using an iterator
    //returns a list containing the odd numbers in L
    public static List<Integer> oddsB( List<Integer> L ) 
    { 
	/*** YOUR IMPLEMENTATION HERE ***/
		Iterator tempL = L.iterator();
		List<Integer> returnL = new ArrayList<Integer>();
		while(tempL.hasNext() == true){
			if((int)tempL.next() % 2 == 1){
				returnL.add((Integer)tempL.next());
			}
			else{
				tempL.remove();
			}
		}
		return returnL;
    }


    //explicitly using an iterator
    //modifies L s.t. it contains no evens
    public static void removeEvens( List<Integer> L ) 
    { 
	/*** YOUR IMPLEMENTATION HERE ***/
		Iterator tempL = L.iterator();
		while(tempL.hasNext() == true){
			if((int)tempL.next() % 2 == 0){
				tempL.remove();
			}
		}
    }


    public static void main( String [] args ) 
    {

	//var type: List   obj type: ArrayList	
	List<Integer> L = new ArrayList<Integer>();

	for( int i = 0; i < 10; i++ )
	    L.add(i);


	// TASK: write code to print the contents of ArrayList L...

	//~~~~~~~~~~~~~~~m~o~v~e~~m~e~~d~o~w~n~~~~~~~~~~~~~~
	// a) using a FOREACH loop
	for(Integer x : L){
		System.out.print(x + "\t");
	}

	System.out.println("\n");

	// b) explicitly using an iterator
	Iterator tempL = L.iterator();
	while(tempL.hasNext() == true){
		System.out.print(tempL.next() + "\t");
	}
	System.out.println("\n");
	
	System.out.println("\nTesting foundA...");
	System.out.println("9 in L? -> " + foundA(9,L) );
	System.out.println("13 in L? -> " + foundA(13,L) );

	
	System.out.println("\nTesting foundB...");
	System.out.println("9 in L? -> " + foundB(9,L) );
	System.out.println("13 in L? -> " + foundB(13,L) );
	
	
	System.out.println("\nTesting oddsA...");
	List<Integer> A = oddsA(L);
	for( int n : A ) System.out.println(n);

	System.out.println("\nTesting oddsB...");
	List<Integer> B = oddsB(L);
	for( int n : B ) System.out.println(n);

	System.out.println("\nTesting removeEvens...");
	removeEvens(L);
	for( int n : L ) System.out.println(n);
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    }//end main

}//end class ItrWork

