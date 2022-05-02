package AutomataIntepretations;

import Stack.Types2Stack;
import States.IPState;

public class InflixToPostfix {
	private IPState current;
	private String str;
	private Types2Stack postfix;
	private Types2Stack opstack;
	
	public InflixToPostfix(String str) {
		current = IPState.Q0;
		this.str = str;
		postfix = new Types2Stack();
		opstack = new Types2Stack();
	}
	
	public Types2Stack PostfixConversion() {
		//setup string
		str = "(" + str + ")";
		for(int i=0; i<str.length(); i++) {
			switch(current) {
				case Q0:
					//Adding starting $ for end of stack
					postfix.push("$");
					opstack.push("$");
					current = IPState.Q1;
					break;
				case Q1:
					switch(str.charAt(i)) {
						//Inteprets number from string using InterpretNumberFSM
						case '0': case '1': case '2': case '3': case '4': case '5':case '6':case '7':case '8':case '9':
							for(int j=i+1; j<str.length()-i-1; j++) {
								switch(str.charAt(j)) {
									case '(': case '*': case '/': case ')':
										InterpretNumberFSM infsm = new InterpretNumberFSM(str.substring(i, j));
										double num = infsm.InterpretState();
										if(num==-1) {
											current = IPState.QDead;
										}
										else {
											postfix.push(num);
										}
										break;
									case '+': case '-':
										if(str.charAt(j-1)!='e' && str.charAt(j-1)!='E') {
											InterpretNumberFSM infsm2 = new InterpretNumberFSM(str.substring(i, j));
											double num2 = infsm2.InterpretState();
											if(num2==-1) {
												current = IPState.QDead;
											}
											else {
												postfix.push(num2);
											}
										}
										break;
								}
							}
							break;
						//If operator, pushes onto opstack
						case '(': case '+': case '-': case '*': case '/':
							opstack.push(str.charAt(i));
							break;
						//If closing parens, pop opstack until opening opstack is found
						case ')':
							String temp = opstack.pop();
							while(!temp.equals("(")) {
								postfix.push(temp);
								temp = opstack.pop();
								//if stack end $ is reached, error out
								System.out.println("Error: Opening parens does not match amount of closing parens");
							}
							break;
					}
					break;
				case QDead:
					return null;
			}
		}
		if(current == IPState.QDead) {
			return null;
		}
		return postfix;
	}
}
