//Dawei Huang
//Due: 12/09/2016
//Period 4 APCS w/ Mr. Brown Mykolyk
//HW #42 -- Array of Grade 316_

/*==================================================
  class SuperArray version 2.0
  Wrapper class for array. Facilitates resizing, 
  expansion, and read/write capability on elements.
  ==================================================*/

public class SuperArray 
{
    private int[] _data;  //underlying container structure
    private int _lastPos; //marker for last meaningful value
    private int _size;    //number of meaingful values

    //default constructor
    //initializes 10-item array
    public SuperArray() 
    { 
	/* YOUR IMPLEMENTATION HERE */
	_data = new int[10];
	_lastPos = -1;
	_size = 0;	
    }

    //output array in [a,b,c] format
    //eg, for int[] a = {1,2,3} ...
    //toString() -> "[1,2,3]"
    public String toString() 
    { 
	/* YOUR IMPLEMENTATION HERE */
	String retrStr = "[";
	for(int i = 0; i < _data.length - 1; i += 1){
		retrStr += _data[i] + ",";
	}
	retrStr = retrStr.substring( 0, retrStr.length()-1 ) + "]"; 
	return retrStr;
	}

    //double capacity of this instance of SuperArray 
    private void expand() 
    { 
	/* YOUR IMPLEMENTATION HERE */
	int[] newData = new int[_data.length * 2];
	for ( int i = 0; i < _data.length; i += 1 ){
		newData[i] = _data[i];
	}
	_data = newData;
    }

    //accessor method -- return value at specified index
    public int get( int index ) 
    {
	/* YOUR IMPLEMENTATION HERE */
		return _data[index];
    }

    //mutator method -- set index to newVal, return old value at index
    public int set( int index, int newVal ) 
    {
	/* YOUR IMPLEMENTATION HERE */
		int oldVal = _data[index];
		_data[index] = newVal;
		return oldVal;
    }
	//adds an item after the last item
    public void add( int newVal ) 
    { 
	/* YOUR IMPLEMENTATION HERE */
	_lastPos += 1;
	_size += 1;
	_data[_lastPos] = newVal;
    }

    //inserts an item at index
    //shifts existing elements to the right
    public void add( int index, int newVal ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	int[] newData = new int[_data.length + 1];
	for ( int i = 0; i < _data.length; i += 1 ){
		newData[i] = _data[i];
	}
	_data = newData;
	for (int i = newData.length - 1; i > index; i -= 1){
		newData[i] = newData[i - 1];  
	}
	newData[index] = newVal;
	_size += 1;
	_lastPos += 1;
    }

    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	for (int i = index; i < _data.length - 2; i += 1){
		_data[i] = _data[i + 1];
	}
	_size -= 1;
	_lastPos -= 1;
    }

    //return number of meaningful items in _data
    public int size() 
    {
	/* YOUR IMPLEMENTATION HERE */
	return _size;
    }

    //main method for testing
    public static void main( String[] args ) 
    {
	SuperArray curtis = new SuperArray();
	System.out.println("Printing empty SuperArray curtis...");
	System.out.println(curtis);

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set(i,i*2);
	    curtis._size++;
	}

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(curtis);

	SuperArray mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.add(5);
	mayfield.add(4);
	mayfield.add(3);
	mayfield.add(2);
	mayfield.add(1);

	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);

	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	mayfield.remove(3);
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);

	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
    }//end main()

}//end class SuperArray
