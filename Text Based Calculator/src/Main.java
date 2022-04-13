import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		String input;
		boolean exit = false;
		
		while(!exit) {
			System.out.print("Input number(Accordance to the java literal document)[exit to stop program]: ");
			input = keyboard.nextLine();
			if(input.equals("exit")) {
				exit = !exit;
				System.out.println("Exiting Program...");
			}
			else {			
				InterpretNumberFSM interpreter = new InterpretNumberFSM(input);
				interpreter.InterpretState();
			}
			System.out.println();
		}
		
		keyboard.close();
	}
}
