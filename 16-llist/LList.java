//Dawei Huang
//APCS2 pd5
//HW18b -- On the DLL
//2017-03-16

/*****************************************************
 * class LList
 * skeleton
 * Implements a linked list of DLLNodes.
 *****************************************************/

public class LList implements List 
{ //your homemade List.java must be in same dir

    //instance vars
    private DLLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) 
    {
		_head = null;
		_size = 0;
    }


    //--------------v  List interface methods  v--------------

    /* YOUR IMPLEMENTATIONS HERE */
	public boolean add( String x ){
		if(_head == null){
			_head = new DLLNode(null, x, null);
			_size += 1;
			return true;
		}
		DLLNode Node = _head;
		while(Node.getNext() != null){
			Node = Node.getNext();
		}
		Node.setNext( new DLLNode(null, x, null ) );
		_size += 1;
		return true;
	}	

    public String get( int i ){
		DLLNode Node = _head;
		for (int a = i; a > 0; a--){
			Node = Node.getNext();
		}
		return Node.getCargo();
	}
	
    public String set( int i, String x ){
		DLLNode Node = _head;
		for (int a = i; a > 0; a--){
			Node = Node.getNext();
		}
		Node.setCargo(x);
		return Node.getCargo();
	}
    //return number of nodes in list
    public int size() { return _size; } 
	
	//insert a node containing newVal at position index
    public void add( int index, String newVal ){
		DLLNode Node = _head;
		if(index == 0){
			DLLNode oldHead = _head;
			_head = new DLLNode(null, newVal, oldHead);
			_size += 1;
			return;
		}
		for (int i = index; i > 1; i--){
			Node = Node.getNext();
		}
		DLLNode oldNext = Node.getNext();
		Node.setNext(new DLLNode (null, newVal, oldNext));	
		_size += 1;
	} 

    //remove node at pos index, return its cargo
    public String remove( int index ){
		DLLNode Node = _head;
		if(index == 0){
			_head = _head.getNext();
			_size -= 1;
			return _head.getCargo();
		}
		for (int i = index; i > 1; i--){
			Node = Node.getNext();
		}
		DLLNode oldNext = Node.getNext();
		Node.setNext(Node.getNext().getNext());
		_size -= 1;
		return Node.getCargo();
	}

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	DLLNode tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args ) 
    {
	//~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y) 
	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

	System.out.println( james );
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	//test remove at index method
	james.remove(2);
	System.out.println( "remove index 2");
	System.out.println( james );
	
	//test add at index method
	james.add(2, "bungalow");
	System.out.println( "add bungalow to index 2");
	System.out.println( james );
	
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    }

}//end class LList



