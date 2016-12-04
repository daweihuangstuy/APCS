//Dawei Huang
//Due: 10/20/16
//Period 4 APCS w/ Mr. Brown Mykolyk
//HW#20 -- GCD Three Ways


public class Stats{
	
	//Version 1 Code -----------------------------------------
	//returns the mean of two integers
    public static int mean(int a, int b){
		return ((a + b) / 2);
    }
	
	//returns the mean of two doubles
    public static double mean(double a, double b){
		return ((a + b) / 2);
    }
	
	//returns the max of two integers
    public static int max(int a, int b){
		if (a >= b){
			return a;
		}  
		else {
			return b;
		}
    }
	
	//returns the max of two doubles
    public static double max(double a, double b){
		if (a >= b){
			return a;
		}  
		else {
			return b;
		}
    }
	
	//returns the geometric mean of two integers
    public static int geoMean(int a, int b){
		return((int)Math.sqrt(a * b));
    }
	
	//returns the geometric mean of two doubles
    public static double geoMean(double a, double b){
		return((int)Math.sqrt(a * b));
    }
	
	
	//Version 1 + 2 Code -----------------------------------------
	//returns the maximum of three integers
	public static int max(int a, int b, int c){
		if (a >= b && a >= c){
			return a;
		}
		if (b >= a && b >= c){
			return b;
		}
		if (c >= a && c >= b){
			return c;
		}
		else {
			System.out.println("Something is wrong, please check your parameter values");
			return a;
		}
	}
	
	//returns the maximum of three doubles
	public static double max(double a, double b, double c){
		if (a >= b && a >= c){
			return a;
		}
		if (b >= a && b >= c){
			return b;
		}
		if (c >= a && c >= b){
			return c;
		}
		else {
			System.out.println("Something is wrong, please check your parameter values");
			return a;
		}
	}
	
	//returns the geometric mean of three integers
	public static int geoMean(int a, int b, int c){
		return((int)Math.cbrt(a * b * c));
	}
	
	//returns the geometric mean of three doubles
	public static double geoMean(double a, double b, double c){
		return(Math.cbrt(a * b * c));
	}
	
	//----------------------------METHODS FOR FINDING GCD(Greatest Common Divisor)----------------------------------
	
	//Brute force method for finding the GCD of two numbers
    public static int gcd (int a, int b) {
	int increment = 1;
	int currentGCD = 1;
	while (increment <= a || increment <= b) {
	    if (a % increment == 0 && b % increment == 0) {
			currentGCD = increment;
			increment += 1;
		    }
		else{
		    increment += 1;
			}
	    }
	return currentGCD;
    }
	
	/* 
	Methods gcdER and gcdWR are recursive and iterative methods respectively for finding the
	GCD(Greatest Common Divisor) of two positive integes using Euclid's Algorithm. Although
	performing	Euclid's Algorithm is very labor-intensive when given large values, it is much
	more efficient than the brute force method given above. If one of the two numbers is equal
	to 0 or not not a positive integer, this algorithm would not work.	When two valid numbers 
	are given for Euclid's Algorithm to be performed, if the bigger number is divisible by the
	smaller number, than the smaller number is the GCD. If it is not divisible then you would 
	set the larger number as the positive difference between the two numbers. You would repeat 
	the previous step until one of the two numbers is equal to 0. If that is the case, the 
	non-zero number would represent the GCD.
	*/
	
	//Recursive method using Euclid's Algorithm for finding the GCD of two numbers
	public static int gcdER (int a, int b){
		if (a * b == 0){
			if (a == 0){
				return b;
			}
			if (b == 0){
				return a;
			}
		}
		else if (a % b == 0){
			return b;
		}
		else if(b % a == 0){
			return a;
		}
		else if (a > b){
			return gcdER(b, a - b);
		}
		return gcdER(a, b - a);
	}
	
	//Iterative method using Euclid's Algorithm for finding the GCD of two numbers
    public static int gcdEW (int a, int b){
		if (a % b == 0){
			return b;
		}
		if (b % a == 0){
			return a;
		}
		while (a != 0 && b !=0){
			if (a > b){
				a -= b;
			}
			else {
				b -= a;
			}
		}
		if (a == 0){
			return b;
		}
		else {
			return a;
		}
	}
}

//--------------------------------------------------------------

class Driver{
	public static void main(String[] args){
		
		//Version 1 Test
		System.out.println("\nVersion 1 Test");
		System.out.println(Stats.mean(3, 10)); //6
		System.out.println(Stats.mean(3.1232, 4.123123)); //3.6231615
		System.out.println(Stats.max(1232, 121234)); //121234
		System.out.println(Stats.max(13212.1232, 13212.12321)); //13212.12321
		System.out.println(Stats.geoMean(4, 11)); //6
		System.out.println(Stats.geoMean(124.1232, 11)); //36.950713118964295
		
		//Version 1 + 2 Test
		System.out.println("\nVersion 1 + 2 Test");
		System.out.println(Stats.max(21, 11, 21)); //21
		System.out.println(Stats.max(12.1232, 11.12, 13.1212)); //13.1212
		System.out.println(Stats.geoMean(212, 123, 213)); //177
		System.out.println(Stats.geoMean(124.1232, 11.2123, 123.3243)); //55.57320499787241
		
		//Test of brute force method for finding the GCD of two numbers
		System.out.println("\nTest of brute force method for finding the GCD of two numbers");
		System.out.println(Stats.gcd (1, 200)); //1
		System.out.println(Stats.gcd (8, 2)); //2
	    System.out.println(Stats.gcd (10, 15)); //5
	    System.out.println(Stats.gcd (36, 30)); //6
		System.out.println(Stats.gcd (3150, 673200)); //450
		
		//Test of the recursive method using Euclid's Algorithm for finding the GCD of two numbers
		System.out.println("\nTest of the recursive method using Euclid's Algorithm for finding the GCD of two numbers");
		System.out.println(Stats.gcdER (1, 200)); //1
		System.out.println(Stats.gcdER (8, 2)); //2
	    System.out.println(Stats.gcdER (10, 15)); //5
	    System.out.println(Stats.gcdER (36, 30)); //6
		System.out.println(Stats.gcdER (3150, 673200)); //450
		
		//Test of the iterative method using Euclid's Algorithm for finding the GCD of two numbers
		System.out.println("\nTest of the iterative method using Euclid's Algorithm for finding the GCD of two numbers");
		System.out.println(Stats.gcdEW (1, 200)); //1
		System.out.println(Stats.gcdEW (8, 2)); //2
	    System.out.println(Stats.gcdEW (10, 15)); //5
	    System.out.println(Stats.gcdEW (36, 30)); //6
		System.out.println(Stats.gcdEW (3150, 673200)); //450
	}
}