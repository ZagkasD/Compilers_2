/* 
In v3_x we are working on the output file in c
*/

// TODO imports in c file
// TODO add errors for missing functions/vars
// TODO fix eg
/*
while():
    if():
        ...
    else:
        y
    x
}
here x would print after }, outside of while, in c  file
*/
// TODO when in main, don't write void 

grammar grammar_v3_1;

@header{
    import java.io.FileWriter;  
    import java.io.IOException;  
    import java.io.File;  
    import java.io.FileNotFoundException;  
    import java.util.Scanner;
    //import tabNewlineController;
}
@parser::members {
    ArrayList <Scope> scopes_list = new ArrayList<Scope>();
    addEntity entity;
    WriteToFile RW;
    WriteToFile TmpRw;
    String tempNameClass,line;
    Boolean flagStatement, returnFlag;
    Boolean elseFlag = true;
    Boolean assignFlag = false;
	int tabCounter = 0;
	File pyFile;
	Scanner myReader;
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
              myWriter = new FileWriter("C:\\Users\\dimos\\OneDrive - ΠΑΝΕΠΙΣΤΗΜΙΟ ΙΩΑΝΝΙΝΩΝ\\School\\6th Year\\11th Semester\\Compilers 2\\Project\\v3 - Output File\\src\\"+filename);
            } catch (IOException e) {
              System.out.println("Open file,an error occurred.");
              e.printStackTrace();
            }
        }
        public void merge(String filename)
        {
            try {
                File temp = new File("C:\\Users\\dimos\\OneDrive - ΠΑΝΕΠΙΣΤΗΜΙΟ ΙΩΑΝΝΙΝΩΝ\\School\\6th Year\\11th Semester\\Compilers 2\\Project\\v3 - Output File\\src\\"+filename);
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
                System.out.println("An error occurred OIOIOIOI.");
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
	public int ReturnTotalNumberOftabs(String line){
		int total = 0;
		boolean exit = false;
		if (!(line.startsWith("class"))){
			while (myReader.hasNextLine()){
				for (int i = 0; i < line.length(); i++) {
					char ch = line.charAt(i);
					if (ch != '\n' && ch != '\t' && ch != ' ') {
						exit = true;
					}
					else {
						exit = false;
						break;
					}
				}
				if (exit == true){
					line = myReader.nextLine();
				}
				else break;
			}
		}
		for (int i = 0; i < line.length(); i++) {
		  char ch = line.charAt(i);
		  if (ch == ' ' || ch == '\t') {
			total++;
		  }
		  else return total;
		}
		return total;
	}
}
prog
    :classes
;
classes
    : {
		pyFile = new File("test_input.py");
		try{
			myReader = new Scanner(pyFile);
		}catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        RW = new WriteToFile();
        RW.openFile("testC.c");
        RW.writeFile("#include <stdio.h>\n");
	}class+ {myReader.close();} main
;
class
    : 'class' ID ':'
    {  
		line = myReader.nextLine();
		if(ReturnTotalNumberOftabs(line)!=tabCounter)
		{
			System.out.println("Check your tabs in the begining of your class");
			System.exit(0);
		}
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
    |'class' ID{
		line = myReader.nextLine();
		if(ReturnTotalNumberOftabs(line)!=tabCounter)
		{
			System.out.println("Check your tabs in the begining of your class");
			System.exit(0);
		}
		tempNameClass = $ID.text;
	} '('ID')' ':'
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
    'if' '__name__' '==' '\'__main__\'' ':'
    {
		tabCounter+=1;
        TmpRw.openFile("temp.c");      
        RW.writeFile("int main(){\n");
    }
    statements
    {
        TmpRw.closeFile();
        // Reset the return flag for the next function
        RW.merge("temp.c");
		RW.writeFile("}\n");
		RW.closeFile();
    }
;
initFunction
    :'def''__init__'
    {
		tabCounter +=1;
		line = myReader.nextLine();
		if(ReturnTotalNumberOftabs(line)!=tabCounter)
		{
			System.out.println("Check your tabs near line: "+line);
			System.exit(0);
		}
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
            if(i>0)RW.writeFile("\t".repeat(tabCounter)+"int "+fun.getFormalParList().get(i).getName()+";\n");
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
		tabCounter -=1;
    }
;
functions
    :function ( function)*
    |
;
function
    :'def' ID
    {
		tabCounter +=1;
		line = myReader.nextLine();
		if(ReturnTotalNumberOftabs(line)!=tabCounter)
		{
			System.out.println("Check your tabs near line: "+line);
			System.exit(0);
		}
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
            TmpRw.writeFile("\t".repeat(tabCounter)+"return 0;\n");
            elseFlag = true;
        }
        TmpRw.writeFile("\n}\n");
        TmpRw.closeFile();
        // Reset the return flag for the next function
        RW.merge("temp.c");
        returnFlag = false;
        scope.remove_scope();
		tabCounter -=1;
    }
;
statements
    :(statement)+
    |
;
statement
    :assignmentStat
	{
		line = myReader.nextLine();
		if(ReturnTotalNumberOftabs(line)!=tabCounter+1)
		{
			System.out.println("Check your tabs near line: "+line);
			System.exit(0);
		}
	}
    |ifStat
	|whileStat
    |printStat
	{
		line = myReader.nextLine();
		if(ReturnTotalNumberOftabs(line)!=tabCounter+1)
		{
			System.out.println("Check your tabs near line: "+line);
			System.exit(0);
		}
	}
    |returnStat
	{
		line = myReader.nextLine();
		if(ReturnTotalNumberOftabs(line)!=tabCounter+1)
		{
			System.out.println("Check your tabs near line: "+line);
			System.exit(0);
		}
	}
    |callStat
	{
		line = myReader.nextLine();
		if(ReturnTotalNumberOftabs(line)!=tabCounter+1)
		{
			System.out.println("Check your tabs near line: "+line);
			System.exit(0);
		}
	}
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
    :actualparitem (','
    {
        if(flagStatement == true)RW.writeFile(",");
        else TmpRw.writeFile(",");
    }
    actualparitem)*
    |
;
actualparitem
    :expression
    |obj
    |ID
    {
        if(flagStatement == true)RW.writeFile($ID.text);
        else TmpRw.writeFile($ID.text);
    }
;
assignmentStat
    :(
        (
            ID
            {
                if(flagStatement == true)RW.writeFile("\t".repeat(tabCounter)+$ID.text);
                else TmpRw.writeFile("\t".repeat(tabCounter)+$ID.text);
            }
        )
        |obj
    )
    {
        if (flagStatement == true)RW.writeFile(" = ");
        else TmpRw.writeFile(" = ");
    }
    // expression or callStat for e.g.  george = Person(200223, 2002)
    '=' (expression | {assignFlag = true;} callStat)
    {
        if (flagStatement == true) RW.writeFile(";\n");
        else TmpRw.writeFile(";\n");
    }
;
// Two option, one with parentheses and one without
// because python accepts both
ifStat
    :'if'
        {
			line = myReader.nextLine();
			if(ReturnTotalNumberOftabs(line)!=tabCounter+1)
			{
				System.out.println("Check your tabs near line: "+line);
				System.exit(0);
			}
            // Need to set elseFlag false for each if
            elseFlag = false;
            if(flagStatement==true)RW.writeFile("\t".repeat(tabCounter)+"if (");
            else TmpRw.writeFile("\t".repeat(tabCounter)+"if (");
        }
    condition':'
    {
		tabCounter +=1;
        if(flagStatement==true)RW.writeFile("){\n");
        else TmpRw.writeFile("){\n");
    }
        statements
    {
		tabCounter -=1;
        if(flagStatement==true)RW.writeFile("\t".repeat(tabCounter)+"}\n");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
    }
    elsepart
    |'if' '('
    {
		line = myReader.nextLine();
		if(ReturnTotalNumberOftabs(line)!=tabCounter+1)
		{
			System.out.println("Check your tabs near line: "+line);
			System.exit(0);
		}
        elseFlag = false;
        if(flagStatement==true)RW.writeFile("\t".repeat(tabCounter)+"if (");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"if (");
    }
    condition')'':'
    {
		tabCounter +=1;
        if(flagStatement==true)RW.writeFile("){\n");
        else TmpRw.writeFile("){\n");
    }
    statements
    {
		tabCounter -=1;
        if(flagStatement==true)RW.writeFile("\t".repeat(tabCounter)+"}\n");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
    }
    elsepart
;
elsepart
    :'else'':'
    {
		line = myReader.nextLine();
		if(ReturnTotalNumberOftabs(line)!=tabCounter+1)
		{
			System.out.println("Check your tabs near line: "+line);
			System.exit(0);
		}
        if(flagStatement==true)RW.writeFile("\t".repeat(tabCounter)+"else {\n");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"else {\n");
        // Need this flag here to add return 0 at C when else doesn't exist
        elseFlag = true;
		tabCounter+=1;
    }
    statements
    {
		tabCounter-=1;
        if(flagStatement==true)RW.writeFile("}\n");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
    }
    |
;
whileStat
    :'while'
    {
            if(flagStatement==true)RW.writeFile("\t".repeat(tabCounter)+"while (");
            else TmpRw.writeFile("\t".repeat(tabCounter)+"while (");
    }
    '(' condition ')' ':'
    {
		tabCounter +=1;
        if(flagStatement==true)RW.writeFile("){\n");
        else TmpRw.writeFile("){\n");
    }
    statements
    {
		tabCounter -=1;
        if(flagStatement==true)RW.writeFile("\t".repeat(tabCounter)+"}\n");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
    }
    |'while'
    {
		if(flagStatement==true)RW.writeFile("\t".repeat(tabCounter)+"while (");
		else TmpRw.writeFile("\t".repeat(tabCounter)+"while (");
    }
    condition ':'
    {
		tabCounter +=1;
        if(flagStatement==true)RW.writeFile("){\n");
        else TmpRw.writeFile("){\n");
    }
    statements
    {
		tabCounter -=1;
        if(flagStatement==true)RW.writeFile("\t".repeat(tabCounter)+"}\n");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
    }
;
printStat
    :'print'
    {
        if(flagStatement==true)RW.writeFile("\t".repeat(tabCounter)+"printf (");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"printf (");
    }
    '(' expression ')'
    {
        if(flagStatement==true)RW.writeFile(");\n");
        else TmpRw.writeFile(");\n");
    }
;
returnStat
    : 'return '
        {
            if(flagStatement==true)RW.writeFile("\t".repeat(tabCounter)+"return ");
            else {
                TmpRw.writeFile("\t".repeat(tabCounter)+"return ");
            }
        }
        expression
        {
            if(flagStatement==true)RW.writeFile(";\n");
            else TmpRw.writeFile(";\n");
            returnFlag = true;
        }
    |'return ''('
    {
        if(flagStatement==true)RW.writeFile("\t".repeat(tabCounter)+"return (");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"return (");
    }
    expression ')'
        {
            if(flagStatement==true)RW.writeFile(");\n");
            else TmpRw.writeFile(");\n");
            returnFlag = true;
        }
;
callStat
    :obj |
    (ID
    {
        if(flagStatement==true)RW.writeFile("\t".repeat(tabCounter)+$ID.text);
        else TmpRw.writeFile("\t".repeat(tabCounter)+$ID.text);
    })
    '('
    {
        if(flagStatement == true)RW.writeFile("(");
        else TmpRw.writeFile("(");
    }
    actualparlist')'
    {
        if(flagStatement == true){
            RW.writeFile(")");
            if (assignFlag == false){
                if(flagStatement == true)RW.writeFile(";");
                else TmpRw.writeFile(";");
                assignFlag = false;
            }
        }
        else TmpRw.writeFile(")");  
    }
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
            if(flagStatement == true)RW.writeFile("\t".repeat(tabCounter)+$ID.text+"->");
            else TmpRw.writeFile("\t".repeat(tabCounter)+$ID.text+"->");
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
WS: [ \r\n\t]+ -> skip;