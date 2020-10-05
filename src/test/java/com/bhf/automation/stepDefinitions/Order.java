package com.bhf.automation.stepDefinitions;
import java.util.Scanner;

public class Order {


	public static void main(String []args){

		Scanner scn = new Scanner(System.in);

		String a = scn.nextLine();
		String b = scn.nextLine();

		if(a.compareTo(b) > 0)
		{
			System.out.println("Yes");
		}

		else {

			System.out.println("No");
		}
	}
}


