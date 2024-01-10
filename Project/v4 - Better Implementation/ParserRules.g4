parser grammar ParserRules;

import LexerRules;

prog
    :classes
;
classes
    :class+ main
;
class
    : 'class' ID ':' initFunction functions
;
initFunction
    :
;
functions
    :
;
main
    :
;