package dijkstrasAlgo;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws Exception {
		String function;
		System.out.println("*NOTE* \nPlease make sure that each expression is entered within \nparentheses and that the parentheses are perfectly balanced.");
		System.out.println("Enter a function: ");
		Scanner reader = new Scanner(System.in);
		function = reader.nextLine();
		DijkstraTwoStackAlgo al = new DijkstraTwoStackAlgo(function);
		System.out.println(al.run());
	}

}
