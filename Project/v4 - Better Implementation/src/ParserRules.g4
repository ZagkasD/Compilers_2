parser grammar ParserRules;

import LexerRules;

classes
    :class+ main
;

class
    : CLASS ID COLON initFunction functions
    | CLASS ID LPARA ID RPARA COLON initFunction functions
;

initFunction
    :DEF INIT LPARA formalparlist RPARA COLON
    statements
;

functions
    :function (function)*
    |
;

function
    :DEF ID LPARA formalparlist RPARA COLON
    statements
;

main
    :IF NAME REL_OP MAIN COLON
    statements
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
    |PASS
;

assignmentStat
    : (ID | obj) AssignOP (callStat | expression)
;

ifStat
    :IF condition COLON
    statements
    elsepart
;

whileStat
    :WHILE LPARA condition RPARA COLON
    statements
;

printStat
    :PRINT LPARA expression RPARA
;

returnStat
    : RETURN expression
;

callStat
    :(obj | ID) LPARA actualparlist RPARA
;

condition
    :boolterm (OR boolterm)*
;

boolterm
    :boolfactor (AND boolfactor)*
;

boolfactor
    :NOT LPARA condition RPARA
    |LPARA condition RPARA
    |expression REL_OP expression
;

elsepart
    :ELSE COLON
    statements
    |
;

formalparlist
    :formalparitem (COMMA formalparitem)*
;

formalparitem
    :ID | obj |
;

obj
    :ID POINT ID
    |ID POINT callStat
;

expression
    :optionalSign term (ADD_OP term)*
;

optionalSign
    :ADD_OP
    |
;

term
    :factor (MUL_OP factor)*
;

factor
    :INT
    |ID
    |obj
    |LPARA expression RPARA
;

actualparlist
    :actualparitem (COMMA actualparitem)*
    |
;

actualparitem
    :expression
    |obj
    |ID
;
