import java.util.ArrayList;

public class ALTester {
    public static void main(String[] args){
	
    }
    public boolean testSorted(Object[] arr){
	Object test;
	test = arr[0];
	for(int i = 1; i < arr.length; i++){
	    if (arr[i] != ((int)test + 1)){
		return false;
	    } 
	    test = arr[i];
	}
	return true;
    }
}
