//Dawei Huang
//APCS2 pd5
//HW14 --  So So Fast
//2017-03-08

/*
My algorithm uses the partition Sort method. In order to find the nth least number in a 
given array, I indexed through the array and if the value of an index + 1 is equal to the
int returned by the partition sort then that would guarentee that the value of that index
is the nth least number. If the partition Sort returns n - 1 numbers less than the given number
than that would prove that that number is the nth least int.
*/

public class FastSelect{
	
	public static void main( String[] args ){
		int[] arrTest = new int[5];
		//test 1
		arrTest[0] = 3;
		arrTest[1] = 1;
		arrTest[2] = 16;
		arrTest[3] = 599;
		arrTest[4] = 1024;
		System.out.println(quickFind(2,arrTest));
		
		//test 2
		arrTest[0] = 4;
		arrTest[1] = 6;
		arrTest[2] = 8;
		arrTest[3] = 969;
		arrTest[4] = 10344;
		System.out.println(quickFind(1,arrTest));
		
		//test 3
		arrTest[0] = 123;
		arrTest[1] = 612;
		arrTest[2] = 851;
		arrTest[3] = 91239;
		arrTest[4] = 1042;
		System.out.println(quickFind(5,arrTest));
	}
	
	public static int quickFind(int smallNum, int[] tempArray){
		int[] array = tempArray;
		for (int i = 0; i < array.length; i++){
			if(partitionSort(array, 0, array.length - 1, i) == smallNum - 1){
				return array[i];
			}
		}
		return -1;
	}
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



    public static int partitionSort( int arr[], int a, int b, int c)
    {
	int v = arr[c];

	swap( c, b, arr);
	int s = a;

	for( int i = a; i < b; i++ ) {
	    if ( arr[i] <= v) {
		swap( i, s, arr );
		s++;}
	}
	swap(s,b,arr);

	return s;
    }//end mysterion
}