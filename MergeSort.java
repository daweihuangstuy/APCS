// Dawei Huang
// Due 2017-02-12
// APCS2 Period 5
// HW #06: Step 1: Split, Step 2: ?, Step 3: Sorted!. . .

/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  Merge: My merge algorith takes the first element of arrays a and b and compares
  them with each other. If the first element of arrays a and b are equal in value,
  I would add the first element of both arrays to the final array and remove the
  first element of each array. If the first element of array a is greater than the
  first element of array b, I add the first element of array b to the final array
  and I remove the first element of array b. Lastly, if the first element of array
  b is greater than the first element of array a, I add the first element of array
  a to the final array and I remove the first element of array a. I keep on repeating
  the above stps until either one of arrays a or b is empty. If a is empty, I append
  the rest of array b to the final array and likewise if b is empty, I apend the rest
  of array a to the final array. The returning the final array would return the merged
  array of arrays a and b.
  
  Sort: For my sort algorithm, I chose the first element of the given array and I placed
  into a final array that I created. After this, I removed the first element of the given
  array. After this step you would repeatedly choose the first element of the given array
  and find the spot where it fits in the growing final array. After there is no more 
  elements in the given array, returning the final array would give you the sorted given
  array.

  ======================================*/
import java.util.ArrayList;

public class MergeSort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
		ArrayList<Integer> aTemp = new ArrayList<Integer>();
		ArrayList<Integer> bTemp = new ArrayList<Integer>();
		ArrayList<Integer> finalArr = new ArrayList<Integer>();
		int[] returnArr = new int[0];
		
		a = sort(a);
		b = sort(b);
		
		for(int x : a){
			aTemp.add(x);			
		}
		for(int x : b){
			bTemp.add(x);
		}
		while(aTemp.size() > 0 && bTemp.size() > 0){
			if(aTemp.get(0) == bTemp.get(0)){
				finalArr.add(aTemp.get(0));
				finalArr.add(bTemp.get(0));
				aTemp.remove(0);
				bTemp.remove(0);
			}			
			else if(aTemp.get(0) > bTemp.get(0)){
				finalArr.add(bTemp.get(0));
				bTemp.remove(0);
			}
			else if(aTemp.get(0) < bTemp.get(0)){
				finalArr.add(aTemp.get(0));
				aTemp.remove(0);
			}
			
		}
		if(aTemp.size() == 0){
			for(int x = 0; x < bTemp.size(); x++){
				finalArr.add(bTemp.get(x));
			}
		}
		if(bTemp.size() == 0){
			for(int x = 0; x < aTemp.size(); x++){
				finalArr.add(aTemp.get(x));
			}
		}
		returnArr = new int[finalArr.size()];
		for(int i = 0; i < returnArr.length; i++){
			returnArr[i] = finalArr.get(i);
		}
		return returnArr;
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
		ArrayList<Integer> arrDup = new ArrayList<Integer>();
		ArrayList<Integer> finalArr = new ArrayList<Integer>();
		int[] returnArr = new int[arr.length];
		
		if(arr.length == 0 || arr.length == 1){
			return arr;
		}
		
		for(int x : arr){
			arrDup.add(x);
		}
		while (arrDup.size() > 0){
			int location = 0;
			boolean placed = false;
			if(finalArr.size() == 0){
				finalArr.add(arrDup.get(0));
				arrDup.remove(0);
			}
			for(int i = 0; i < finalArr.size(); i++){
				if(arrDup.get(0) > finalArr.get(i) || arrDup.get(0) == finalArr.get(i)){
					location = i;
					placed = true;
					break;
				}
			}
			if (placed == true){
				finalArr.add(location,arrDup.get(0));
				arrDup.remove(0);
			}
			else{
				finalArr.add(arrDup.get(0));
				arrDup.remove(0);
			}
		}
		for(int i = 0; i < finalArr.size(); i++){
			returnArr[i] = finalArr.get((finalArr.size() - 1) - i);
		}
		return returnArr;
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
	for( int i = 0 ; i<a.length; i++ )
	    a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
	System.out.print("[");
	for( int i : a )
	    System.out.print( i + ",");
	System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

	// ~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
	int[] arr0 = {0};
	int[] arr1 = {1};
	int[] arr2 = {1,2};
	int[] arr3 = {3,4};
	int[] arr4 = {1,2,3,4};
	int[] arr5 = {4,3,2,1};
	int[] arr6 = {9,42,17,63,0,512,23};
	int[] arr7 = {9,42,17,63,0,9,512,23,9};

	System.out.println("\nTesting mess-with-array method...");
	printArray( arr3 );
	mess(arr3);
	printArray( arr3 );

	System.out.println("\nMerging arr1 and arr0: ");
	printArray( merge(arr1,arr0) );

	System.out.println("\nMerging arr4 and arr6: ");
	printArray( merge(arr4,arr6) );

	System.out.println("\nSorting arr4-7...");
	printArray( sort( arr4 ) );
	printArray( sort( arr5 ) );
	printArray( sort( arr6 ) );
	printArray( sort( arr7 ) );
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    }//end main()

}//end class MergeSort

