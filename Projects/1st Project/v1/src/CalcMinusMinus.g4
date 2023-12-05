grammar CalcMinusMinus;

@parser::members{
    mem = 0
    def memread(self):
        return self.mem
    def memwrite(self):
        self.mem = x
}

startRule
    : expr
        {print($expr.v)}
    | startRule expr
        {print($expr.v)}
    | assignment
    | startRule assignment
;

expr
    : val1=value op=OP val2=value '='

        {if $val1.b=0: }
        {    op1=$val1.v  }
        {else:         }
        {   op1=self.memread()}
        {if $val2.b=0:}
        {   op2=$val2.v}
        {else:  }
        {   op2=self.memread()}
        {if $op.text=='+': $v=op1+op2}
        {if $op.text=='-': $v=op1-op2}
        {if $op.text=='x': $v=op1*op2 }  
        {print(op1,$op.text,op2,'= ',end='')}
;

assignment
    :   MEM '=' value
        {self.memwrite(int($value.text))}
;

value returns [int v]
    : NUM
        {$v=int($NUM.text)}
        {$b=0}
    | MEM
        {$b=1}
;
NUM : [0-9]+;
MEM : 'mem';
OP  : [+-x]+;
WS  : [ \t\r\n] -> skip;