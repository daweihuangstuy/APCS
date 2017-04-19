import java.utils.PriorityQueue

public class ArrayPriorityQueue implements PriorityQueue{
    private ArrayList<Integer> _data = new ArrayList<Integer>();
    public void add(int num){
	_data.add(num);
    }
    public boolean isEmpty(){
	return (_data.size() == 0);
    }
    public int peekMin(){
	int minVal = _data.get(0);
	for(int x : _data){
	    if (x < minVal){
		minVal = x;
	    }
	}
    }
    public int removeMin(){
	int minVal 
    }

}
