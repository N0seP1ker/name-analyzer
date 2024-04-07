###
# This Makefile can be used to make a parser for the base language
# (parser.class) and to make a program (P4.class) that tests the 
# parser and the unparse and name-analysis methods in ast.java.
#
# make clean removes all generated files
#
###

JC = javac
FLAGS = -g  
CP = ./deps:.

P4.class: P4.java parser.class Yylex.class ASTnode.class
	$(JC) $(FLAGS) -cp $(CP) P4.java

parser.class: parser.java ASTnode.class Yylex.class ErrMsg.class
	$(JC) $(FLAGS) -cp $(CP) parser.java

parser.java: base.cup
	java -cp $(CP) java_cup.Main < base.cup

Yylex.class: base.jlex.java sym.class ErrMsg.class
	$(JC) $(FLAGS) -cp $(CP) base.jlex.java

ASTnode.class: ast.java SymTable.class
	$(JC) $(FLAGS) -cp $(CP) ast.java

base.jlex.java: base.jlex sym.class
	java -cp $(CP) JLex.Main base.jlex

sym.class: sym.java
	$(JC) $(FLAGS) -cp $(CP) sym.java

sym.java: base.cup
	java -cp $(CP) java_cup.Main < base.cup

ErrMsg.class: ErrMsg.java
	$(JC) $(FLAGS) -cp $(CP) ErrMsg.java

Sym.class: Sym.java
	$(JC) $(FLAGS) -cp $(CP) Sym.java

SymTable.class: SymTable.java Sym.class DuplicateSymNameException.class EmptySymTableException.class
	$(JC) $(FLAGS) -cp $(CP) SymTable.java

DuplicateSymNameException.class: DuplicateSymNameException.java
	$(JC) $(FLAGS) -cp $(CP) DuplicateSymNameException.java

EmptySymTableException.class: EmptySymTableException.java
	$(JC) $(FLAGS) -cp $(CP) EmptySymTableException.java

##test
test:
	java -cp $(CP) P4 nameErrors.base nameErrors.out
	java -cp $(CP) P4 test.base test.out

###
# clean
###
clean:
	rm -f *~ *.class parser.java base.jlex.java sym.java

## cleantest (delete test artifacts)
cleantest:
	rm -f *.out
