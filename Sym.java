public class Sym {
	private String type;
	
	public Sym(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}

	public String toString() {
		return type;
	}
}

public class FnSym extends Sym {
	private LinkedList<String> paramType;
	private String retType;
	
	public FnSym (String ret, LinkedList<String> param) {
		super("function");
		paramType = param;
		retType = ret;
	}

	public String toString() {
		String param = String.join (", ", paramType);
		if (params.equals("")) {
			param = "void";
		}
		return param + " -> " + retType;
	}
}
