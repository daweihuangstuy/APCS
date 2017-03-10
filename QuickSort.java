//Dawei Huang
//APCS2 pd5
//HW15 -- So So Fast
//2017-03-08

/*****************************************************
 * class QuickSort
 * (skeleton) <<delete this line if untrue>>
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * The QuickSort algorithm implements a divide and conquer methodology. Theoretically (best case), the 
 pivot selected end up around the middle of the array. Next, QuickSort is called on the two new segments,
 and so on, until the pivot is the same as the right bound and the left bound, at whih point the recursion is finished,
 as every position has only greater values to the right, and only lower values to the left. The worst case for the algorithm 
 however, is n^2. The BEST POSSIBLE is nlogn, meaning usually it is more.
 (I like mergesort more)
 * 2a. Worst pivot choice / array state and associated runtime: 
 * The worst pivot choice would be a pivot that is the smalles or largest of the inspected section. 
 This would only eliminate sort one number at a time. O(n^2)
 * 2b. Best pivot choice / array state and associated runtime:
 * The pivot whos final resting spot is directly in the middle of the inspected section. 
 This minimizaes the number of passes. O(nlogn)
 * 3. Approach to handling duplicate values in array:
 * Nothing. The code works with duplicates. :)
 *****************************************************/

/***
    PROTIP: Assume no duplicates during initial development phase.
    Once you have a working implementation, test against arrays 
    with duplicate values, and revise if necessary. (Backup first.)
 ***/

public class QuickSort 
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in array o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input array 
    public static void printArr( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input array
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int array of size s, with each element fr range [0,maxVal)
    public static int[] buildArray( int s, int maxVal ) {
	int[] retArr = new int[s];
	for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
	return retArr;
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- array of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] arr){
	qsort(arr, 0, arr.length-1);
    }
    public static void qsort( int[] arr, int left, int right){
	int pivot = partition(arr,left,right);
	if (left < pivot - 1)
	    qsort(arr,left,pivot - 1);
	if (pivot + 1 < right)
	    qsort(arr,pivot + 1 , right);
	return;
    }

    public static int partition( int[] arr, int left , int right){
	int pivVal = arr[left];
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
        int pivFinalpos = left;
        for (int i=left; i<right; i++){
            if (arr[i]<pivVal){
                int temp2 = arr[pivFinalpos];
                arr[pivFinalpos] = arr[i];
                arr[i] = temp2;
                pivFinalpos+=1;
            }
        }
        int temp3 = arr[pivFinalpos];
        arr[pivFinalpos] = arr[right];
        arr[right] = temp3;
	return pivFinalpos;//return any one
    }
	

    
    

    //main method for testing
    public static void main( String[] args ) 
    {
	

	//get-it-up-and-running, static test case:
	int [] arr1 = {7,1,5,12,3};
	System.out.println("\narr1 init'd to: " );
	printArr(arr1);

	
	qsort( arr1 , 0 , arr1.length-1);	
       	System.out.println("arr1 after qsort: " );
	printArr(arr1);

	// randomly-generated arrays of n distinct vals
	int[] arrN = new int[10];
	for( int i = 0; i < arrN.length; i++ )
	    arrN[i] = i;
       
	System.out.println("\narrN init'd to: " );
	printArr(arrN);

       	shuffle(arrN);
       	System.out.println("arrN post-shuffle: " );
	printArr(arrN);

	qsort( arrN , 0 , arrN.length-1);
	System.out.println("arrN after sort: " );
	printArr(arrN);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


	//~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

	//get-it-up-and-running, static test case w/ dupes:
	int [] arr2 = {7,1,5,12,3,7};
	System.out.println("\narr2 init'd to: " );
	printArr(arr2);

	qsort( arr2 );	
       	System.out.println("arr2 after qsort: " );
	printArr(arr2);


	// arrays of randomly generated ints
	int[] arrMatey = new int[20];
	for( int i = 0; i < arrMatey.length; i++ )
	    arrMatey[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrMatey init'd to: " );
	printArr(arrMatey);

       	shuffle(arrMatey);
       	System.out.println("arrMatey post-shuffle: " );
	printArr(arrMatey);

	qsort( arrMatey );
	System.out.println("arrMatey after sort: " );
	printArr(arrMatey);
//	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort
