package AutomataIntepretations;
import States.State;

public class InterpretNumberFSM {
	private State current;
	private String str;
	
	public InterpretNumberFSM(String str){
		current = State.Q0;
		this.str = str;
	}
	
	public double InterpretState() {
		double result=0;
		double decimal=0;
		double e=0;
		boolean negative=false;
		int event;
		for(int i=0; i<str.length(); i++) {
			switch(current) {
				case Q0:
					event = Q0Run(str.charAt(i));
					if(event>=0) {
						result=event;
					}
					break;
				case Q1:
					event = Q1Run(str.charAt(i));
					if(event>=0) {
						result=result*10+event;
					}
					break;
				case Q2:
					event = Q2Run(str.charAt(i));
					if(event>=0) {
						decimal=decimal*10+event;
					}
					break;
				case Q3:
					event = Q3Run(str.charAt(i));
					if(event>=0) {
						decimal=decimal*10+event;
					}
					break;
				case Q4:
					event = Q4Run(str.charAt(i));
					break;
				case Q5:
					event = Q5Run(str.charAt(i));
					if(event>=0) {
						e = event;
					}
					break;
				case Q6:
					event = Q6Run(str.charAt(i));
					if(event>=0) {
						negative=!negative;
						e = event;
					}
					break;
				case Q7:
					event = Q7Run(str.charAt(i));
					if(event>=0) {
						e = event;
					}
					break;
				case Q8:
					event = Q8Run(str.charAt(i));
					if(event>=0) {
						e = e*10+event;
					}
					break;
				case QDead:
					System.out.println("Not a valid input.");
					return -1;
			}
		}
		//Validating if in dead state
		if(current == State.QDead) {
			System.out.println("Not a valid input.");
			return -1;	
		}
		//Combining result with it's decimal
		while(decimal>1) {
			decimal /= 10;
		}
		result+=decimal;
		//Combining result with it's exponentPart
		if(negative) {
			result = result*Math.pow(10, -e);	
		}
		else {
			result = result*Math.pow(10, e);
		}
		System.out.print(result);
		return result;
	}
	
	
	//Each case in these methods are an event to the same or another state (ie: q0 -> q1)
	private int Q0Run(char a){
		switch(a) {
			case '0': case '1': case '2': case '3': case '4': case '5':case '6':case '7':case '8':case '9':
				current = State.Q1;
				return ((int)a-48);
			case '_':
				return -1;
			default:
				current = State.QDead;
				return -1;
		}
	}
	
	private int Q1Run(char a){
		switch(a) {
			case '0': case '1': case '2': case '3': case '4': case '5':case '6':case '7':case '8':case '9':
				return ((int)a-48);
			case '_':
				return -1;
			case '.':
				current = State.Q2;
				return -2;
			case 'E': case 'e': 
				current = State.Q5;
				return -3;
			case 'f': case 'F': case 'd': case 'D':
				current = State.Q4;
				return -4;
			default:
				current = State.QDead;
				return -1;
		}
	}
	
	private int Q2Run(char a){
		switch(a) {
			case '0': case '1': case '2': case '3': case '4': case '5':case '6':case '7':case '8':case '9':
				current = State.Q3;
				return ((int)a-48);
			case '_':
				return -1;
			default:
				current = State.QDead;
				return -1;
		}
	}
	
	private int Q3Run(char a){
		switch(a) {
			case '0': case '1': case '2': case '3': case '4': case '5':case '6':case '7':case '8':case '9':
				return ((int)a-48);
			case '_':
				return -1;
			case 'e': case 'E':
				current = State.Q5;
				return -3;
			case 'f': case 'F': case 'd': case 'D':
				current = State.Q4;
				return -4;
			default:
				current = State.QDead;
				return -1;
		}
	}
	
	private int Q4Run(char a){
		switch(a) {
			default:
				current = State.QDead;
				return -1;
		}
	}
	
	private int Q5Run(char a){
		switch(a) {
			case '0': case '1': case '2': case '3': case '4': case '5':case '6':case '7':case '8':case '9':
				current = State.Q8;
				return ((int)a-48);
			case '-':
				current = State.Q6;
				return -1;
			case '+':
				current = State.Q7;
				return -1;
			default:
				current = State.QDead;
				return -1;
		}
	}
	
	private int Q6Run(char a){
		switch(a) {
			case '0': case '1': case '2': case '3': case '4': case '5':case '6':case '7':case '8':case '9':
				current = State.Q8;
				return ((int)a-48);
			default:
				current = State.QDead;
				return -1;
		}
	}
	
	
	private int Q7Run(char a){
		switch(a) {
			case '0': case '1': case '2': case '3': case '4': case '5':case '6':case '7':case '8':case '9':
				current = State.Q8;
				return ((int)a-48);
			default:
				current = State.QDead;
				return -1;
		}
	}
	
	
	private int Q8Run(char a){
		switch(a) {
			case '0': case '1': case '2': case '3': case '4': case '5':case '6':case '7':case '8':case '9':
				return ((int)a-48);
			case '_':
				return -1;
			case 'f': case 'F': case 'd': case 'D':
				current = State.Q4;
				return -4;
			default:
				current = State.QDead;
				return -1;
		}
	}
}
