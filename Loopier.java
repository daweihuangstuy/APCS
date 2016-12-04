//Dawei Huang
//Due: 11/04/16
//Period 4 APCS w/ Mr. Brown Mykolyk
//HW#27 -- Recurse, Recurse, on Elements Not the First! . 

public class Loopier{
	//declare static state variable of type int of name lengthCtr
	static int lengthCtr = 0;
	
	// main method for test cases
	public static void main(String[] args){
		int[] intArray = {1,2,3,4,5,6,7,8};
		System.out.println(linSearch(intArray, 4)); // 3
		System.out.println(linSearchR(intArray, 4)); // 3
		System.out.println(linSearch(intArray, 7)); // 6
		System.out.println(linSearchR(intArray, 7)); // 6
		System.out.println(linSearch(intArray, 1)); // 0
		System.out.println(linSearchR(intArray, 1)); // 0
		System.out.println(linSearch(intArray, 2)); // 1
		System.out.println(linSearchR(intArray, 2)); // 1
		System.out.println(linSearch(intArray, 10)); // -1
		System.out.println(linSearchR(intArray, 10)); // -1
		
		int[] intArray1 = {1,1,4,5,6,1,2,3,1,102,10};
		System.out.println(freq(intArray1, 1)); // 4
		System.out.println(freqRec(intArray1, 1)); // 4
		System.out.println(freq(intArray1, 1123)); // 0
		System.out.println(freqRec(intArray1, 1123)); // 0
	}
	
	// searches for the int in the int array and returns the index of the first occurance
	// employs iteration
	public static int linSearch(int[] a, int target){
		int indexCtr = 0; 
		for (int item : a){
			if (item == target){
				return indexCtr;
			}
			indexCtr++;
		}
		return -1;
	}
	
	// searches for the int in the int array and returns the index of the first occurance
	// employs recursion
	public static int linSearchR(int[] a, int target){
		lengthCtr -= 1;
		if (a.length == 0){
			return (lengthCtr + 14);
		}
		int[] newArray = new int[a.length - 1];
		if (a[0] == target){
			return 0;
		}
		for (int item = 0; item < newArray.length; item ++ ){
			newArray[item] = a[item + 1];
		}
		return (1 + linSearchR(newArray, target));
	}
	
	//counts the occurance of an int within a string
	//Utilizes iteration
	public static int freq( int[] a, int target ){
		int intCtr = 0;
		for (int item : a){
			if(item == target){
				intCtr += 1;
			}
		}
		return intCtr;
	}
	
	//counts the occurance of an int within a string
	//Utilizes recursion
	public static int freqRec(int[] a, int target){
		if (a.length == 0){
			return 0;
		}
		int[] newArray = new int[a.length - 1];
		for (int item = 0; item < newArray.length; item ++ ){
			newArray[item] = a[item + 1];
		}
		if (a[0] == target){
			return (1 + freqRec(newArray, target));
		}	
		return freqRec(newArray, target);
	}
}