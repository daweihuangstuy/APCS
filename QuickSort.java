//Dawei Huang
//APCS2 pd5
//HW15 -- So So Fast
//2017-03-08

/*****************************************************
 * class QuickSort
 * (skeleton) <<delete this line if untrue>>
 * Implements quicksort algo to sort an arrayay of ints in place
 *
 * 1. Summary of QuickSort algorithm:
	The QuickSort algorithm uses the divide and conquer method. The QuickSort algorithm divides the array into 
	seperate segments and then QuickSort would be used on every index of the segments until it reaches the
	rightmost index. At the point of the right most index, this recursion method is completed. I postulate that
	the best possible runtime for this algorithm would be nlogn, the worst possible runtime would be n^2.
 
 * 2a. Worst pivotPnt choice / arrayay state and associated runtime: 
	The worst pivotPnt choice would be a pivot point that is either be the smallest or largest value in the
	array segment.
	
 * 2b. Best pivotPnt choice / arrayay state and associated runtime:
	The best pivotPnt choice would be a point that is directly at the center of the array segment.
 * 3. Approach to handling duplicate values in arrayay:
	This code appears to work well with duplicates because duplicates need not be organized into camps
	that are either smaller or larger than the pivot position.
 *****************************************************/

/***
    PROTIP: Assume no duplicates during initial development phase.
    Once you have a working implementation, test against arrayays 
    with duplicate values, and revise if necessary. (Backup first.)
 ***/

public class QuickSort 
{
    //--------------v  HELPER METHODS  v--------------
    //swap values at indices x, y in arrayay o
    public static void swap( int x, int y, int[] o ) {
	int tmp = o[x];
	o[x] = o[y];
	o[y] = tmp;
    }

    //print input arrayay 
    public static void printarray( int[] a ) {
	for ( int o : a )
	    System.out.print( o + " " );
	System.out.println();
    }

    //shuffle elements of input arrayay
    public static void shuffle( int[] d ) {
	int tmp;
	int swapPos;
	for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
	}
    }

    //return int arrayay of size s, with each element fr range [0,maxVal)
    public static int[] buildarrayay( int s, int maxVal ) {
	int[] retarray = new int[s];
	for( int i = 0; i < retarray.length; i++ )
	    retarray[i] = (int)( maxVal * Math.random() );
	return retarray;
    }
    //--------------^  HELPER METHODS  ^--------------



    /*****************************************************
     * void qsort(int[])
     * @param d -- arrayay of ints to be sorted in place
     *****************************************************/
    public static void qsort( int[] array){
	qsort(array, 0, array.length-1);
    }
    public static void qsort( int[] array, int leftSide, int rightSide){
	int pivotPnt = partition(array,leftSide,rightSide);
	if (leftSide < pivotPnt - 1)
	    qsort(array,leftSide,pivotPnt - 1);
	if (pivotPnt + 1 < rightSide)
	    qsort(array,pivotPnt + 1 , rightSide);
	return;
    }

    public static int partition( int[] array, int leftSide , int rightSide){
	int pivVal = array[leftSide];
        int temp = array[leftSide];
        array[leftSide] = array[rightSide];
        array[rightSide] = temp;
        int pivFinalpos = leftSide;
        for (int i=leftSide; i<rightSide; i++){
            if (array[i]<pivVal){
                int temp2 = array[pivFinalpos];
                array[pivFinalpos] = array[i];
                array[i] = temp2;
                pivFinalpos+=1;
            }
        }
        int temp3 = array[pivFinalpos];
        array[pivFinalpos] = array[rightSide];
        array[rightSide] = temp3;
	return pivFinalpos;//return any one
    }

    //main method for testing
    public static void main( String[] args ) 
    {
	

	//main method for testing static cases
	int [] array1 = {7,1,5,12,3};
	System.out.println("\narray1 init'd to: " );
	printarray(array1);

	
	qsort( array1 , 0 , array1.length-1);	
       	System.out.println("array1 after qsort: " );
	printarray(array1);

	// randomly-generated arrayays of n distinct vals
	int[] arrayN = new int[10];
	for( int i = 0; i < arrayN.length; i++ )
	    arrayN[i] = i;
       
	System.out.println("\narrayN init'd to: " );
	printarray(arrayN);

       	shuffle(arrayN);
       	System.out.println("arrayN post-shuffle: " );
	printarray(arrayN);

	qsort( arrayN , 0 , arrayN.length-1);
	System.out.println("arrayN after sort: " );
	printarray(arrayN);
	/*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/


	//~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 

	//duplicate cases included
	int [] array2 = {7,1,5,12,3,7};
	System.out.println("\narray2 init'd to: " );
	printarray(array2);

	qsort( array2 );	
       	System.out.println("array2 after qsort: " );
	printarray(array2);


	// randomly generated integers
	int[] arrayTest = new int[20];
	for( int i = 0; i < arrayTest.length; i++ )
	    arrayTest[i] = (int)( 48 * Math.random() );
       
	System.out.println("\narrayTest init'd to: " );
	printarray(arrayTest);

       	shuffle(arrayTest);
       	System.out.println("arrayTest post-shuffle: " );
	printarray(arrayTest);

	qsort( arrayTest );
	System.out.println("arrayTest after sort: " );
	printarray(arrayTest);
//	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

    }//end main

}//end class QuickSort
