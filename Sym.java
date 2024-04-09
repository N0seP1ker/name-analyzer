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

public class TupleDefSym extends Sym {
	
	private SymTable symTable;
	private String name;
		
	public TupleDefSym (String name, SymTable symTable) {
		super("tuple");
		this.symTable = symTable;
		this.name = name;
	}

	// get type will return "tuple"

	public String toString() {
		return name;
	}

	public getSymTable() {
		return symTable;
	}
}

public class TupleSym extends Sym {
	private String name;

	public TupleSym (String name) {
		super("tupleInstance");
		this.name = name;
	}

	public toString() {
		return name;
	}
}
