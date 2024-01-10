parser grammar ParserRules;

import LexerRules;

classes
    :class+ main
;

class
    : 'class' ID ':' initFunction functions 
;

initFunction
    :'def''__init__(' formalparlist ') :'
    statements
;

functions
    :function (function)*
;

function
    :'def' ID '(' formalparlist ') :'
    statements
;

main
    :
;

formalparlist
    :formalparitem (','formalparitem)*
;

formalparitem
    :ID | obj |
;

obj
    :ID '.' ID
    |ID '.' callStat
;

expression
    :optionalSign term (ADD_OP term)*
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

condition
    :
;

elsepart
    :
;

actualparlist
    :
;

boolterm
    :boolfactor ('and' boolfactor)*
;

boolfactor
    :'not' '(' condition ')'
    |'(' condition ')'
    |expression REL_OP expression
;

statements
    :statement+
;

statement
    :assignmentStat
    |ifStat
    |whileStat
    |printStat
    |returnStat
    |callStat
    |'pass'
;

assignmentStat
    : ID | obj '=' callStat | expression
;

ifStat
    :'if' condition ':'
    elsepart
    statements
;

whileStat
    :'while (' condition ') :'
    statements
;

printStat
    :'print (' expression ')'
;

returnStat
    : 'return ' expression
;

callStat
    :obj | ID '(' actualparlist ')'
;
