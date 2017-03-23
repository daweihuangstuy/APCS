// Dawei Huang
// APCS2 pd5
// HW22 -- Stacks on Stacks on Stacks on Stacks ... ... (Do I Smell Recursion?)
// 2017-03-23

/***
 * class Latkes
 * SKELETON
 * (actually: a class to implement a stack of Strings)
 * uses an array as underlying data structure
 ***/

public class Latkes 
{

    private String [] _stack;
    private int _stackSize;

    //constructor
    public Latkes(int size) 
    { 
	/* YOUR IMPLEMENTATION HERE */
		_stackSize = size;
		_stack = new String[size];
    }

    //means of insertion
    public void push( String s ) 
    {
	/* YOUR IMPLEMENTATION HERE */
		if (isFull() == false){
			for(int i = _stackSize - 2; i >= 0; i--){
				_stack[i + 1] = _stack[i];
			}
			_stack[0] = s;
		}
		
    }

    //means of removal
    public String pop() 
    { 
	/* YOUR IMPLEMENTATION HERE */
		String retStr = _stack[0];
		if (isEmpty() == false){
			for(int i = 0; i <= _stackSize - 2; i++){
				_stack[i] = _stack[i + 1];
			}
		}
		return retStr;
    }

    //chk for emptiness
    public boolean isEmpty() 
    { 
	/* YOUR IMPLEMENTATION HERE */
		return _stack[0].equals("");
    }

    //chk for fullness
    public boolean isFull() 
    {
	/* YOUR IMPLEMENTATION HERE */
		return !_stack[_stackSize - 1].equals("");
    }

}//end class Latkes

