// Tried to control tabs with rule printTabs
// Doesn't work because it doesnt write \t but four spaces
grammar grammar_v1;

@parser::members{
	int tabCounter = 0;	
    String tab = "";
	int getTabCounter(){
		return tabCounter;
	}
}
prog
    :classes;
main:
	'if' '__name__' '==' '\'__main__\'' ':'statements
	;
 
classes
    : class ( class)*;   
class
    : 'class' ID ':' initFunction  functions;
initFunction
    :{tabCounter++;}
    {System.out.println("tabCounter = " + tabCounter);}
    printTabs'def''__init__''('formalparlist')'':'  (statements | 'pass')
    {tabCounter--;};
functions
    : function ( function)*	
	|
;
function
    :'\t'{tabCounter++;}'def' ID '(' formalparlist')' ':' (statements | 'pass')
;
statements
    :({tabCounter++;}printTabs statement)*
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
    :'\t''if' condition':''\t'statements '\t' elsepart
    |'\t''if' '('condition')'':'statements '\t'elsepart
;
elsepart
    :'\t''else'':' '\t'statements
    |
;
whileStat
    :'while' '(' condition ')' ':'
    statements
    |'while' condition ':'
    statements
;
printStat
    :'print' '(' expression ')'
;
returnStat
    :'\t''return' expression
    |'\t''return' '(' expression ')'
;
callStat
    :ID '('actualparlist')'
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
    :'\n''\t'
;

// @TODO fix tab not workin either in java nor in the compiler
printTabs returns [String tab]
    :{$tab = "\t".repeat(getTabCounter());}
    {System.out.println("tab = "+tab);}
;
tabs: TAB*;
TAB: '\t';

//NEWLINE: ('\n')+;
ID: [a-zA-Z_]+ [a-zA-Z0-9_]*;
INT: [0-9]+ ('.' [0-9]+)?; 
REL_OP: '=='|'<='|'>='|'!='|'<'|'>';
ADD_OP: '+'|'-';
MUL_OP: '*'|'/';
COMMENT: '"""' .*? '"""' ->channel(HIDDEN);
point: '.';
WS:    
    [ \r\n]+ -> skip;