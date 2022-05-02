package Stack;

public class Types2Stack {
	private Types2Node top;
	
	public Types2Stack() {
		top = null;
	}
	
	public void push(String str){
		Types2Node temp = new Types2Node(str);
		if(top!=null) {
			temp.setRef(top);
		}
		top = temp;
	}
	
	public void push(double value){
		Types2Node temp = new Types2Node(value);
		if(top!=null) {
			temp.setRef(top);
		}
		top = temp;
	}
	
	public String pop() {
		String temp  = top.getStr();
		top = top.getRef();
		return temp;
	}
	
	public double pop2() {
		double temp  = top.getValue();
		top = top.getRef();
		return temp;
	}
	
	public String peek() {
		return top.getStr();
	}
	
	public double peek2() {
		return top.getValue();
	}
	
	public int getType() {
		if(top.getStr()==null) {
			return 1;
		}
		return 0;
	}
	
	public boolean nextTwoAreNums() {
		if(top.getStr()==null) {
			if(top.getRef().getStr()==null) {
				return true;
			}
		}
		return false;
	}
}
