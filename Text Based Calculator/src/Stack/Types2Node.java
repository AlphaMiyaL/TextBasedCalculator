package Stack;

public class Types2Node {
	private String str;
	private double value;
	private Types2Node ref;
	
	public Types2Node(String str) {
		this.str=str;
	}
	
	public Types2Node(double value) {
		this.value=value;
	}
	
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setRef(Types2Node ref) {
		this.ref = ref;
	}

	public Types2Node getRef() {
		return ref;
	}
}
