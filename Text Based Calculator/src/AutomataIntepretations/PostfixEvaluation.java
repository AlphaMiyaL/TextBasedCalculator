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
	
	public double postfixEval() {
		while(true) {
			switch(current) {
				case Q0:
					//Adding starting $ for end of stack
					calcs.push("$");
					postfix.dequeue();
					postfix.push("$");
					current = PEState.Q1;
					break;
				case Q1:
					// If string, then it is an operator or end of stack $
					if(postfix.getBackType()==0) {
						String popped = postfix.dequeue();
						double val1;
						double val2;
						try{
							switch(popped.charAt(0)) {
								case '*':
									val1=calcs.pop2();																	
									val2=calcs.pop2();
									calcs.push(val1*val2);
									break;
								case '/':
									val1=calcs.pop2();																	
									val2=calcs.pop2();
									calcs.push(val2/val1);
									break;
								case '+':
									val1=calcs.pop2();																	
									val2=calcs.pop2();
									calcs.push(val1+val2);
									break;
								case '-':
									val1=calcs.pop2();																	
									val2=calcs.pop2();
									calcs.push(val2-val1);
									break;
								case '$':
									current = PEState.Q2;
									break;
							}	
						}
						catch(Exception e) {
							System.out.println("Error: Not enough numbers");
							current = PEState.QDead;
						}
					}
					// If number, then push to calc stack
					else {
						calcs.push(postfix.dequeue2());
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
