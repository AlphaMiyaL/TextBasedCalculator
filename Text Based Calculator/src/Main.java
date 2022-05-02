import java.util.Scanner;

import AutomataIntepretations.InterpretNumberFSM;

public class Main {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String input;
		boolean exit = false;
		
		while(!exit) {
			System.out.print("Input numbers and expressions(Accordance to the java literal document)[exit to stop program]: ");
			input = keyboard.nextLine();
			if(input.toLowerCase().equals("exit")) {
				exit = !exit;
				System.out.println("Exiting Program...");
			}
			else {			
				double interpret = InterpretExpression.interpret(input);
				if(interpret!=-1) {
					System.out.println(interpret);
				}
			}
			System.out.println();
		}
		
		keyboard.close();
	}
}
