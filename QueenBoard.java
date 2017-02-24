//Dawei Huang
//APCS1 pd5
//HW08 --  [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
//02/24/17

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 * USAGE:
 * 1. Peruse. Replace "// ?" prompts with valid comments,
 * then provide general description in block comment preceding 
 * each method.
 * 2. Implement solver method.
 */
 
 import java.util.ArrayList;

public class QueenBoard
{
    //2D array to represent n*n chessboard
    private int[][] _board;
	private int[][] _boardSolution;
	private int size = 0;

    //constructor allows for specifying size
    public QueenBoard( int boardSize ) 
    {
	_board = new int[boardSize][boardSize];
	size = boardSize;
    }


    /***
     * precondition: board is filled with 0's only.
     * postcondition: 
     * If a solution is found, board shows position of N queens, 
     * returns true.
     * If no solution, board is filled with 0's, 
     * returns false.
     * ALGORITHM:
     * Generate all possible combinations of the numbers 0, 1, 2, 3, ..., n-1000,
	 where n is equal to the dimension of the QueenBoard. Test each combination to
	 see if they form a valid graph in which no queens can directly attack on another.
	 To test for validity, each queen is placed on the graph until all the queens are placed
	 or a wueen cannot be placed. If all the queens can be placed, then it is a valid graph. If
	 not, then the graph is invalid and thus not a possible solution.
     */
	 
    public boolean solve()
    {
		ArrayList<ArrayList<Integer>> possSolution = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> currCase = new ArrayList<Integer>();
		ArrayList<Integer> endCase = new ArrayList<Integer>();
		
		for(int i = 0; i < size; i++){
			currCase.add(0);
			endCase.add(size - 1);
		}
		
		while(compareArrList(currCase, endCase) == false){
			currCase.set(size - 1, currCase.get(size - 1) + 1);
			for(int a = size - 1; a >= 0; a--){
				if (currCase.get(a).equals(size)){
					currCase.set(a - 1, currCase.get(a - 1) + 1);
					for(int b = a; b < size; b++){
						currCase.set(b, 0);
					}
				}
			}
			if (repeat(currCase) == false){
				possSolution.add(clone(currCase));
			}
			// possSolution.add(clone(currCase));
		}
		boolean solution = false;
		for(int x = 0; x < possSolution.size(); x++){
			reset();
			ArrayList<Integer> currSol = possSolution.get(x);
			boolean conflict = false;
			for(int ab = 0; ab < size; ab++){
				if (addQueen(ab, currSol.get(ab)) == false){
					conflict = true;
					break;
				}
			}
			if (conflict == false){
				_boardSolution = _board;
				System.out.println(currSol);
				solution = true;
				break;
			}
		}
		if (solution == false){
			reset();
		}
		return true;
    }
	
	public static boolean compareArrList(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
		if(arr1.size() != arr2.size()){
			return false;
		}
		for(int i = 0; i < arr1.size(); i++){
			if(arr1.get(i) != arr2.get(i)){
				return false;
			}
		}
		return true;
	}

	public static ArrayList<Integer> clone(ArrayList<Integer> arr){
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for(int a: arr){
			arrList.add(a);
		}
		return arrList;
	}
    //print a valid placement of n queens
    public void printSolution()
    {
	/** Print board, a la toString...
	    Except:
	    all negs and 0's replaced with underscore
	    all 1's replaced with 'Q'
	*/
		String[][] solArray = new String[size][size];
		for(int i = 0; i < size; i++){
			for(int a = 0; a < size; a++){
				if (_board[i][a] <= 0){
					solArray[i][a] = "_";
				}
				if (_board[i][a] == 1){
					solArray[i][a] = "Q";
				}
			}
		}
		String ans = "Solution\n";
	for( int r = 0; r < solArray.length; r++ ) {
	    for( int c = 0; c < solArray[0].length; c++ ) {
		ans += solArray[r][c]+"\t";
	    }
	    ans += "\n";
	}
	System.out.println(ans);		
    }



    //================= YE OLDE SEPARATOR =================

    /***
     * Places the queen, denoted by 1, on the chess board. Negative integers
	 indicate the degree of intersection between the range of attacks of different
	 queens
     * precondition: the row and col parameters are ints and must be equal to or less
	 than the size of the board
     * postcondition: returns true if it is possible to place the queen and returns false
	 otherwise.
     */
    private boolean addQueen(int row, int col)
    {
	// returns false if Queen cannot be placed on territory
	// because it is already occupied by a queen or because
	// it is in another queen's range of attack
	if(_board[row][col] != 0){
	    return false;
	}

	// place the queen on the given row col coordinate
	_board[row][col] = 1;

	// radius distance of the queen's range of attack
	int offset = 1;

	// update columns north of the coordinate
	while(row-offset >= 0){
	    _board[row - offset][col]--;
		offset++;
	}
	
	offset = 1;
	
	// update columns south of the coordinate
	while(row+offset < _board.length){
	    _board[row + offset][col]--;
		offset++;
	}
	
	offset = 1;
	
	while(col-offset >= 0){
		// update columns west of coordinate
	    _board[row][col-offset]--;

	    // update columns north west of coordinate
	    if( row - offset >= 0 ) {
		_board[row-offset][col-offset]--;
	    }
		// update columns south west of coordinate
	    if( row + offset < _board.length ) {
		_board[row+offset][col-offset]--;
	    }
	    // increase radial offset by 1
	    offset++;
	}
	offset = 1;
	while(col+offset < _board[row].length) {
	    // update columns east of coordinate
	    _board[row][col+offset]--;

	    // update columns north east of coordinate
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]--;
	    }
		
		// update columns south west of coordinate
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]--;
	    }
	    // increase radial offset by 1
	    offset++;
	}
	return true;
    }


    /***
     * <General description>
     * precondition: 
     * postcondition: 
     */
    private boolean removeQueen(int row, int col)
    {
	// if there is no queen on the location to remove then the boolean false is returned
	if ( _board[row][col] != 1 ) {
	    return false;
	}
	_board[row][col] = 0;	// set the location where the queen was to 0 to indicate an empty position
	int offset = 1;	        // set the distance away from he queen to be equal to one

	// increase the coordinate within the offset range by one to indicate that it is no longer in the
	// attack range of a queen
	while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
		_board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
		_board[row+offset][col+offset]++;
	    }
	    offset++;
	}
	return true;
    }
	
	//see if a number repeats itself within an array. If it does, return true.
	// Return false otherwise
	private boolean repeat(ArrayList<Integer> arr){
		for(int c = 0; c < arr.size() - 1; c++){
			for(int a = c + 1; a < arr.size(); a++){
				if (arr.get(c) == arr.get(a)){
					return true;
				}
			}
		}
		return false;
	}
	
	//reset the board (remove all queens)
	private boolean reset(){
		for(int i = 0; i < _board.length; i++){
			for(int a = 0; a < _board.length; a++){
				_board[i][a] = 0;
			}
		}
		return true;
	}


    /***
     * <General description>
     * precondition: The board is a 2D array containing ints
     * postcondition: The contents of the board are printed out in the terminal
     */
    public String toString() 
    {
	String ans = "";
	for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
		ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
	}
	return ans;
    }


    //main method for testing...
    public static void main( String[] args )
    {
	double startTime = System.currentTimeMillis();
	QueenBoard b = new QueenBoard(5);
	b.solve();
	b.printSolution();
	double endTime = System.currentTimeMillis();
	System.out.println("\nThis solution was generated in " + (endTime - startTime) / 1000 + " seconds.");
	
	// b.addQueen(0,3);
	// b.addQueen(1,3);
	// b.addQueen(2,5);
	// b.addQueen(3,4);
	// b.addQueen(4,2);
	// b.addQueen(5,1);
	// System.out.println(b.toString());
	}//end main()
    
}//end class
