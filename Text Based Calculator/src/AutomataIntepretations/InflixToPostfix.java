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
		for(int i=0; i<str.length(); i++) {
			switch(current) {
				case Q0:
					break;
				case Q1:
					break;
				case Q2:
					break;
				case Q3:
					break;
				case Q4:
					break;
				case QDead:
					break;
			}
		}
		return postfix;
	}
}
