package AutomataIntepretations;
import Stack.Types2Stack;
import States.PEState;

public class PostfixEvaluation {
	private PEState current;
	private Types2Stack postfix;
	private Types2Stack calcs;
	
	public PostfixEvaluation(Types2Stack postfix) {
		current = PEState.Q0;
		this.postfix = postfix;
		calcs = new Types2Stack();
	}
	
	public double EvaluationState() {
		while(true) {
			switch(current) {
				case Q0:
					//Adding starting $ for end of stack
					calcs.push("$");
					current = PEState.Q1;
					break;
				case Q1:
					// If string, then it is an operator or end of stack $
					if(postfix.getType()==0) {
						String popped = postfix.pop();
						double val1;
						double val2;
						// Check if at least 2 nums exist in calcs stack
						if(!calcs.nextTwoAreNums()) {
							current = PEState.QDead;
							break;
						}
						//pops two values from calcs stack and calculates before pushing back onto calc stack 
						switch(popped.charAt(0)) {
							case '*':
								val1=calcs.pop2();																	
								val2=calcs.pop2();
								calcs.push(val1*val2);
								break;
							case '/':
								val1=calcs.pop2();																	
								val2=calcs.pop2();
								calcs.push(val1/val2);
								break;
							case '+':
								val1=calcs.pop2();																	
								val2=calcs.pop2();
								calcs.push(val1+val2);
								break;
							case '-':
								val1=calcs.pop2();																	
								val2=calcs.pop2();
								calcs.push(val1-val2);
								break;
							case '$':
								current = PEState.Q2;
								break;
						}
					}
					// If number, then push to calc stack
					else {
						calcs.push(postfix.pop2());
					}
					break;
				case Q2:
					return calcs.pop2();
				case QDead:
					return -999;
			}
		}
	}
}
