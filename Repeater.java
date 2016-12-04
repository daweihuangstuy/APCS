//Dawei Huang
//Due: 10/17/16
//Period 4 APCS w/ Mr. Brown Mykolyk
//HW#17 -- Do I repeat myself? Very well, then I repeat myself  I am possibly unending, I contain potentially multitudes


public class Repeater{
    
	//Repeater with a while loop
	public static String fenceBuilderW(int posts) {
		String fenceW = "|";
		if (posts == 0){
			return("");
		}
		else if (posts < 1){
			return("The fence that you want to build is impossible. Try again");
		}
		while (posts > 1){
			posts -= 1;
			fenceW += "--|";
			}
		return(fenceW);
	}
	
	//Repeater using recursion
	public static String fenceBuilderR(int posts){
		if (posts < 0){
			return("The fence that you want to build is impossible. Try again");
		}
		if (posts == 0){
			return "";
		}
		if (posts == 1){
			return "|--|";
		}
		return "|--" + fenceBuilderR(posts - 1);
	}
}

class RepeaterDriver{
    public static void main(String[] args){
	//test cases for fenceBuilderW
	System.out.println("\ntest cases for fenceBuilderW\n");
	System.out.println(Repeater.fenceBuilderW(-1));
	System.out.println(Repeater.fenceBuilderW(0));
	System.out.println(Repeater.fenceBuilderW(1));
	System.out.println(Repeater.fenceBuilderW(2));
	System.out.println(Repeater.fenceBuilderW(3));
	System.out.println(Repeater.fenceBuilderW(10));
	
	//test cases for fenceBuilderR
	System.out.println("\ntest cases for fenceBuilderR\n");
	System.out.println(Repeater.fenceBuilderR(-1));
	System.out.println(Repeater.fenceBuilderR(0));
	System.out.println(Repeater.fenceBuilderR(1));
	System.out.println(Repeater.fenceBuilderR(2));
	System.out.println(Repeater.fenceBuilderR(3));
	System.out.println(Repeater.fenceBuilderR(10));
	    }
}
