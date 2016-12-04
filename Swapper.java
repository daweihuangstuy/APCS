//Dawei Huang
//Due: 12/05/2016
//Period 4 APCS w/ Mr. Brown Mykolyk
//HW #39 -- Put it together

import cs1.Keyboard;
import java.io.*;
import java.util.*;

public class Swapper{
	static String[] arr = new String[10];
	static int location1 = 0;
	static int location2 = 0;
	public static void main(String[] args){
		System.out.println("Welcome the game Swapper");
		System.out.println("Instructions: Enter the number into specified location between 0 and 9");
		System.out.println("The items in the specified locations will be swapped");
		popStrArray();
		System.out.println("\nHere is your randomly generated array: ");
		arrPrint();
		
		//location 1
		System.out.println("\n\nEnter Location1:");
		try {
			location1 = Integer.parseInt(cs1.Keyboard.readWord());
		}
		catch (Exception e) {
			System.out.println("You had entered an invalid location so the program has been terminated. Please try again.");
			System.exit(0);
		}
		if (location1 > 9 || location1 < 0){
			System.out.println("You had entered an invalid location so the program has been terminated. Please try again.");
			System.exit(0);
		}
		
		//location 2
		System.out.println("\n\nEnter Location2:");
		try {
			location2 = Integer.parseInt( cs1.Keyboard.readWord() );
		}
		catch (Exception e) {
			System.out.println("You had entered an invalid location so the program has been terminated. Please try again.");
			System.exit(0);
		}
		if (location2 > 9 || location2 < 0){
			System.out.println("You had entered an invalid location so the program has been terminated. Please try again.");
			System.exit(0);
		}
		
		posSwap(location1, location2);
		System.out.println("\nHere is your new string array:");
		arrPrint();
	}
		
	public static void popStrArray(){
		for (int i = 0; i < arr.length; i += 1){
			arr[i] = randomStrGen();
		}
	}
	
	public static String randomStrGen(){
		String strLine = "";
		int repetitions = (int)(Math.random() * 2) + 3;
		while (repetitions > 0){
			strLine += ((char)((Math.random() * 26) + 65));
			repetitions -= 1;
		}
		return strLine;
	}
	
	public static void posSwap(int a, int b){
		String location1Data = arr[a];
		String location2Data = arr[b];
		arr[a] = location2Data;
		arr[b] = location1Data;
	}
	
	public static void arrPrint(){
		String printStr = "";
		for(String x : arr){
			printStr += x + "\t";
		}
		System.out.print(printStr);
	}
}