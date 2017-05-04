// Dawei Huang
// APCS2 pd5
// HW34 -- Algorithm as Data Structure
// 2017-05-04

/*****************************************************
 * class BST
 * <<< skeleton >>>
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT) 
 * A BST maintains the invariant that, for any node N with value V, 
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value, 
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST 
{
    //instance variables / attributes of a BST:
    private TreeNode root;

    /*****************************************************
     * default constructor
     *****************************************************/
    BST( ) 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	TreeNode root = null;
    }


    /*****************************************************
     * void insert( int ) 
     * Adds a new data element to the tree at appropriate location.
     *****************************************************/
    public void insert( int newVal ) 
    {
     	/*** YOUR IMPLEMENTATION HERE ***/
		if (root == null){
			root = new TreeNode(newVal);
			return;
		}
		TreeNode currNode = root;
		while(currNode.getLeft() != null || currNode.getRight() != null){
			if (newVal > currNode.getValue()){
				if(currNode.getRight() == null){
					break;
				}
				currNode = currNode.getRight();
			}
			else if (newVal < currNode.getValue()){
				if(currNode.getLeft() == null){
					break;
				}
				currNode = currNode.getLeft();
			}
		}
		if (newVal > currNode.getValue()){
			currNode.setRight(new TreeNode(newVal));
		}
		else if (newVal < currNode.getValue()){
			currNode.setLeft(new TreeNode(newVal));
		}
    }


    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

    // each traversal should simply print to standard out 
    // the nodes visited, in order

    public void preOrderTrav() 
    {
    	/*** YOUR IMPLEMENTATION HERE ***/
		preOrder(root);	
    }
	
	public void preOrder(TreeNode node){
		System.out.println(node.getValue());
		if(node.getLeft() != null){
			preOrder(node.getLeft());
		}
		if(node.getRight() != null){
			preOrder(node.getRight());
		}
	}

    public void inOrderTrav() 
    {
    	/*** YOUR IMPLEMENTATION HERE ***/
		inOrder(root);		
    }
	
	public void inOrder(TreeNode node){
		if(node.getLeft() != null){
			preOrder(node.getLeft());
		}
		System.out.println(node.getValue());
		if(node.getRight() != null){
			preOrder(node.getRight());
		}
	}

    public void postOrderTrav() 
    {
    	/*** YOUR IMPLEMENTATION HERE ***/
		postOrder(root);
    }
	
	public void postOrder(TreeNode node){
		if(node.getLeft() != null){
			preOrder(node.getLeft());
		}
		if(node.getRight() != null){
			preOrder(node.getRight());
		}
		System.out.println(node.getValue());
	}
    //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    //main method for testing
    public static void main( String[] args ) 
    {
	//~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
	  BST arbol = new BST();

	  arbol.insert( 4 );
	  arbol.insert( 2 );
	  arbol.insert( 5 );
	  arbol.insert( 6 );
	  arbol.insert( 1 );
	  arbol.insert( 3 );

	  System.out.println( "\npre-order traversal:" );
	  arbol.preOrderTrav(); // 4 2 1 3 5 6

	  System.out.println( "\nin-order traversal:" );
	  arbol.inOrderTrav(); // 2 1 3 4 5 6
	
	  System.out.println( "\npost-order traversal:" );
	  arbol.postOrderTrav(); // 2 1 3 5 6 4
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    }

}//end class
