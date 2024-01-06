/*
In v3_x we are working on the output file in c
*/
// TODO add errors for missing functions/vars
// TODO formal parameters in functions when they are objects eg.int Person_getPid(Person *self)
grammar ExprParser;
@header{
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.FileReader;
    import java.io.FileWriter;  
    import java.io.IOException;  
    import java.io.File;  
    import java.io.FileNotFoundException;  
    import java.util.Scanner;
	import java.io.RandomAccessFile;
	import java.util.*;
}
@parser::members {
    ArrayList <Scope> scopes_list = new ArrayList<Scope>();
    addEntity entity;
    WriteToFile RW;
    WriteToFile TmpRw;
    String tempNameClass,line,tempAssignment,klironomikotitaName,id,checkIdForParmObj;
    Boolean wrInFinallCfile,klironomikotita=false,elseFlag = true,rmTabsCallstat = false,dontWriteInheritanceData= false, assignFlag = false;
    // Raise assignFlag in assignmentStat before callStat|expression and lower it after them
    int returnFlag,tabCounter = 0,counterFileds=2,lineCounter = 1,lineNumberOfstrucktParam=1;
    File pyFile;
    Scanner myReader;
	ArrayList<String> tempList;
	HashMap<String, ArrayList<Integer>> lineOfClassStruct = new HashMap<String, ArrayList<Integer>>();
	HashMap<String, ArrayList<String>> classesFieldsMap = new HashMap<String, ArrayList<String>>();
	HashMap<String, ArrayList<String>> objectPointsClassNameMap = new HashMap<String, ArrayList<String>>();
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
		private String filename;
        public void openFile(String filename,boolean f) {
			this.filename = filename;
            try {
              myWriter = new FileWriter("C:\\Users\\Damianos\\Desktop\\"+filename,f);
            } catch (IOException e) {
              System.out.println("Open file,an error occurred.");
              e.printStackTrace();
            }
        }
        public void merge(String filename)
        {
            try {
                File temp = new File("C:\\Users\\Damianos\\Desktop\\"+filename);
                if (returnFlag == 1) writeFile("int ");
                else if(returnFlag !=-1 )writeFile("void ");
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
		public void seekInfile(int leng,String s)
		{
			try (RandomAccessFile file = new RandomAccessFile("C:\\Users\\Damianos\\Desktop\\"+this.filename, "rw")) {
				// Move the pointer to the desired position (e.g., byte offset 5)
				file.seek(file.length()-leng);
				// Write new content at the specified position
				file.writeBytes(s);
				//printFileContent(file);
			} catch (IOException e) {
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
        if (!(line.startsWith("class"))){
            while (myReader.hasNextLine()){
                if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")) {
                    line = myReader.nextLine();
                }
                else {  
                    return -1;
                }
            }
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch == ' ' || ch == '\t') {
                    total++;
                }
                else return total;
            }
        }
        return total;
    }
	public void objectParam(String paraitem){
		if(!(paraitem.matches("-?\\d+(\\.\\d+)?"))){
			for (String key : objectPointsClassNameMap.keySet()) {
				if(objectPointsClassNameMap.get(key).contains(paraitem)){
					try {
						// Read the content of the file
						BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Damianos\\Desktop\\"+"testC.c"));
						StringBuilder content = new StringBuilder();
						String line;
						int currentLineNumber = 1;
						while ((line = reader.readLine()) != null) {
							if (lineOfClassStruct != null && checkIdForParmObj != null){
								if (currentLineNumber == lineOfClassStruct.get(checkIdForParmObj).get(0) && lineNumberOfstrucktParam>0){
									for(int i=0;i<lineNumberOfstrucktParam;i++){
										content.append(line).append(System.lineSeparator());
										line = reader.readLine();
									}
									 // Modify the line with the replacement text
									System.out.println(line.split("int")[1]);
									line = key+line.split("int")[1];
								}
							}
							content.append(line).append(System.lineSeparator());
							currentLineNumber++;
						}
						reader.close();
						// Write the modified content back to the file
						BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Damianos\\Desktop\\"+"testC.c"));
						writer.write(content.toString());
						writer.close();
						System.out.println("File modified successfully.");
					} catch (IOException e) {
						e.printStackTrace();
					}					
					break;
				} 
			}
		}
		lineNumberOfstrucktParam++;
	}
}
prog
    :classes
;
classes
    : {
        pyFile = new File("input.py");
        try{
            myReader = new Scanner(pyFile);
        }catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        RW = new WriteToFile();
        RW.openFile("testC.c",false);
        RW.writeFile("#include <stdio.h>\n");
    }class+  main
;
class
    : 'class' ID ':'
    {  
        line = myReader.nextLine();
        int temp = ReturnTotalNumberOftabs(line) ;
        if(temp != -1 && temp!=tabCounter)
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
        int temp = ReturnTotalNumberOftabs(line) ;
        if( temp != -1 && temp!=tabCounter)
        {
            System.out.println("Check your tabs in the begining of your class");
            System.exit(0);
        }
        tempNameClass = $ID.text;
    } '('ID { klironomikotitaName = $ID.text;}')' ':'
    {  
		klironomikotita = true;
        AddScope scope = new AddScope();
        scope.add_new_scope();
        RW.writeFile("\ntypedef struct{ \n");
    }
    initFunction  functions
    {
		klironomikotita = false;
        scope.remove_scope();
    }
;
main:
    'if' '__name__' '==' '\'__main__\'' ':'
    {
        tabCounter+=1;
        returnFlag = -1;
        TmpRw.openFile("temp.c",false);      
        RW.writeFile("int main(){\n");
		RW.closeFile();
		File temp = new File("C:\\Users\\Damianos\\Desktop\\"+"testC.c");
		try{
			Scanner myReader = new Scanner(temp);
			Boolean structFlag = false;
			int tempCountLine = 0;
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				if( line.contains("typedef")){
					tempCountLine = lineCounter;
					structFlag = true;
				}
				if(line.contains("}")&& structFlag == true){
					ArrayList<Integer> templ = new ArrayList<Integer>();
					templ.add(tempCountLine);
					templ.add(lineCounter);
					lineOfClassStruct.put((line.split("}")[1].trim()).split(";")[0],templ);
					structFlag = false;
				}
				lineCounter+=1;
			}
			myReader.close();
			RW.openFile("testC.c",true);
		}catch (IOException e) {
			e.printStackTrace();
		}
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
        int temp = ReturnTotalNumberOftabs(line) ;
        if(temp != -1 && temp!=tabCounter)
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
        //we use this to fill the struct
		if(klironomikotita == true)RW.writeFile("\t".repeat(tabCounter)+klironomikotitaName+" base;\n");
		tempList = new ArrayList<String>();
        for(int i=0;i<fun.getFormalParList().size();i++){
			tempList.add(fun.getFormalParList().get(i).getName());
			classesFieldsMap.put(tempNameClass,tempList);
			if(i>0 && klironomikotita == true){
				System.out.println((classesFieldsMap.get(klironomikotitaName)));
				if (!((classesFieldsMap.get(klironomikotitaName)).contains(fun.getFormalParList().get(i).getName()))){
					RW.writeFile("\t".repeat(tabCounter)+"int "+fun.getFormalParList().get(i).getName()+";\n");
				}
			}
            else if(i>0 && klironomikotita == false) RW.writeFile("\t".repeat(tabCounter)+"int "+fun.getFormalParList().get(i).getName()+";\n");
        }
        RW.writeFile("}"+tempNameClass+";\n");
        //for the parameters
        for(int i=0;i<fun.getFormalParList().size();i++){
            if(i==0)RW.writeFile("void "+tempNameClass+"_init ("+tempNameClass+" *"+fun.getFormalParList().get(i).getName());
            else if(i>0)RW.writeFile(",int "+fun.getFormalParList().get(i).getName());
        }
        RW.writeFile(") {\n");
        wrInFinallCfile = true;
		counterFileds =2;
    }
    (statements | 'pass')
    {
        wrInFinallCfile = false;
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
        int temp = ReturnTotalNumberOftabs(line) ;
        if(temp != -1 && temp!=tabCounter)
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
        TmpRw.openFile("temp.c",false);      
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
        returnFlag = 0;
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
        int temp = ReturnTotalNumberOftabs(line) ;
        if(temp != -1 && temp!=tabCounter+1)
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
        int temp = ReturnTotalNumberOftabs(line) ;
        if(temp != -1 && temp!=tabCounter+1)
        {
            System.out.println("Check your tabs near line: "+line);
            System.exit(0);
        }
    }
    |returnStat
    {
        line = myReader.nextLine();
        int temp = ReturnTotalNumberOftabs(line) ;
        if(temp != -1 && temp!=tabCounter+1)
        {
            System.out.println("Check your tabs near line: "+line);
            System.exit(0);
        }
    }
    |callStat
    {
        line = myReader.nextLine();
        int temp = ReturnTotalNumberOftabs(line) ;
        if(temp != -1 && temp!=tabCounter+1)
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
    :actualparitem
    {
		//if(!($actualparitem.text.isEmpty()) && assignFlag == true) auto den leitourgei stin periptosh tou komatos stin Employee_setDepartment(&peter,2)
		// alla stin katw sinthiki an kalesoume mi sinartisi apeythias mporei na valei koma ekei poy den theloume
        if(!($actualparitem.text.isEmpty())){
			objectParam($actualparitem.text);
            if(wrInFinallCfile==true){
				RW.closeFile();
				RW.seekInfile($actualparitem.text.length()+1,",");
				RW.openFile("testC.c",true);
			}
            else{
				TmpRw.closeFile();
				TmpRw.seekInfile($actualparitem.text.length()+1,",");
				TmpRw.openFile("temp.c",true);
			}
        }
    }
    (','
    {
        if(wrInFinallCfile == true)RW.writeFile(",");
        else TmpRw.writeFile(",");
    }
    actualparitem {objectParam($actualparitem.text);})*
    |
;
actualparitem
    :expression
    |obj
    |ID
    {
        if(wrInFinallCfile == true)RW.writeFile($ID.text);
        else TmpRw.writeFile($ID.text);
    }
;
assignmentStat
    :(
        (
            ID
            {
                /*
                    Problem: In main george = Person(200223, 2002)
                    assignmentStat will see ID = george and will write it into file
                    But in C, we need to write two lines for that one line in python
                    Person george;
                    Person_init(&george, 200223, 2002);
                    Instead, store that ID, and use it either in expression or in callStat
                    In expression write the tempAssignment string as is
                    In callStat, write the two lines in C format, for the declaration and the
                    initialization
                */
                 tempAssignment =("\t".repeat(tabCounter)+$ID.text+" = ");
            }
        )
        |obj{
			if(klironomikotita == true){
				if(counterFileds-1 > classesFieldsMap.get(klironomikotitaName).size()){
					if (wrInFinallCfile == true)RW.writeFile(" = ");
					// Also store the equal sign. Will remove it later if in callStat
					else TmpRw.writeFile(" = ");
				}
				else dontWriteInheritanceData = true;
            }
			else
			{
				if (wrInFinallCfile == true)RW.writeFile(" = ");
				// Also store the equal sign. Will remove it later if in callStat
				else TmpRw.writeFile(" = ");
			}
		}
    )
    // expression or callStat for e.g.  george = Person(200223, 2002)
    '=' {assignFlag = true;}(callStat | expression){dontWriteInheritanceData = false;assignFlag = false;}
    {
		if(klironomikotita == true){
			if(counterFileds-1 > classesFieldsMap.get(klironomikotitaName).size()){
				if (wrInFinallCfile == true) RW.writeFile(";\n");
				else TmpRw.writeFile(";\n");
			}
		}
		else
		{
			if (wrInFinallCfile == true) RW.writeFile(";\n");
			else TmpRw.writeFile(";\n");
		}
    }
;
// Two option, one with parentheses and one without
// because python accepts both
ifStat
    :'if'
        {
            line = myReader.nextLine();
            int temp = ReturnTotalNumberOftabs(line) ;
            if(temp != -1 && temp!=tabCounter+1)
            {
                System.out.println("Check your tabs near line: "+line);
                System.exit(0);
            }
            // Need to set elseFlag false for each if
            elseFlag = false;
            if(wrInFinallCfile==true)RW.writeFile("\t".repeat(tabCounter)+"if (");
            else TmpRw.writeFile("\t".repeat(tabCounter)+"if (");
			rmTabsCallstat = true;
        }
    condition':'
    {
		rmTabsCallstat = false;
        tabCounter +=1;
        if(wrInFinallCfile==true)RW.writeFile("){\n");
        else TmpRw.writeFile("){\n");
    }
        statements
    {
        tabCounter -=1;
        if(wrInFinallCfile==true)RW.writeFile("\t".repeat(tabCounter)+"}\n");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
    }
    elsepart
    |'if' '('
    {
        line = myReader.nextLine();
        int temp = ReturnTotalNumberOftabs(line) ;
        if(temp != -1 && temp!=tabCounter+1)
        {
            System.out.println("Check your tabs near line: "+line);
            System.exit(0);
        }
        elseFlag = false;
        if(wrInFinallCfile==true)RW.writeFile("\t".repeat(tabCounter)+"if (");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"if (");
		rmTabsCallstat = true;
    }
    condition')'':'
    {
		rmTabsCallstat = false;
        tabCounter +=1;
        if(wrInFinallCfile==true)RW.writeFile("){\n");
        else TmpRw.writeFile("){\n");
    }
    statements
    {
        tabCounter -=1;
        if(wrInFinallCfile==true)RW.writeFile("\t".repeat(tabCounter)+"}\n");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
    }
    elsepart
;
elsepart
    :'else'':'
    {
        line = myReader.nextLine();
        int temp = ReturnTotalNumberOftabs(line) ;
        if(temp != -1 && temp!=tabCounter+1)
        {
            System.out.println("Check your tabs near line: "+line);
            System.exit(0);
        }
        if(wrInFinallCfile==true)RW.writeFile("\t".repeat(tabCounter)+"else {\n");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"else {\n");
        // Need this flag here to add return 0 at C when else doesn't exist
        elseFlag = true;
        tabCounter+=1;
    }
    statements
    {
        tabCounter-=1;
        if(wrInFinallCfile==true)RW.writeFile("}\n");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
    }
    |
;
whileStat
    :'while'
    {
            if(wrInFinallCfile==true)RW.writeFile("\t".repeat(tabCounter)+"while (");
            else TmpRw.writeFile("\t".repeat(tabCounter)+"while (");
			rmTabsCallstat = true;
    }
    '(' condition ')' ':'
    {
		rmTabsCallstat = false;
        tabCounter +=1;
        if(wrInFinallCfile==true)RW.writeFile("){\n");
        else TmpRw.writeFile("){\n");
    }
    statements
    {
        tabCounter -=1;
        if(wrInFinallCfile==true)RW.writeFile("\t".repeat(tabCounter)+"}\n");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
    }
    |'while'
    {
        if(wrInFinallCfile==true)RW.writeFile("\t".repeat(tabCounter)+"while (");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"while (");
		rmTabsCallstat = true;
    }
    condition ':'
    {
		rmTabsCallstat = false;
        tabCounter +=1;
        if(wrInFinallCfile==true)RW.writeFile("){\n");
        else TmpRw.writeFile("){\n");
    }
    statements
    {
        tabCounter -=1;
        if(wrInFinallCfile==true)RW.writeFile("\t".repeat(tabCounter)+"}\n");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
    }
;
printStat
    :'print'
    {
        if(wrInFinallCfile==true)RW.writeFile("\t".repeat(tabCounter)+"printf (");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"printf (");
		rmTabsCallstat = true;
    }
    '(' expression')'
    {
		rmTabsCallstat = false;
        if(wrInFinallCfile==true)RW.writeFile(");\n");
        else TmpRw.writeFile(");\n");
    }
;
returnStat
    : 'return '
        {
            if(wrInFinallCfile==true)RW.writeFile("\t".repeat(tabCounter)+"return ");
            else {
                TmpRw.writeFile("\t".repeat(tabCounter)+"return ");
            }
			rmTabsCallstat = true;
        }
        expression
        {
			rmTabsCallstat = false;
            if(wrInFinallCfile==true)RW.writeFile(";\n");
            else TmpRw.writeFile(";\n");
            returnFlag = 1;
        }
    |'return ''('
    {
        if(wrInFinallCfile==true)RW.writeFile("\t".repeat(tabCounter)+"return (");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"return (");
    }
    expression ')'
        {
            if(wrInFinallCfile==true)RW.writeFile(");\n");
            else TmpRw.writeFile(");\n");
            returnFlag = 1;
        }
;
callStat
    :obj |
    (ID
    {
		checkIdForParmObj = $ID.text;
		if(dontWriteInheritanceData ==false ){
			if(assignFlag == true){
				/*
					Only keep the tabs and the name of the ID, without the "="
					Write in file: Person george
					The declaration of the object george of type Person
				*/
				String[]temp = tempAssignment.split(" =");
				if(!(objectPointsClassNameMap.containsKey($ID.text))){
					objectPointsClassNameMap.put($ID.text,new ArrayList<>());
				}
				objectPointsClassNameMap.get($ID.text).add(temp[0].trim());
				if(wrInFinallCfile==true){
					RW.writeFile("\t".repeat(tabCounter)+$ID.text+temp[0]+";\n");
					RW.writeFile("\t".repeat(tabCounter)+$ID.text+"_init");
				}
				else {
					TmpRw.writeFile("\t".repeat(tabCounter)+$ID.text+temp[0]+";\n");
					TmpRw.writeFile("\t".repeat(tabCounter)+$ID.text+"_init");
					}
			}
			else{
				if(wrInFinallCfile==true){
					if(rmTabsCallstat == true)RW.writeFile($ID.text);
					else RW.writeFile("\t".repeat(tabCounter)+$ID.text);
				}
				else {
					if(rmTabsCallstat == true)TmpRw.writeFile($ID.text);
					else TmpRw.writeFile("\t".repeat(tabCounter)+$ID.text);
				}
			}
		}
    })
    /*
        Problem: Need to write the parameter e.g. &george before all other parameters
        Easy to write it by hand, but hard to add the comment
        Since the &george can be the only parameter, the comma shouldn't be written
        In actualparlist, commas are identified in python and written in c file
        through the grammar.
        In our case, the $george, will be added by hand, in a java action, so the grammar
        won't do it.
        Solution: TODO fix the comma
    */
    '('
    {
		if(dontWriteInheritanceData == false){
			if(wrInFinallCfile == true)RW.writeFile("(");
			else TmpRw.writeFile("(");
			if(assignFlag == true){
				String[]temp = tempAssignment.split(" =");
				if(wrInFinallCfile==true){
					//to keno meta to trim to exoume gia na min mas trwei ton xaraktira to seek pou kaname gia thn topothetisi tou komatos 
					RW.writeFile("&"+temp[0].trim()+" ");
				}
				else {
					TmpRw.writeFile("&"+temp[0].trim()+" ");
					}
			}
			else{
				if(wrInFinallCfile==true){
					RW.writeFile("&"+id+" ");
				}
				else {
					TmpRw.writeFile("&"+id+" ");
					}
			}
		}
    }
    actualparlist')'
    {
		if(dontWriteInheritanceData == false){
			if(wrInFinallCfile == true){
				RW.writeFile(")");
				if (assignFlag == false){
					if(wrInFinallCfile == true)RW.writeFile(";");
					else TmpRw.writeFile(";");
					assignFlag = false;
				}
			}
			else {
				TmpRw.writeFile(")");			
			}
		}
		lineNumberOfstrucktParam = 1;
    }
;
condition
    :boolterm
    ('or'
    {
        if(wrInFinallCfile==true)RW.writeFile(" or ");
        else TmpRw.writeFile(" or ");
    }
    boolterm)*
;
boolterm
    :boolfactor
    ('and'
    {
        if(wrInFinallCfile==true)RW.writeFile(" and ");
        else TmpRw.writeFile(" and ");
    }
    boolfactor)*
;
// Parentheses are mandatory here because of left-recursiveness error
boolfactor
    : 'not' '('
    {
        if(wrInFinallCfile==true)RW.writeFile(" not (");
        else TmpRw.writeFile(" not (");
    }
    condition ')'
    {
        if(wrInFinallCfile==true)RW.writeFile(")");
        else TmpRw.writeFile(")");        
    }
    | '('
    {
        if(wrInFinallCfile==true)RW.writeFile("(");
        else TmpRw.writeFile("(");        
    }
    condition ')'
    {
        if(wrInFinallCfile==true)RW.writeFile(")");
        else TmpRw.writeFile(")");        
    }
    | expression REL_OP
    {
        if(wrInFinallCfile==true)RW.writeFile($REL_OP.text);
        else TmpRw.writeFile($REL_OP.text);        
    }
    expression
;
obj
    :ID
        {
			id = $ID.text;
        }
    '.'ID  
		{
			if(dontWriteInheritanceData == false){
				if(wrInFinallCfile == true){
					if(klironomikotita == false){
						if (rmTabsCallstat == true)RW.writeFile(id+"->");
						else RW.writeFile("\t".repeat(tabCounter)+id+"->");
						RW.writeFile($ID.text);
					}
					else {
						if ((classesFieldsMap.get(klironomikotitaName)).contains($ID.text)){
							if((classesFieldsMap.get(klironomikotitaName)).size() == counterFileds){
								RW.writeFile(klironomikotitaName+"_init(("+klironomikotitaName+"*)");
								ArrayList<String> values = new ArrayList<String>();
								for (String value : classesFieldsMap.get(klironomikotitaName)){
									values.add(value);
								}
								RW.writeFile(String.join(", ", values)+");\n");
							}
						}
						else {
							RW.writeFile(id+"->");
							RW.writeFile($ID.text);
						}
						counterFileds+=1;
					}
				}
				else {
					if (rmTabsCallstat == true)TmpRw.writeFile(id+"->");
					else TmpRw.writeFile("\t".repeat(tabCounter)+id+"->");
					TmpRw.writeFile($ID.text);
				}
			}
        }
	|ID
        {
			if(dontWriteInheritanceData == false){
				id = $ID.text;
				if(wrInFinallCfile == true){
					for (String key : objectPointsClassNameMap.keySet()) {
						if(objectPointsClassNameMap.get(key).contains($ID.text)){
							if(rmTabsCallstat==false)RW.writeFile("\t".repeat(tabCounter)+key+"_");
							else RW.writeFile(key+"_");
						}
					}
				}
				else {
					for (String key : objectPointsClassNameMap.keySet()) {
						if(objectPointsClassNameMap.get(key).contains($ID.text)){
							if(rmTabsCallstat==false)TmpRw.writeFile("\t".repeat(tabCounter)+key+"_");
							else TmpRw.writeFile(key+"_");
						}
					}
				}
			}
        }
	'.'{rmTabsCallstat = true;}callStat{rmTabsCallstat = false;}
;
expression
    :optionalSign
    {
		if(dontWriteInheritanceData == false){
			if(wrInFinallCfile==true)RW.writeFile($optionalSign.text);
			else TmpRw.writeFile($optionalSign.text);
		}
    }
    term
    (ADD_OP
    {
		if(dontWriteInheritanceData == false){
			if(wrInFinallCfile==true)RW.writeFile($ADD_OP.text);
			else TmpRw.writeFile($ADD_OP.text); 
		}
    }
    term)*
;
term
    :factor (MUL_OP
    {
		if(dontWriteInheritanceData == false){
			if(wrInFinallCfile==true)RW.writeFile($MUL_OP.text);
			else TmpRw.writeFile($MUL_OP.text);
		}
    }
    factor)*
;
factor
    :INT
    {
		if(dontWriteInheritanceData == false){
			if(wrInFinallCfile==true)RW.writeFile($INT.text);
			else TmpRw.writeFile($INT.text);
			}
    }
    |ID
    {
		if(dontWriteInheritanceData == false){
			if(wrInFinallCfile==true)RW.writeFile($ID.text);
			else TmpRw.writeFile($ID.text);
			}
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