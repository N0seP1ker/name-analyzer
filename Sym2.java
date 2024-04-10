import java.util.LinkedList;

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

class FnSym extends Sym {
	private LinkedList<String> paramType;
	private String retType;
	
	public FnSym (String ret, LinkedList<String> param) {
		super("function");
		paramType = param;
		retType = ret;
	}

	public String toString() {
		String param = String.join (", ", paramType);
		if (param.equals("")) {
			param = "void";
		}
		return param + " -> " + retType;
	}
}

class TupleDefSym extends Sym {
	
	private SymTable symTable;
	private String name;
		
	public TupleDefSym (String name, SymTable symTable) {
		super("tuple");
		this.symTable = symTable;
	}

	// get type will return "tuple"

	// toString will return "tuple"

	public SymTable getSymTable() {
		return symTable;
	}
}

class TupleSym extends Sym {
	private String name;

	public TupleSym (String name) {
		super("tupleInstance");
		this.name = name;
	}

	// we want toString() to return the name of the tuple type
	public String toString() {
		return name;
	}
}
