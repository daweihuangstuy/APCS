// Dawei Huang
// APCS2 pd5
// HW35 -- BSTs is the Perfect Place for Shade that’s just how I feel:: May the Fourth Be With You
// 2017-05-05

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
		if(root == null){
			root = new TreeNode(newVal);
		}
		insert(root, newVal);
    }
	
	public void insert( TreeNode root, int newVal){
		if(root == null){
			return;
		}
		if(newVal < root.getValue()){
			if(root.getLeft() == null){
				root.setLeft(new TreeNode(newVal));
			}
			else{
				insert(root.getLeft(), newVal);
			}
		}
		if(newVal > root.getValue()){
			if(root.getRight() == null){
				root.setRight(new TreeNode(newVal));
			}
			else{
				insert(root.getRight(), newVal);
			}
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

	 /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    {
    	/*** YOUR IMPLEMENTATION HERE ***/
		return searchRec(root, target);
    }
	
	TreeNode searchRec(TreeNode root, int target){
		if(root == null){
			return null;
		}
		else if(target < root.getValue()){
			searchRec(root.getLeft(), target);
			System.out.println(1);
		}
		else if(target > root.getValue()){
			searchRec(root.getRight(), target);
		}
		else if(target == root.getValue()){
			return root;
		}
		return null;
	}

    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 1
     *****************************************************/
    public int height()
    {
    	/*** YOUR IMPLEMENTATION HERE ***/
		ArrayList<TreeNode> level = new ArrayList<TreeNode>();
		ArrayList.add(root);
    }


    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    {
    	/*** YOUR IMPLEMENTATION HERE ***/
		if(root == null){
			return 1;
		}
		return numLeavesRec(root) + 1;
    }
	
	public int numLeavesRec(TreeNode root){
		if(root.getRight() == null && root.getLeft() == null){
			return 0;
		}
		if(root.getRight() != null){
			return 1 + numLeavesRec(root.getRight());
		}
		if(root.getLeft() != null){
			return 1 + numLeavesRec(root.getLeft());
		}
		return 0;		
	}
	
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
	  
	  System.out.println( "\nsearch algorithm traversal:" );
	  System.out.println(arbol.search(2)); // 2 1 3 5 6 4
	  
	  System.out.println( "\nleaf num algorithm traversal:" );
	  System.out.println(arbol.numLeaves()); // 3
	  
	  System.out.println( "\nheight algorithm traversal:" );
	  System.out.println("tbd"); // 3
	// ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    }

}//end class
