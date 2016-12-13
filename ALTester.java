import java.util.ArrayList

public class ALTester {
    public Object arr;
    public boolean testSorted(Object arr){
	Object test;
	test = arr[0];
	for(int i = 1; i < arr.length; i++){
	    if (arr[i] != (test + 1)){
		return false;
		test = arr[i];
	    } 
	}
	return true;
    }
}
