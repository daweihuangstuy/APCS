//Dawei Huang
//Due: 10/25/16
//Period 4 APCS w/ Mr. Brown Mykolyk
//HW#21 -- For the (Lulz) Love of Strings .

public class Foresrever {
	//fenceF(int posts) takes non-negative integer posts, 
	// and returns a String representation of a fence with the specified number of posts. 
	// Uses a FOR loop.
    public static String fenceF(int posts){
		String fence = "|";
		int i;
		String x = "";
		if (posts == 0){
			return "";
		}
		for (i = 0; i < posts; i += 1){
			fence += "--|";
			}
		x = fence;
		return(x);
		}

	// reverseF(String s) a non-empty String s and returns s with its letters reversed. Uses a FOR loop.
	public static String reverseF(String s){
		String x = "";
		int i;
		if (s == ""){
			return "";
		}
		for(i = s.length() - 1; i >= 0; i -= 1){
			x += s.substring(i,i + 1);
		}
		return x;
	}
		
	// reverseR(String s) a non-empty String s and returns s with its letters reversed. Employs recursion.
	public static String reverseR(String s){
		if (s.length() == 0){
			return "";
		}
		else {
			return s.substring(s.length() - 1) + reverseR(s.substring(0, s.length() - 1));
		}	
	}		
}

class Driver {
    public static void main(String[] args){
	/*
	  Tests for fenceF method (takes non-negative integer posts, and returns a String representation of a fence with the specified number of posts. Uses a FOR loop.)
	*/
	System.out.println("Tests for fenceF method");
	System.out.println(Foresrever.fenceF(5)); //"|--|--|--|--|--|"
	System.out.println(Foresrever.fenceF(4)); //"|--|--|--|--|"
	System.out.println(Foresrever.fenceF(3)); //"|--|--|--|"
	System.out.println(Foresrever.fenceF(2)); //"|--|--|"
	System.out.println(Foresrever.fenceF(1)); //"|--|"
	System.out.println(Foresrever.fenceF(0)); //""
	
	/*
	  Tests for reverseF method (takes a non-empty String s and returns s with its letters reversed. Uses a FOR loop.)
	*/
	System.out.println("\nTests for reverseF method");
	System.out.println(Foresrever.reverseF("")); //""
	System.out.println(Foresrever.reverseF("Chewbacca")); //"accabwehC"
	System.out.println(Foresrever.reverseF("Dawei Huang")); //"gnauH iewaD"
	System.out.println(Foresrever.reverseF("Mr. Brown Mykolyk")); //"kylokyM nworB .rM"
	System.out.println(Foresrever.reverseF("hello")); //"olleh"
	System.out.println(Foresrever.reverseF("embargo")); //"ograbme"
	
	/*
	  Tests for reverseR method (takes a non-empty String s and returns s with its letters reversed. Employs recursion.)
	*/
	System.out.println("\nTests for reverseR method");
	System.out.println(Foresrever.reverseR("")); //""
	System.out.println(Foresrever.reverseR("Chewbacca")); //"accabwehC"
	System.out.println(Foresrever.reverseR("Dawei Huang")); //"gnauH iewaD"
	System.out.println(Foresrever.reverseR("Mr. Brown Mykolyk")); //"kylokyM nworB .rM"
	System.out.println(Foresrever.reverseR("hello")); //"olleh"
	System.out.println(Foresrever.reverseR("embargo")); //"ograbme"
    }
}
