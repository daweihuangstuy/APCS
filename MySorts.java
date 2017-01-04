// Dawei Huang
// APCS1 pd4
// HW54 -- Never Fear, Big O Is Here!
// Due: 2017-01-04

public class MySorts{
	
	// worst/best case scenario: n(n+1)/2
	// categorization: quadratic
	// it is quadratic because as you go through the index of the data set, you would have
	// to compare that index with the data at the beginnig of that data set until you 
	// get to that index. As the index increases, you would have to do more passes.
	public static ArrayList<Comparable> insertionSort( ArrayList<Comparable> input ) 
{
	/* YOUR IMPLEMENTATION HERE */	
	ArrayList<Comparable> Bert = input;
	insertionSortV(input);
	return input;
    }//end insertionSort
	
	//-----------------------------------------------------------------------
	
	// worst/best case senario: n
	// categorization: linear
	// For every time you place the greatest value at the right most end you 
	// have to accomplish a pass of the data set. Therefore the amount of passes
	// you would have to perform has a linear relationship to the size of the
	// data set.
	public static void selectionSortV( ArrayList<Comparable> data ) 
{
	//note: this version places greatest value at rightmost end,

	//maxPos will point to position of SELECTION (greatest value)
	int currentPos = data.size() - 1;
	int maxPos;
	/* YOUR IMPLEMENTATION HERE */
	while (currentPos > 0){
		maxPos = currentPos;
	    for (int i = currentPos - 1; i >= 0; i--){
		if (data.get(currentPos).compareTo(data.get(i)) < 0){
		    if (data.get(i).compareTo(data.get(maxPos)) > 0){
			maxPos = i;
		    }
		}
	    }
	    if (maxPos != currentPos){
		Comparable data1 = data.get(currentPos);
		Comparable data2 = data.get(maxPos);
		data.set(maxPos, data1);
		data.set(currentPos, data2);
	    }
	    // System.out.println(data);
		currentPos -= 1;
	}
}//end selectionSort

	//-----------------------------------------------------------------------

	// worst/best case senario: n(n-1)
	// categorization: quadratic
	// Given a data set that is ordered from the greatest to the least, After each pass,
	// the largest value should float to the top. Thus the most passes you would have to do
	// would be the square of the data set would be the square of the data in the data set.
	public static void bubbleSortV( ArrayList<Comparable> data ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	boolean testSorted = true;
	while (testSorted == true){
	    for(int index = 0; index < data.size() - 1; index++){
		if(data.get(index).compareTo(data.get(index + 1)) > 0){
		    Comparable save1 = data.get(index);
		    Comparable save2 = data.get(index + 1);
		    data.set(index, save2);
		    data.set(index + 1, save1);
		    testSorted = false;
		}
	    }
	    if (testSorted == true){
		return;
	    }
	    testSorted = true;
	}
    }//end bubbleSortV

}