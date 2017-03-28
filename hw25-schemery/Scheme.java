// Dawei Huang
// APCS2 pd5
// HW25 -- What a Racket
// 2017-03-28

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *  ALL EXPRESSIONS MUST BE WRITTEN IN A VALID SCHEME FORM!!!
 * <<< YOUR PROCEDURE HERE >>>
	1) Locate the innermost nested operation
	2) Modify the nested expression to a form that can be entered into
	the parameters of the unload method.
	3) Use the Unload method to solve the expression and return a term
	4) Subsitute the term in the place of the original nested list
	5) Is there a single term left (Base Case)? If so return that term. If not repeat 
	steps 1 - 4. (Recursive Step)
 * 
 * STACK OF CHOICE: ___LLStack__ by __library___
 * b/c ...
    Linked lists feels more natural to me for a stack than an ArrayList.
 ******************************************************/

 import java.util.Arrays;
 
public class Scheme 
{
    LLStack<String> _opStack = new LLStack<String>(); 

    /****************************************************** 
     * precond:  Assumes expr is a valid Scheme (prefix) expression,
     *           with whitespace separating all operators, parens, and 
     *           integer operands.
     * postcond: Returns simplified value of expression, as a String
     * eg,
     *           evaluate( "( + 4 3 )" ) -> 7
     *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
     ******************************************************/
    public static String evaluate( String expr ) 
    {
		/* YOUR IMPLEMENTATION HERE */
		String[] expArr = expr.split("\\s+");
		int startOp = 0;
		int endOp = 0;
		
		if(!expr.substring(0,1).equals("(")){
			return expr; 
		}
		for (int i = 0; i < expr.length(); i++){
			if(expr.substring(i, i + 1).equals("(")){
				startOp = i;
			}
			if(expr.substring(i, i + 1).equals(")")){
				endOp = i;
				break;
			}
		}
		String opExpr = expr.substring(startOp, endOp + 1);
		int operand = 0;
		if(opExpr.substring(2,3).equals("+")){
			operand = 1;
		}
		if(opExpr.substring(2,3).equals("-")){
			operand = 2;
		}
		if(opExpr.substring(2,3).equals("*")){
			operand = 3;
		}
		opExpr = opExpr.substring(4, opExpr.length() - 2);
		String[] stackExpr = opExpr.split("\\s+");
		// System.out.println(Arrays.toString(stackExpr));
		LLStack<String> stackArr = new LLStack<String>();
		for(String a : stackExpr){
			stackArr.push(a);
		}
		String opRes = unload(operand, stackArr);
		expr = expr.substring(0,startOp) + opRes + expr.substring(endOp + 1);
		// System.out.println(expr); // to show work in PEMDAS
		return evaluate(expr);
		
    }


    /****************************************************** 
     * precond:  Assumes top of input stack is a number.
     * postcond: Performs op on nums until closing paren
     *           is seen thru peek().
     *           Returns result of applying operator to
     *           sequence of operands.
     *           Ops: + is 1, - is 2, * is 3
     ******************************************************/
    public static String unload( int op, LLStack<String> numbers ) 
    {
	/* YOUR IMPLEMENTATION HERE */
	LLStack<String> tempNum = new LLStack<String>();
	while(numbers.isEmpty() == false){
		tempNum.push(numbers.pop());
	}
	numbers = tempNum;
	int operation = 0;
	if(op == 1){
		operation = 0;
	    while (!numbers.isEmpty()){
		operation += Integer.parseInt(numbers.pop());
	    }
	}
	if(op == 2){
		operation = Integer.parseInt(numbers.pop());
	    while (!numbers.isEmpty()){
		operation -= Integer.parseInt(numbers.pop());
	    }
	}
	if(op == 3){
		operation = 1;
	    while (!numbers.isEmpty()){
		operation *= Integer.parseInt(numbers.pop());
	    }
	}
	return Integer.toString(operation);
    }


    /*
    //optional check-to-see-if-its-a-number helper fxn:
    public static boolean isNumber( String s ) {
        try {
	    Integer.parseInt(s);
	    return true;
	}
        catch( NumberFormatException e ) {
	    return false;
	}
    }
    */


    //main method for testing
    public static void main( String[] args ) 
    {
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	String zoo1 = "( + 4 3 )";
	System.out.println(zoo1);
	System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
	//...7

	String zoo2 = "( + 4 ( * 2 5 ) 3 )";
	System.out.println(zoo2);
	System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
	//...17

	String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
	System.out.println(zoo3);
	System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
	//...29

	String zoo4 = "( - 1 2 3 )";
	System.out.println(zoo4);
	System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
	//...-4
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

    }//main

}//end class Scheme
