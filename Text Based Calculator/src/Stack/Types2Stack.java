package Stack;

public class Types2Stack {
	private Types2Node top;
	private Types2Node bottom;
	
	public Types2Stack() {
		top = null;
		bottom = null;
	}
	
	public void push(String str){
		Types2Node temp = new Types2Node(str);
		if(top==null) {
			top=temp;
			bottom=temp;
		}
		else {
			temp.setRef(top);
			top.setBackRef(temp);
			top=temp;
		}
	}
	
	public void push(double value){
		Types2Node temp = new Types2Node(value);
		if(top==null) {
			top=temp;
			bottom=temp;
		}
		else {
			temp.setRef(top);
			top.setBackRef(temp);
			top=temp;
		}
	}
	
	public String pop() {
		String temp  = top.getStr();
		top = top.getRef();
		top.setBackRef(null);
		return temp;
	}
	
	public double pop2() {
		double temp  = top.getValue();
		top = top.getRef();
		top.setBackRef(null);
		return temp;
	}
	
	public String peek() {
		return top.getStr();
	}
	
	public double peek2() {
		return top.getValue();
	}
	
	public String dequeue() {
		String temp = bottom.getStr();
		bottom = bottom.getBackRef();
		//bottom.setRef(null);
		return temp;
	}
	
	public double dequeue2() {
		double temp = bottom.getValue();
		bottom = bottom.getBackRef();
		//bottom.setRef(null);
		return temp;
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
	
	public int getBackType() {
		if(bottom.getStr()==null) {
			return 1;
		}
		return 0;
	}
	
	public boolean nextBackTwoAreNums() {
		if(bottom.getStr()==null) {
			if(bottom.getRef().getStr()==null) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isEmpty() {
		if(top==null) {
			return true;
		}
		return false;
	}
}
