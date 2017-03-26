// Dawei Huang
// APCS2 pd5
// HW24 -- Leon Leonwood Stack    
// 2017-03-27

/*****************************************************
 * class LLStack
 * SKELETON
 * Implements ADT stack as specified in local Stack.java
 * Generically typed
 * Uses a LinkedList as underlying container
 *****************************************************/

import java.util.LinkedList;

public class LLStack<T> implements Stack<T> 
{
	private LinkedList<T> _Stack;
	
	//constructor
    public LLStack() 
    { 
	_Stack = new LinkedList<T>();
    }
	
	//Return true if this stack is empty, otherwise false.
    public boolean isEmpty(){
		if (_Stack.size() == 0){
			return true;
		}
		return false;
	}

    //Return top element of stack without popping it.
    public T peek(){
		if(_Stack.size() == 0){
			return null;
		}
		else{
			return _Stack.getLast();
		}
	}

    //Pop and return top element of stack.
    public T pop(){
		if(_Stack.size() == 0){
			return null;
		}
		else{
			T tempElement = _Stack.getLast();
			_Stack.removeLast();
			return tempElement;
		}
	}

    //Push an element onto top of this stack.
    public void	push( T x ){
		if(_Stack.size() == 0){
			_Stack.addFirst(x);
		}
		else{
			_Stack.add(x);
		}
	}

    //main method for testing
    public static void main( String[] args ) 
{
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
	Stack<String> tastyStack = new LLStack<String>();

	tastyStack.push("aoo");
	tastyStack.push("boo");
	tastyStack.push("coo");
	tastyStack.push("doo");
	tastyStack.push("eoo");
	tastyStack.push("foo");
	tastyStack.push("goo");
	tastyStack.push("hoo");
	tastyStack.push("ioo");
	tastyStack.push("joo");
	tastyStack.push("coocoo");
	tastyStack.push("cachoo");

	//cachoo
	System.out.println( "peek: " + tastyStack.peek() ); //"cachoo"
	System.out.println( "pop: " + tastyStack.pop() ); //"cachoo"
	//coocoo
	System.out.println( "peek: " + tastyStack.peek() ); //"coocoo"
	System.out.println( "pop: " + tastyStack.pop() ); //"coocoo"
	//joo
	System.out.println( "peek: " + tastyStack.peek() ); //"joo"
	System.out.println( "pop: " + tastyStack.pop() ); //"joo"
	//ioo
	System.out.println( "peek: " + tastyStack.peek() ); //"ioo"
	System.out.println( "pop: " + tastyStack.pop() ); //"ioo"
	//hoo
	System.out.println( "peek: " + tastyStack.peek() ); //"hoo"
	System.out.println( "pop: " + tastyStack.pop() ); //"hoo"
	//goo
	System.out.println( "peek: " + tastyStack.peek() ); //"goo"
	System.out.println( "pop: " + tastyStack.pop() ); //"goo"
	//foo
	System.out.println( "peek: " + tastyStack.peek() ); //"foo"
	System.out.println( "pop: " + tastyStack.pop() ); //"foo"
	//eoo
	System.out.println( "peek: " + tastyStack.peek() ); //"eoo"
	System.out.println( "pop: " + tastyStack.pop() ); //"eoo"
	//doo
	System.out.println( "peek: " + tastyStack.peek() ); //"doo"
	System.out.println( "pop: " + tastyStack.pop() ); //"doo"
	//coo
	System.out.println( "peek: " + tastyStack.peek() ); //"coo"
	System.out.println( "pop: " + tastyStack.pop() ); //"coo"
	//boo
	System.out.println( "peek: " + tastyStack.peek() ); //"boo"
	System.out.println( "pop: " + tastyStack.pop() ); //"boo"
	//aoo
	System.out.println( "peek: " + tastyStack.peek() ); //"aoo"
	System.out.println( "pop: " + tastyStack.pop() ); //"aoo"

	//stack empty by now; SOP(null)
	System.out.println( "peek: " + tastyStack.peek() ); //null
	System.out.println( "pop: " + tastyStack.pop() ); //null
	System.out.println( tastyStack.pop() ); //null
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~   
    }//end main()

}//end class LLStack
