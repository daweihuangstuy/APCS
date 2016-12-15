//Dawei Huang
//APCS1 pd4
//HW46 -- ascending 
//12/15/16

/*============================================
  class OrderedArrayList
  Wrapper class for ArrayList.
  Imposes the restriction that stored items 
  must remain sorted in ascending order
  ============================================*/

//ArrayList's implementation is in the java.util package
import java.util.ArrayList;


public class OrderedArrayList {

    // instance of class ArrayList, holding objects of type Comparable 
    // (ie, instances of a class that implements interface Comparable)
    private ArrayList<Comparable> _data;

    // default constructor initializes instance variable _data
    public OrderedArrayList() {
		_data = new ArrayList<Comparable>();
    }

	//toString method
    public String toString() { 
		String retrString = "";
		for(int i = 0; i < _data.size() - 1; i++){
			retrString += _data.get(i) + "\t";
		}
		return retrString;
    }

	//removes Objects of type Comparable at a provided index
    public Comparable remove( int index ) { 
		Comparable data = _data.get(index);
		_data.remove(index);
		return data;
    }
		
	// returns the size of the data
    public int size() {
		return _data.size();
    }

    //returns the object of type Comparable at a specified index
    public Comparable get( int index ) { 
		return _data.get(index);
    }


    // addLinear takes as input any comparable object 
    // (i.e., any object of a class implementing interface Comparable)
    // inserts newVal at the appropriate index
    // maintains ascending order of elements
    // uses a linear search to find appropriate index
    public void addLinear( Comparable newVal ) { 
		int targetIndex = 0;
		if (_data.size() == 0){
			_data.add(newVal);
		}
		if ((int)_data.get(0) > (int)newVal){
			_data.add(0, newVal);
		}
		else if ((int)_data.get(_data.size() - 1) < (int)newVal){
			_data.add(newVal);
		}
		else {
			for(int i = 0; i < _data.size(); i++){
				if((int)_data.get(i) <= (int)newVal){
					targetIndex = i + 1;
				}
			}
			_data.add(targetIndex, newVal);
		}
    }


    // main method solely for testing purposes
    public static void main( String[] args ) {

	OrderedArrayList Franz = new OrderedArrayList();

	System.out.println("\nValues to add via addLinear() calls:");

	// testing linear search
	System.out.println( Franz );
	for( int i = 0; i < 15; i++ ) {
	    int valToAdd = (int)( 50 * Math.random() );
	    System.out.println( valToAdd );
	    Franz.addLinear( valToAdd );
	}

	System.out.println("\nafter population via addLinear() calls:");
	System.out.println( Franz );
	System.out.println();

    }

}//end class OrderedArrayList
 
