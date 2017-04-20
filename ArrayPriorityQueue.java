// Dawei Huang
// APCS2 pd5
// HW32 -- Getting Past the Velvet Rope
// 2017-04-2

import java.util.ArrayList;

public class ArrayPriorityQueue implements PriorityQueue {
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
		return minVal;
    }
    public int removeMin(){
		int minVal = peekMin();
		for(int i = 0; i < _data.size(); i++){
			if(minVal == _data.get(i)){
				_data.remove(i);
				break;
			}
		}
		return minVal;
    }
	public String toString(){
		return _data.toString();
	}
	
	public static void main(String[] args){
		ArrayPriorityQueue bob = new ArrayPriorityQueue();
		for(int i = 0; i < 10; i++){
			bob.add((int)(Math.random() * 100));
		}
		System.out.println(bob);
		while(bob.isEmpty() == false){
			System.out.println(bob.peekMin());
			System.out.println(bob.removeMin());
			System.out.println(bob);
		}
	}

}
