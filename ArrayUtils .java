public class ArrayUtils{
	//assignment of random integer between 0 and 9 inclusive to each index in an array 
    public static void genObjArr(Object[] Arr){
		for (int i = 0; i < Arr.length; i++){
			Arr[i] = (int)(Math.random() * 10);
		}
	}

    //returns string representation of an object Array
    public static String stringRep(Object[] Arr){
		String newString = "";
		for (int i = 0; i < Arr.length; i++){
			newString += Arr[i];
		}
	return newString;
    }   
    
	//main method to test the object Array
	public static void main(String[] args){
	Object[] objArray = new Object[5];
	genObjArr(objArray);
	System.out.println(stringRep(objArray));
	objArray[0] = Integer(int 5);
	System.out.println(stringRep(objArray));
    }
}