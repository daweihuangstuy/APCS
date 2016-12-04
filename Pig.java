//Dawei Huang
//Due: 11/01/16
//Period 4 APCS w/ Mr. Brown Mykolyk
//HW #25 -- ? ? ?


//class Pig
//a Pig Latin translator
//SKELETON

/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
           9
     ,--.-'-,--.
     \  /-~-\  /
    / )' O O `( \
   ( (  ,---.  ) )
    \ `(_o_o_)' /
     \   `-'   /
      | |---| |     
      [_]   [_]
      PROTIP: Make this class compilable first, 
      then develop and test one method at a time.
      NEVER STRAY TOO FAR FROM COMPILABILITY/RUNNABILITY!
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

import java.util.Scanner;
public class Pig 
{
    //Q: How does this initialization make your life easier?
    private static final String VOWELS = "aeiou";


    /*=====================================
      boolean hasA(String,String) -- checks for a letter in a String
      pre:  w != null, letter.length() == 1
      post: hasA("cat", "a") returns true  
      hasA("cat", "p") returns false
      =====================================*/
    public static boolean hasA( String w, String letter ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	//if w is null or the letter length is not equal to 1, then return false
	if(w == null || letter.length() != 1){
		return false;
	}
	
	//if the first character in the current String w is equal to the letter, then return true
	while (w.length() > 0){
		if (w.substring(0,1).equals(letter)){
			return true;
		}
		w = w.substring(1);
	}
	return false;
    }//end hasA()


    /*=====================================
      boolean isAVowel(String) -- tells whether a letter is a vowel
      precondition: letter.length() == 1
      =====================================*/
    public static boolean isAVowel( String letter ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	//if the length of the letter is not 1, then return false
	if (letter.length() != 1){
		return false;
	}
	
	//if the letter is found in the String VOWELS, then return true
	//otherwise, return false
	return hasA(VOWELS, letter);
    }


    /*=====================================
      int countVowels(String) -- counts vowels in a String
      pre:  w != null
      post: countVowels("meatball") returns 3
      =====================================*/
    public static int countVowels( String w ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	int vowelCounter = 0;
	//if String w is null, then return 0
	if (w == null){
		return 0;
	}
	
	//while the length of String w is greater than 0, if the first character
	//of String w is a vowel, increase the number of Vowels present by 1,
	//then set w as a w without its first character
	while (w.length() > 0){
		if (isAVowel(w.substring(0,1))){
			vowelCounter += 1;
		}
		w = w.substring(1);
	}
	
	//return the vowelCount
	return vowelCounter;
    }


    /*=====================================
      boolean hasAVowel(String) -- tells whether a String has a vowel
      pre:  w != null
      post: hasAVowel("cat") returns true
      hasAVowel("zzz") returns false
      =====================================*/
    public static boolean hasAVowel( String w ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	//if String w is null, return false
	if(w == null){
		return false;
	}
	
	//if the vowel count in String w is greater than 0, then return true
	if (countVowels(w) > 0){
		return true;
	}
	
	//return false
	return false;
    }


    /*=====================================
      String allVowels(String) -- returns vowels in a String
      pre:  w != null
      post: allVowels("meatball") returns "eaa"
      =====================================*/
    public static String allVowels( String w ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	String vowelString = "";
	//if String w is null, then return an empty string
	if (w == null){
		return "";
	}
	
	//while the length of String w is greater than 0, if the first character of
	//string is a vowel, then add that character into the string of vowels
	while (w.length() > 0){
		if(isAVowel(w.substring(0,1))){
			vowelString += w.substring(0,1);
		}
		w = w.substring(1);
	}
	return vowelString;
    }


    /*=====================================
      String firstVowel(String) -- returns first vowel in a String
      pre:  w != null
      post: firstVowel("") --> ""
      firstVowel("zzz") --> ""
      firstVowel("meatball") --> "e"
      =====================================*/
    public static String firstVowel( String w ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	//if String w is null, then return an empty string
	if (w == null){
		return "";
	}
	
	//while the length of String w is greater than 0, if the first character
	//of String w is a vowel, then return that character
	while (w.length() > 0){
		if(isAVowel(w.substring(0,1))){
			return (w.substring(0,1));
		}
		w = w.substring(1);
	}
	
	//return an empty String
	return "";
    }


    /*=====================================
      boolean beginsWithVowel(String) -- tells whether a String begins with a vowel
      pre:  w != null and w.length() > 0
      post: beginsWithVowel("apple")  --> true
      beginsWithVowel("strong") --> false
      =====================================*/
    public static boolean beginsWithVowel( String w ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	
	//if String w is null or its length is less than or equal to 0, return false
	if (w == null && w.length() <= 0){
		return false;
	}
	
	//return true if the first character of string w is a vowel, otherwise return false
	return isAVowel(w.substring(0,1));
    }

    /*=====================================
      String engToPig(String) -- converts an English word to Pig Latin
      pre:  w.length() > 0
      post: engToPig("apple")  --> "appleway"
      engToPig("strong") --> "ongstray"
      engToPig("java")   --> "avajay"
      =====================================*/
    public static String engToPig( String w ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	String pigString = "";
	int firstVowelLocation = w.indexOf(firstVowel(w));
	boolean UpperCaseQ = Character.isUpperCase(w.charAt(0));
	
	if (UpperCaseQ == true){
		w = Character.toLowerCase(w.charAt(0)) + w.substring(1);
	}
	
	if (allVowels(w).equals("") && w.indexOf("y") > 0){
		if (w.substring(w.length() - 1).equals(".")){
			w = w.substring(0,w.length() - 1);
			if (UpperCaseQ == true){
				String pigWord = w.substring(w.indexOf("y")) + w.substring(0,w.indexOf("y")) + "ay.";
				return (Character.toUpperCase(pigWord.charAt(0)) + pigWord.substring(1));
			}
			return (w.substring(w.indexOf("y")) + w.substring(0,w.indexOf("y")) + "ay.");
		}
		if (w.substring(w.length() - 1).equals(",")){
			w = w.substring(0,w.length() - 1);
			if (UpperCaseQ == true){
				String pigWord = w.substring(w.indexOf("y")) + w.substring(0,w.indexOf("y")) + "ay,";
				return (Character.toUpperCase(pigWord.charAt(0)) + pigWord.substring(1));
			}
			return (w.substring(w.indexOf("y")) + w.substring(0,w.indexOf("y")) + "ay,");
		}
		if (UpperCaseQ == true){
				String pigWord = w.substring(w.indexOf("y")) + w.substring(0,w.indexOf("y")) + "ay";
				return (Character.toUpperCase(pigWord.charAt(0)) + pigWord.substring(1));
			}
		return (w.substring(w.indexOf("y")) + w.substring(0,w.indexOf("y")) + "ay");
	}
	
	// if String w is an empty String, then return an empty String
	if (w == ""){
		return "";
	}
	
	//else, if the first vowel of string w is an empty String, then return String w appended with "way"
	else if (firstVowel(w) == ""){
		if (w.substring(w.length() - 1).equals(".")){
			w = w.substring(0,w.length() - 1);
			if (UpperCaseQ == true){
				String pigWord = w + "way.";
				return (Character.toUpperCase(pigWord.charAt(0)) + pigWord.substring(1));
			}
			return (w + "way.");
		}
		else if (w.substring(w.length() - 1).equals(",")){
			w = w.substring(0,w.length() - 1);
			if (UpperCaseQ == true){
				String pigWord = w + "way,";
				return (Character.toUpperCase(pigWord.charAt(0)) + pigWord.substring(1));
			}
			return (w + "way,");
		}
		if (UpperCaseQ == true){
				String pigWord = w + "way";
				return (Character.toUpperCase(pigWord.charAt(0)) + pigWord.substring(1));
			}
		return (w + "way");
	}
	
	//return the string from the first vowel of String w onwards appended with the String from the first 
	//character to just before the first vowel of String w appended with "ay"
	if (w.substring(w.length() - 1).equals(".")){
			w = w.substring(0,w.length() - 1);
			if (UpperCaseQ == true){
				String pigWord = w.substring(firstVowelLocation) + w.substring(0, firstVowelLocation) + "ay.";
				return (Character.toUpperCase(pigWord.charAt(0)) + pigWord.substring(1));
			}
			return (w.substring(firstVowelLocation) + w.substring(0, firstVowelLocation) + "ay.");
		}
	else if (w.substring(w.length() - 1).equals(",")){
			w = w.substring(0,w.length() - 1);
			if (UpperCaseQ == true){
				String pigWord = w.substring(firstVowelLocation) + w.substring(0, firstVowelLocation) + "ay,";
				return (Character.toUpperCase(pigWord.charAt(0)) + pigWord.substring(1));
			}
			return (w.substring(firstVowelLocation) + w.substring(0, firstVowelLocation) + "ay,");
		}
	if (UpperCaseQ == true){
				String pigWord = w.substring(firstVowelLocation) + w.substring(0, firstVowelLocation) + "ay.";
				return (Character.toUpperCase(pigWord.charAt(0)) + pigWord.substring(1));
			}
	return (w.substring(firstVowelLocation) + w.substring(0, firstVowelLocation) + "ay");
    }

	//main method
    public static void main( String[] args ) {

	Scanner sc = new Scanner(System.in);
	while( sc.hasNext() ) {
	    System.out.println( engToPig(sc.next()) );
	}
	/* YOUR TEST CALLS HERE */
	//System.out.println("\nTest for hasA method");
	//System.out.println(hasA("wdawf","m")); //false
	//System.out.println(hasA("Hello, World!"," ")); //true
	//System.out.println(hasA("Hello, World!","!")); //true
	//System.out.println(hasA("Hello, World!", "w")); //false
	//System.out.println(hasA("H","H")); //true
	//System.out.println(hasA(" "," ")); //true
	//System.out.println(hasA("","")); //false
	
	//System.out.println("\nTest for isAVowel method");
	//System.out.println(isAVowel("f")); //false
	//System.out.println(isAVowel("a")); //true
	//System.out.println(isAVowel("e")); //true
	//System.out.println(isAVowel("z")); //false
	//System.out.println(isAVowel("b")); //false
	//System.out.println(isAVowel("")); //false
	
	//System.out.println("\nTest for isAVowel method");
	//System.out.println(countVowels("awdaofbuojebfo")); //7
	//System.out.println(countVowels("")); //0
	//System.out.println(countVowels("aeiou")); //5
	//System.out.println(countVowels("wadefw")); //2
	//System.out.println(countVowels("rgrwas")); //1
	//System.out.println(countVowels("     ")); //0
	
	//System.out.println("\nTest for hasAVowel method");
	//System.out.println(hasAVowel("Johnny Appleseed")); //true
	//System.out.println(hasAVowel("aeiou")); //true
	//System.out.println(hasAVowel("ayyyyyy")); //true
	//System.out.println(hasAVowel("fly")); //false
	//System.out.println(hasAVowel("XXXXXX:)")); //false
	//System.out.println(hasAVowel("wdfghddsgggg")); //false
	
	//System.out.println("\nTest for allVowels method");
	//System.out.println(allVowels("Johnny Appleseed")); //oaeee
	//System.out.println(allVowels("aeiou")); //aeiou
	//System.out.println(allVowels("ayyyyyy")); //a
	//System.out.println(allVowels("fawfeagsely")); //aeae
	//System.out.println(allVowels("XXXXXX:)")); //
	//System.out.println(allVowels("wdfghessegrddsgggg")); //ee

	//System.out.println("\nTest for firstVowel method");
	//System.out.println(firstVowel("Johnny Appleseed")); //o
	//System.out.println(firstVowel("aeiou")); //a
	//System.out.println(firstVowel("ayyyyyy")); //a
	//System.out.println(firstVowel("fawfeagsely")); //a
	//System.out.println(firstVowel("XXXXXX:)")); //
	//System.out.println(firstVowel("wdfghessegrddsgggg")); //e
	//System.out.println(firstVowel("fly:)")); //

	//System.out.println("\nTest for beginsWithVowel method");
	//System.out.println(beginsWithVowel("Johnny Appleseed")); //false
	//System.out.println(beginsWithVowel("aeiou")); //true
	//System.out.println(beginsWithVowel("ayyyyyy")); //true
	//System.out.println(beginsWithVowel("fawfeagsely")); //false
	//System.out.println(beginsWithVowel("XXXXXX:)")); //false
	//System.out.println(beginsWithVowel("ewdfghessegrddsgggg")); //true
	
	//System.out.println("\nTest for beginsWithVowel method");
	//System.out.println(engToPig("Johnny")); //ohnnyJay
	//System.out.println(engToPig("fly")); //flyway
	//System.out.println(engToPig("Mr.Brown Mykolyk")); //own MykolyMr.Brway
	//System.out.println(engToPig("Dawei Huang")); //awei HuangDay
	//System.out.println(engToPig("savage")); //avagesay
	//System.out.println(engToPig("computer science")); //omputer sciencecay
	//System.out.println(engToPig("pfgjjnsis")); //ispfgjjnsay
	//System.out.println(engToPig("")); //
	
    }//end main()

}//end class Pig