/* 
In v2_x we are working on the symbol table to implement correct access
to memory (inheritance, etc.)
*/

/*
The main in test_input.py isn't in symbol table because
there are no declarations there
*/


grammar grammar_v2_1;

@parser::members {
    ArrayList <Scope> scopes_list = new ArrayList<Scope>();
    addEntity entity;

    public class Scope{
        private ArrayList <Entity> entities_list = new ArrayList<Entity>();
        private int _nesting_level;

        public Scope (int nesting_level){
            this._nesting_level = nesting_level;
        }
        public int getNestingLevel(){
            return this._nesting_level;
        }
        public ArrayList <Entity> getEntitiesList(){
            return this.entities_list;
        }
    } 
    public class Entity{
        private String _name;
        public void SetName(String name){
            this._name = name;
        }
		public String getName(){
            return this._name;
        }
    }
    public class Variable extends Entity {
        public Variable(String name) {
            super.SetName(name);
        }
    }
    public class Class extends Entity {
        private String _parent;
        public Class(String name, String parent) {
            this._parent = parent;
        }
        public Class(String name) {
           super.SetName(name);
        }
    }
    public class FormalParameter extends Entity{
        public FormalParameter(String name) {
           super.SetName(name);
        }
    }
    public class Function extends Entity{
        private ArrayList <FormalParameter> formal_par_list = new ArrayList<FormalParameter>();
        public Function(String name) {
            super.SetName(name);
        }
		public void appendParToFormalParList(FormalParameter param){
			formal_par_list.add(param);
		}
        public ArrayList <FormalParameter> getFormalParList(){
            return formal_par_list;
        }
    }
    // ===========================================================
    // SYMBOL TABLE FUNCTIONS
    // ===========================================================
    // Add new scope to scopes_list
    public class AddScope{
        public void add_new_scope(){
            // Give the proper nesting level for the new_scope
            if (scopes_list.isEmpty()){
                Scope new_scope = new Scope(0);
                scopes_list.add(new_scope);  
            }
            else{
                int lastIndex = scopes_list.size() - 1;
                // Increase the nesting level from the last scope
                int new_nesting_level = (scopes_list.get(scopes_list.size() - 1)).getNestingLevel() + 1;
                Scope new_scope = new Scope(new_nesting_level);
                scopes_list.add(new_scope);
            }
        }
        public void remove_scope(){
            int last_scope = scopes_list.size() - 1;
            scopes_list.remove(last_scope);
        }
    }
    public class addEntity{
        public void add_new_function(String name){
			Function fun = new Function(name);
            scopes_list.get(scopes_list.size()-1).getEntitiesList().add(fun);    
        }
		public void add_parameter(String param){
			//go to the last entity of the last scope and add the parameters
			FormalParameter objParm = new FormalParameter(param);
            ArrayList <Entity> entities_list = scopes_list.get(scopes_list.size()-1).getEntitiesList();
            
            // Important. Downcast the return object of the entities_list, because it stores Entity type objects
            Function fun = (Function) entities_list.get(entities_list.size()-1);
            fun.appendParToFormalParList( objParm);
		}
		public void add_variable(String name){
			Variable objVar = new Variable(name);
			int nesting_level = (scopes_list.get(scopes_list.size() - 1)).getNestingLevel();
            
            // Check for variable that already exist
			for (Entity ent : scopes_list.get(nesting_level).getEntitiesList()){
				if(ent.getName() == name){
					System.out.println("Error, bro same name wtf!!!");
				}
				else scopes_list.get(scopes_list.size()-1).getEntitiesList().add(objVar);
			}
		}
    }
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
        AddScope scope = new AddScope();
        scope.add_new_scope();
        entity = new addEntity();
    }
    initFunction  functions
    {
        scope.remove_scope();
    }
    |'class' ID '('ID')' ':'
    {  
        AddScope scope = new AddScope();
        scope.add_new_scope();
    }
    initFunction  functions
    {
        scope.remove_scope();
    }
;
main:
    'if' '__name__' '==' '\'__main__\'' ':'statements
;
initFunction
    :'\n''\t' 'def''__init__' 
	{
        entity.add_new_function("__init__");
	} 
	'('formalparlist')'':'
    {  
        AddScope scope = new AddScope();
        scope.add_new_scope();
    }
    (statements | 'pass')
    {
        scope.remove_scope();
    }
;
functions
    : function ( function)*
    |
;
function
    :'\n''\t' 'def' ID
    {
    entity.add_new_function($ID.text);
    }
    '(' formalparlist')' ':'
    {  
        AddScope scope = new AddScope();
        scope.add_new_scope();
    }
    (statements | 'pass')
    {
        scope.remove_scope();
    }
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
    {
        entity.add_parameter($ID.text);
    }
    |obj
    {
        entity.add_parameter($obj.text);
    }
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
// COMMENT
//  : ( ' ' | '\t' )* '#' ( ~'\n' )* '\n'+
//  | '#' ( ~'\n' )* // let NEWLINE handle \n unless char pos==0 for '#'
//  ;
point: '.';
WS: [ \r]+ -> skip;