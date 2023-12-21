/* 
In v3_x we are working on the output file in c
*/

grammar grammar_v3_1;

@header{
    import java.io.FileWriter;  
    import java.io.IOException;  
    import java.io.File;  
    import java.io.FileNotFoundException;  
    import java.util.Scanner;
}
@parser::members {
    ArrayList <Scope> scopes_list = new ArrayList<Scope>();
    addEntity entity;
    WriteToFile RW;
    WriteToFile TmpRw;
    String tempNameClass;
    String tempStatment;
    Boolean flagStatement, returnFlag;
    Boolean elseFlag = true;

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
    public class WriteToFile {
        private FileWriter myWriter;
        public void openFile(String filename) {
            try {
              myWriter = new FileWriter("C:\\Users\\Zagkas\\Downloads\\"+filename);
            } catch (IOException e) {
              System.out.println("Open file,an error occurred.");
              e.printStackTrace();
            }
        }
        public void merge(String filename)
        {
            try {
                File temp = new File("C:\\Users\\Zagkas\\Downloads\\"+filename);
                if (returnFlag == true) writeFile("int ");
                else writeFile("void ");
                // Write temp file to original file
                Scanner myReader = new Scanner(temp);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    writeFile(data+"\n");
                }
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        public void writeFile(String str) {
            try {
                myWriter.write(str);
            }
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        public void closeFile() {
            try {
                myWriter.close();
            }
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
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
    : 'class'
    {
        RW = new WriteToFile();
        RW.openFile("testC.c");
        RW.writeFile("#include <stdio.h>\n");} ID ':'
    {  
        AddScope scope = new AddScope();
        scope.add_new_scope();
        entity = new addEntity();
        tempNameClass = $ID.text;
        RW.writeFile("\ntypedef struct{ \n");
    }
    initFunction functions
    {
        scope.remove_scope();
    }  
    |'class' ID{tempNameClass = $ID.text;} '('ID')' ':'
    {  
        AddScope scope = new AddScope();
        scope.add_new_scope();
        RW.writeFile("\ntypedef struct{ \n");
    }
    initFunction  functions
    {
        scope.remove_scope();
    }
;
main:
    'if' '__name__' '==' '\'__main__\'' ':'{RW.writeFile("int main(){\n");}statements
    {
        RW.writeFile("}\n");
        RW.closeFile();
    }
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
        ArrayList <Entity> entities_list = scopes_list.get(scopes_list.size()-2).getEntitiesList();
        Function fun = (Function) entities_list.get(entities_list.size()-1);
        //we use this for to fill the struct
        for(int i=0;i<fun.getFormalParList().size();i++){
            if(i>0)RW.writeFile("\tint "+fun.getFormalParList().get(i).getName()+";\n");
        }
        RW.writeFile("}"+tempNameClass+";\n");
        //for the parameters
        for(int i=0;i<fun.getFormalParList().size();i++){
            if(i==0)RW.writeFile("void "+tempNameClass+"_init ("+tempNameClass+" *"+fun.getFormalParList().get(i).getName());
            else if(i>0)RW.writeFile(",int "+fun.getFormalParList().get(i).getName());
        }
        RW.writeFile(") {\n");
        flagStatement = true;
    }
    (statements | 'pass')
    {
        flagStatement = false;
        RW.writeFile("\n}\n");
        scope.remove_scope();
    }
;
functions
    :function ( function)*
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
        ArrayList <Entity> entities_list = scopes_list.get(scopes_list.size()-2).getEntitiesList();
        Function fun = (Function) entities_list.get(entities_list.size()-1);
        //grafoume se tmp arxeio epidi theloyme na doume ti topos einai h sinartisi
        TmpRw = new WriteToFile();
        TmpRw.openFile("temp.c");      
        for(int i=0;i<fun.getFormalParList().size();i++)
        {
            // If it only has self as a parameter
            if(i==0){
                TmpRw.writeFile(" "+tempNameClass+"_"+$ID.text+" ("+tempNameClass+" *"+fun.getFormalParList().get(i).getName());
            }
            // If it has more parameters than self
            else if(i>0)TmpRw.writeFile(",int "+fun.getFormalParList().get(i).getName());
        }
        TmpRw.writeFile(") {\n");
    }
    (statements | 'pass')
    {
		if (elseFlag == false){
			TmpRw.writeFile("\treturn 0;\n");
			elseFlag = true;
        }
        TmpRw.writeFile("\n}\n");
        TmpRw.closeFile();
        // Reset the return flag for the next function
        RW.merge("temp.c");
        returnFlag = false;
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
    |returnStat {System.out.println("line 303"+$returnStat.text); }
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
    : '\t'(
    (ID
    {
        if(flagStatement == true)RW.writeFile("\t"+$ID.text);
        else TmpRw.writeFile("\t"+$ID.text);
    })
    |obj ) 
	{
		if(flagStatement == true)RW.writeFile(" = ");
		else TmpRw.writeFile(" = ");
    }'=' expression
        {
            if(flagStatement == true)RW.writeFile(";\n");
            else TmpRw.writeFile(";\n");
        }
;
// Two option, one with parentheses and one without
// because python accepts both
ifStat
    :'\t''if'
        {
            // Need to set elseFlag false for each if
            elseFlag = false;
            if(flagStatement==true)RW.writeFile("\tif (");
            else TmpRw.writeFile("\tif (");
        }
    condition':'
    {
		System.out.println("line 371 in if");
        if(flagStatement==true)RW.writeFile("){\n\t");
        else TmpRw.writeFile("){\n\t");
    }
	'\n' '\t' statements
	{
		System.out.println("line 377 }");
        if(flagStatement==true)RW.writeFile("}\n");
        else TmpRw.writeFile("}\n");
    }
    elsepart
    |'\t''if' '('
	{
		elseFlag = false;
		if(flagStatement==true)RW.writeFile("\tif (");
		else TmpRw.writeFile("\tif (");
    }
	condition')'':'
    {
        if(flagStatement==true)RW.writeFile("){\n");
        else TmpRw.writeFile("){\n");
    }
    '\n' '\t' statements
    {
        if(flagStatement==true)RW.writeFile("}\n");
        else TmpRw.writeFile("}\n");
    }
    elsepart
;
elsepart
    :'else'':'
    {
        elseFlag = true;
    }
    statements
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
    : '\t''return '
        {
            if(flagStatement==true)RW.writeFile("\treturn ");
            else {
				System.out.println("line 420");
				TmpRw.writeFile("\treturn ");
			}
        }
        expression
        {
            if(flagStatement==true)RW.writeFile(";\n");
            else TmpRw.writeFile(";\n");
            returnFlag = true;
        }
    |'\t''return ''(' 
	{
		if(flagStatement==true)RW.writeFile("\treturn (");
		else TmpRw.writeFile("\treturn (");
    }
	expression ')'
        {
            if(flagStatement==true)RW.writeFile(");\n");
            else TmpRw.writeFile(");\n");
            returnFlag = true;
        }
;
callStat
    :'\t'ID '('actualparlist')'
;
condition
    :boolterm
    ('or'
    {
        if(flagStatement==true)RW.writeFile(" or ");
        else TmpRw.writeFile(" or ");
    }
    boolterm)*
;
boolterm
    :boolfactor
    ('and'
    {
        if(flagStatement==true)RW.writeFile(" and ");
        else TmpRw.writeFile(" and ");
    }
    boolfactor)*
;
// Parentheses are mandatory here because of left-recursiveness error
boolfactor
    : 'not' '('
    {
        if(flagStatement==true)RW.writeFile(" not (");
        else TmpRw.writeFile(" not (");
    }
    condition ')'
    {
        if(flagStatement==true)RW.writeFile(")");
        else TmpRw.writeFile(")");        
    }
    | '('
    {
        if(flagStatement==true)RW.writeFile("(");
        else TmpRw.writeFile("(");        
    }
    condition ')'
    {
        if(flagStatement==true)RW.writeFile(")");
        else TmpRw.writeFile(")");        
    }
    | expression REL_OP
    {
        if(flagStatement==true)RW.writeFile($REL_OP.text);
        else TmpRw.writeFile($REL_OP.text);        
    }
    expression
;
obj
    :ID
        {
            if(flagStatement == true)RW.writeFile("\t"+$ID.text+"->");
            else TmpRw.writeFile("\t"+$ID.text+"->");
        }
    '.'ID
        {
            if(flagStatement == true)RW.writeFile($ID.text);
            else TmpRw.writeFile($ID.text);
        }
;
expression
    :optionalSign
    {
        if(flagStatement==true)RW.writeFile($optionalSign.text);
        else TmpRw.writeFile($optionalSign.text);
    }
    term
    (ADD_OP
    {
        if(flagStatement==true)RW.writeFile($ADD_OP.text);
        else TmpRw.writeFile($ADD_OP.text);  
    }
    term)*
;
term
    :factor (MUL_OP
    {
        if(flagStatement==true)RW.writeFile($MUL_OP.text);
        else TmpRw.writeFile($MUL_OP.text);
    }
    factor)*
;
factor
    :INT
    {
        if(flagStatement==true)RW.writeFile($INT.text);
        else TmpRw.writeFile($INT.text);
    }
    |ID
    {
        if(flagStatement==true)RW.writeFile($ID.text);
        else TmpRw.writeFile($ID.text);
    }
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