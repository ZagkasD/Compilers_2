/* 
In v2_x we are working on the symbol table to implement correct access
to memory (inheritance, etc.)
*/


grammar grammar_v2_1;
 
@parser::members {
	
    int nesting_level = 0;
    ArrayList <Scope> scopes_list = new ArrayList<Scope>();

	public class Scope{
		private ArrayList <Entity> entities_list = new ArrayList<Entity>();
        int _nesting_level;
        // private nesting_level = 0;

		public Scope (int nesting_level){
            
			this._nesting_level = nesting_level;
            // this.nesting_level += 1;
		}
	}
    
    // Add scope to scopes_list
    public class AddScope{
        public void add_scope(){
            // @TODO fix nesting level
            nesting_level += 1;
            Scope new_scope = new Scope(nesting_level);
            scopes_list.add(new_scope);
        }

        public void remove_scope(){
            int lastIndex = scopes_list.size() - 1;
            scopes_list.remove(lastIndex);
            // scopes_list.pop();
            nesting_level -=1;
        }
    }

    public abstract class Entity {
		private String name;

		public Entity(String name) {
			this.name = name;
		}

		// public void add(Entity EntityObj);
	}

	// public class Variable extends Entity {
		
    //     public Variable(String name) {
	// 		super(name);
	// 	}

	// 	// public void add(String name){
	// 	// 	EntityList.add(EntityObj);
	// 	// }
	// }

    // public class Object extends Entity {
        
    // }

    // public class Class extends Entity {

    // }

	// public class FormalParameter extends Entity{// for functions
	// 	public FormalParameter(String name) {
	// 		super(name);
	// 	}
	// }	


}
 
prog
    :classes
;
classes
    :class ('\n' class)* main
;
class
    : 'class' ID ':'
    {
        AddScope new_scope = new AddScope();
        new_scope.add_scope();
    }
    initFunction  functions
    {
        new_scope.remove_scope();
    }
	|'class' ID '('ID')' ':'initFunction  functions
;
 
main:
	'if' '__name__' '==' '\'__main__\'' ':'statements
;
initFunction
    :'\n''\t' 'def''__init__''('formalparlist')'':'(statements | 'pass')
;
functions
    : function ( function)*	
	|
;
function
    :'\n''\t' 'def' ID '(' formalparlist')' ':'(statements | 'pass')
;
statements
    :('\n'('\t'statement)*)*
	|
;
statement
    :assignmentStat
    |ifStat
    |whileStat
    |printStat
    |returnStat
    |callStat
;
/*
A list of formal parameters
eg. def foo(x)
the x would be a formal parameter item
*/
formalparlist
    :formalparitem (','formalparitem)*
;
formalparitem
    :ID
    |obj
;
/*
A list of actual parameter items
Used when the function is called
eg. foo(4)
the 4 would be an actual parameter item
The empty option (|) is in actualparlist and not in actualparitem
eg. foo(boolean), that would end up in actualparitem empty option
when it has to throw an error
*/
actualparlist
    :actualparitem (','actualparitem)*
    |
;
actualparitem
    :expression
    |obj
    |ID
;
assignmentStat
    : '\t'(ID | obj) '=' expression
;
// Two option, one with parentheses and one without
// because python accepts both
ifStat
    :'\t''if' condition':''\n' '\t' statements  elsepart
    |'\t''if' '('condition')'':''\n' '\t' statements elsepart
;
elsepart
    :'else'':'  statements
    |
;
whileStat
    :'\t''while' '(' condition ')' ':''\n' '\t' statements
	|'\t''while' condition ':'  '\n' '\t' statements
;
printStat
    :'\t''print' '(' expression ')'
;
returnStat
    :'\t''return' expression
    |'\t''return' '(' expression ')'
;
callStat
    :'\t'ID '('actualparlist')'
;
condition
    :boolterm
    ('or' boolterm)*
;
boolterm
    :boolfactor
    ('and' boolfactor)*
;
// Parentheses are mandatory here because of left-recursiveness error
boolfactor
    : 'not' '(' condition ')'
    | '(' condition ')'
    | expression REL_OP expression
;
obj 
    :ID'.'ID 
;
expression
	:optionalSign term 
    (ADD_OP term)*
;
term
    :factor (MUL_OP factor)*
;
factor
    :INT
	|ID
    // @TODO ID idtail
    |obj
    |'('expression')'
;
optionalSign
    :ADD_OP
    |
;
block
    :NEWLINE'\t'
;
NEWLINE: ('\n')+;
ID: [a-zA-Z_]+ [a-zA-Z0-9_]*;
INT: [0-9]+ ('.' [0-9]+)?; 
REL_OP: '=='|'<='|'>='|'!='|'<'|'>';
ADD_OP: '+'|'-';
MUL_OP: '*'|'/';
COMMENT: '"""' .*? '"""' ->channel(HIDDEN);
point: '.';
WS: [ \r]+ -> skip;