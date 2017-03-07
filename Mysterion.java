//Dawei Huang
//APCS2 pd5
//HW13 --  We Be Dem SV
//2017-03-07

public class Mysterion{
	public static void main( String[] args ){
		int[] arrTest = new int[6];
		//test 1
		arrTest[0] = 3;
		arrTest[1] = 0;
		arrTest[2] = 16;
		arrTest[3] = 599;
		arrTest[4] = 1024;
		System.out.println(kindSort(arrTest, 0, 4, 2));
		
		//test 2
		arrTest[0] = 4;
		arrTest[1] = 6;
		arrTest[2] = 8;
		arrTest[3] = 969;
		arrTest[4] = 10344;
		System.out.println(kindSort(arrTest, 0, 4, 2));
		
		//test 3
		arrTest[0] = 123;
		arrTest[1] = 612;
		arrTest[2] = 851;
		arrTest[3] = 91239;
		arrTest[4] = 1042;
		System.out.println(kindSort(arrTest, 0, 4, 2));
	}
	
	/*
	I believe that this algorithm is a kind of sort algorithm where the s you return represents the
	amount of steps the function has to perform
	Parameters:
	arr: an array of any size
	lowBound: the low index bound of the array
	highBound: the high index bound of the array
	median: the center inde of the array
	*/
	
	public static int kindSort(int[] arr, int lowBound, int upBound, int median){
		int v = arr[median];
		int cStor = arr[median];
		int bStor = arr[upBound];
		arr[median] = bStor;
		arr[upBound] = cStor;
		int s = lowBound;
		for(int i = lowBound; i <= upBound - 1; i++){
			if(arr[i] < v){
				int sStor = arr[s];
				int iStor = arr[i];
				arr[s] = iStor;
				arr[i] = sStor;
				s += 1;
			}
		}
		int sStor = arr[s];
		arr[upBound] = sStor;
		arr[s] = bStor;
		return s;
	}
}