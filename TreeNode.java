// Dawei Huang
// APCS2 pd5
// HW34 -- Algorithm as Data Structure
// 2017-05-04

/*****************************************************
 * class TreeNode
 * Implements a node for use in a binary tree.
 * Only holds int cargo.
 *****************************************************/

public class TreeNode 
{
    //instance variables / attributes of a TreeNode:
    private int treeVal;
    private TreeNode leftChild;
    private TreeNode rightChild;

    /*****************************************************
     * default constructor
     * Construct a tree node with specified value, 
     * with null left and right subtrees.
     *****************************************************/
    TreeNode( int initValue )
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	treeVal = initValue;
	leftChild = null;
	rightChild = null;
    }
          

    /*****************************************************
     * overloaded constructor
     * Construct a tree node with specified
     * value, left, and right subtrees.
     *****************************************************/
    TreeNode( int initValue, TreeNode initLeft, TreeNode initRight ) 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	treeVal = initValue;
	leftChild = initLeft;
	rightChild = initRight;
    }
 

    /*****************************************************
     * Returns the left subtree of this node.
     *****************************************************/
    TreeNode getLeft() 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
 	return leftChild;
    }


    /*****************************************************
     * Returns the right subtree of this node.
     *****************************************************/
    TreeNode getRight() 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	return rightChild;
    }


    /*****************************************************
     * Returns the value stored in this tree node.
     *****************************************************/
    int getValue() 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	return treeVal;
    }


    /*****************************************************
     * Sets the value of the left subtree of this node.
     *****************************************************/
    void setLeft( TreeNode theNewLeft ) 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	leftChild = theNewLeft;
    }


    /*****************************************************
     * Sets the value of the right subtree of this node.
     *****************************************************/
    void setRight( TreeNode theNewRight ) 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	rightChild = theNewRight;
    }


    /*****************************************************
     * Sets the value of this tree node.
     *****************************************************/
    void setValue( int theNewValue ) 
    {
	/*** YOUR IMPLEMENTATION HERE ***/
	treeVal = theNewValue;
    }
 
}//end class
