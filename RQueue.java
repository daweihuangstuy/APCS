// Dawei Huang
// APCS2 pd5
// HW28 -- Now Let’s Consider You Lot at Fake Terry’s
// 2017-03-31

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite data flow for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 * maintains these invariants: 
 * dequeuing removes/returns a random element
 * _front always points to next item to be removed
 ******************************************************/

import java.util.ArrayList;

public class RQueue<T> implements Queue<T> 
{
    private LLNode<T> _front, _end;
    private int _size;


    // default constructor creates an empty queue
    public RQueue() 
	{ 
	    /* YIH */
	    _front = null;
	    _end = null;
	    _size = 0;
	}


    public void enqueue( T enQVal ) 
    {
	/* YIH */
	if (_front == null){
	    _front = new LLNode(enQVal, null);
	    _end = _front;
	}
	else{
	    _end.setNext(new LLNode(enQVal, null));
		_end = _end.getNext();
		_end.setNext(_front);
	}
	_size += 1;
    }


    // remove and return thing at front of queue, then reorder elements
    // assume _queue ! empty
    public T dequeue() 
    { 
	/* YIH */
	if(_front == null){
		return null;
	}
	T frontStor = _front.getValue();
	_front = _front.getNext();
	sample();
	_size -= 1;
	return frontStor;
	}

    //return next item to be dequeued
    public T peekFront() 
    {
	return _front.getValue();
    }


    /******************************************
     * void sample() -- a means of "shuffling" the queue
     * algo:
     * 
     * 
     ******************************************/
    public void sample () 
    {
	/* YIH */
	ArrayList<LLNode> queueStor = new ArrayList<LLNode>();
	LLNode pointer = _front;
	while(pointer != _end){
		queueStor.add(((int)(Math.random() * (queueStor.size() + 1))), pointer);
		pointer = pointer.getNext();
    }
	queueStor.add(((int)(Math.random() * (queueStor.size() + 1))), pointer);
	_end = pointer;
	_front = queueStor.get(0);
	queueStor.remove(0);
	pointer = _front;
	while(queueStor.size() > 0){
		pointer.setNext(queueStor.get(0));
		queueStor.remove(0);
		pointer = pointer.getNext();
	}
	_end = pointer;
    }


    public boolean isEmpty() 
    { 
	/* YIH */
	return _front == null;
    }//O(1)


    // print each node, separated by spaces
    public String toString() 
    { 
	/* YIH */
	String retStr = "[";
	LLNode pointer = _front;
	while(pointer != _end){
		retStr += pointer.getValue() + ", ";
		pointer = pointer.getNext();
	}
	retStr += pointer.getValue() + "]";
	return retStr;
    }//O(n)



    //main method for testing
    public static void main( String[] args ) 
    {
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  Queue<String> PirateQueue = new RQueue<String>();

	  System.out.println("\nnow enqueuing..."); 
	  PirateQueue.enqueue("Dread");
	  PirateQueue.enqueue("Pirate");
	  PirateQueue.enqueue("Robert");
	  PirateQueue.enqueue("Blackbeard");
	  PirateQueue.enqueue("Peter");
	  PirateQueue.enqueue("Stuyvesant");

	  System.out.println("\nnow testing toString()..."); 
	  System.out.println( PirateQueue ); //for testing toString()...

	  System.out.println("\nnow dequeuing..."); 
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  System.out.println( PirateQueue.dequeue() );
	  // System.out.println( PirateQueue);

	  System.out.println("\nnow dequeuing fr empty queue..."); 
	  System.out.println( "" );
	  // ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    }//end main

}//end class RQueue
