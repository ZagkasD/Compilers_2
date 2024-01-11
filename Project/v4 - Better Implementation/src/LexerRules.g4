lexer grammar LexerRules;

// Binary operations
ADD_OP            : '+'|'-';
MUL_OP            : '*'|'/';

// Boolean operations
REL_OP            : '=='|'<='|'>='|'!='|'<'|'>';

// Keywords
ELSE              : 'else';
IF                : 'if';
WHILE             : 'while';
RETURN            : 'return';
CLASS             : 'class';
DEF               : 'def';
INIT              : '__init__';
PASS              : 'pass';
PRINT             : 'print';
AND               : 'and';
NOT               : 'not';
OR                : 'or';
NAME              : '__name__';
MAIN              : '\'__main__\'';

// Flow Controls
LPARA             : '(';
RPARA             : ')';
LBRAC             : '{';
RBRAC             : '}';
COMMA             : ',';
COLON             : ':';
POINT             : '.';

// Assignment operation
AssignOP          : '=' ;

// Alpha/Num
ID                : ('a'..'z'|'A'..'Z'|'_')+ ;
INT               : [0-9]+ ('.' [0-9]+)?;

// Misc
// Having NEWLINE here causes error: 
// line 1:14 extraneous input '\n' expecting 'def'
// line 2:33 extraneous input '\n' expecting {'if', 'while', 'return', 'pass', 'print', ID}
// Even though NEWLINE rules isn't used
// NEWLINE           : ('\n')+;
BLOCK_COMMENT           : ('\'\'\'' .*? '\'\'\'' | '"""' .*? '"""') ->channel(HIDDEN);
// match any line that starts with # and consumes all characters until the end of the line (~[\r\n]*).
COMMENT                 : '#' ~[\r\n]* -> channel(HIDDEN);

// // skip doesn't generate tokens for whitespace characters
// // WS: [ \r\n\t]+ -> skip;
// // channel(HIDDEN) gen tokens and place them in channel hidden from parser
WS                      : [ \t\r\n] -> channel(HIDDEN);


