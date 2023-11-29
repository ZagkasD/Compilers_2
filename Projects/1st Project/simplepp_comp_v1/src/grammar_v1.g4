grammar grammar_v1;

prog
    :classes 
;
 
classes
    : class (NEWLINE class)*
;
    
class
    : 'class' ID ':'block initFunction block functions
;

initFunction
    :'def''__init__''('formalparlist')'':' block (statements | 'pass')
;

functions
    : function (block function)*
	|
;

function
    :'def' ID '(' formalparlist')' ':'block (statements | 'pass')
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

// @TODO fix \n and \t using a rule
block
    :'\n''\t'
    //|NEWLINE('\t')+
    //|NEWLINE'\t'
    //|(NEWLINE ('\t')*)*
;

NEWLINE: ('\n')+;
ID: [a-zA-Z_]+ [a-zA-Z0-9_]*;
INT: [0-9]+ ('.' [0-9]+)?; 
REL_OP: '=='|'<='|'>='|'!='|'<'|'>';
ADD_OP: '+'|'-';
MUL_OP: '*'|'/';
COMMENT: '"""' .*? '"""' ->channel(HIDDEN);
WS:    
    //[ \r\t\n]+ -> skip
    [ \r]+ -> skip
;  
   
   
   
   