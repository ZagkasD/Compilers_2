grammar grammar_v1;

/*
At the simplest form, all global variables have to be defined
before all the classes
@TODO allow variables to be assigned after classes, if not used by them
*/

prog
    :classes
    |statements 
;
 
classes
    : class (NEWLINE class)*
;
    
class
    : 'class' ID ':''\n''\t' initFunction '\n''\t'functions
;

initFunction
    :'def''__init__''('formalparlist')'':' '\n''\t'(statements | 'pass')
;

// @TODO def in def
functions
    : function ('\n''\t'function)*
	|
;

function
    :'def' ID '(' formalparlist')' ':' '\n''\t' (statements | 'pass')
;

statements
    :(statement'\n''\t')*
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
    : ID '=' expression
    // @TODO allow multiple assignment, eg. x,y = 1,2. Number of vars = numb of values
;

// Two option, one with parentheses and one without
// because python accepts both
ifStat
    :'if' condition':'
    statements
    elsepart
    |'if' '('condition')'':'
    statements
    elsepart
;

elsepart
    :'else'':'
    statements
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
    :'return' expression
    |'return' '(' expression ')'
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

// @TODO allow condition without parentheses
// Parentheses are mandatory here because of left-recursiveness error
boolfactor
    : 'not' '(' condition ')'
    | '(' condition ')'
    | expression REL_OP expression
;

obj 
    :ID'.'ID assignmentStat
    |ID'.'ID
;

expression
    :optionalSign term 
    (ADD_OP term)*
;

term
    :factor
    (MUL_OP factor)*
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

ID: [a-zA-Z_]+ [a-zA-Z0-9_]*;
INT: [0-9]+ ('.' [0-9]+)?; 
REL_OP: '=='|'<='|'>='|'!='|'<'|'>';
ADD_OP: '+'|'-';
MUL_OP: '*'|'/';
COMMENT: '"""' .*? '"""' ->channel(HIDDEN);
NEWLINE: ('\n')+;
WS:    
    // @TODO fix \n and \t
    //[ \r\t\n]+ -> skip
    [ \r]+ -> skip
;  
   
   
   
   