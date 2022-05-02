import AutomataIntepretations.InflixToPostfix;
import AutomataIntepretations.PostfixEvaluation;
import Stack.Types2Stack;

public class InterpretExpression {
	public static double interpret(String str) {
		InflixToPostfix itp = new InflixToPostfix(str);
		Types2Stack stac = itp.postfixConversion();
		if(stac == null) {
			return -1;
		}
		PostfixEvaluation pEval = new PostfixEvaluation(stac);
		double result = pEval.postfixEval();
		if(result == -999) {
			return -1;
		}
		return result;
	}
}
