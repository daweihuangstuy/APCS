// Dawei Huang
// APCS2 pd5
// HW26 -- The English Do Not Wait In Line for Soup or Anything Else; They "Queue Up"
// 2017-03-29

/*****************************************************
 * class LLQueue
 * uses a singly-linked nodes to implement a QUEUE
 * (a collection with FIFO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 ******************************************************/

//import java.util.NoSuchElementException;
//import java.lang.RuntimeException;

public class LLQueue<T> implements Queue<T> 
{
    private LLNode<T> _front, _end;

    // default constructor creates an empty queue
    public LLQueue()
	{ 
		_front = null;
		_end = null;
	}

    // means of adding a thing to the collection
    public void enqueue( T enQVal ) 
    {
		_front = new LLNode(enQVal, _front);
    }//O(1)


    // means of removing a thing from the collection
    // remove and return thing at front of queue
    // assume _queue ! empty
    public T dequeue() 
    { 
		if(_front == _end){
			_front = null;
			_end = null;
			return null;
		}
		LLNode<T> _tempFront = _front;
		_front = _front.getNext();
		return _tempFront.getValue();
    }//O(1)


    // means of peeking at thing next in line for removal
    public T peekFront() 
    {
		return _front.getValue();
    }//O(1)


    public boolean isEmpty() 
    {
		if(_front == null && _end == null){
			return true;
		}
		return false;
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    { 
		String retString = "";
		LLNode<T> tempPointer = _front;
		while(tempPointer.getNext() != null){
			retString += tempPointer.getValue() + " ";
			tempPointer = tempPointer.getNext();
		}
		retString += tempPointer.getValue();
		return retString;
    }//O(n)

    public static void main( String[] args ) {

	//v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
	  Queue<String> LLQueuelJ = new LLQueue<String>();

	  System.out.println("\nnow enqueuing thrice..."); 
	  LLQueuelJ.enqueue("James");
	  LLQueuelJ.enqueue("Todd");
	  LLQueuelJ.enqueue("Smith");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( LLQueuelJ ); //for testing toString()...

	  System.out.println("\nnow dequeuing thrice..."); 
	  System.out.println( LLQueuelJ.dequeue() );
	  System.out.println( LLQueuelJ.dequeue() );
	  System.out.println( LLQueuelJ.dequeue() );

	  System.out.println("\nDequeuing from empty queue should yield error..."); 
	  System.out.println( LLQueuelJ.dequeue() );
	//^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^

    }//end main

}//end class LLQueue
