/*
In v3_x we are working on the output file in c
*/

grammar grammar_v3_2;
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
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;
}
@parser::members {

    // Change this to the directory where the output file will go
    String dirPath = "C:\\Users\\dimos\\OneDrive - ΠΑΝΕΠΙΣΤΗΜΙΟ ΙΩΑΝΝΙΝΩΝ\\School\\6th Year\\11th Semester\\Compilers 2\\Project\\v3 - Gen C File\\src\\";
    // Change this to the directory where your python input is
    String pythonInput = "pythonBasicInput.py";


    ArrayList <Scope> scopes_list = new ArrayList<Scope>();
    // List for storing class names
    ArrayList <String> classesList = new ArrayList <String>();
    AddEntity entity;
    WriteToFile RW;
    WriteToFile TmpRw;
    String tempNameClass,line,tempAssignment,inheritedClass,id,checkIdForParmObj,classNameForDowncasting;
    Boolean wrInFinalCFile,inheritance=false,elseFlag = true,rmTabsCallstat = false,dontWriteInheritanceData= false, assignFlag = false,callStatFlag=false;
    // Raise assignFlag in assignmentStat before callStat|expression and lower it after them
    int returnFlag,tabCounter = 0,counterForFields=2,lineCounter = 1,lineNumberOfstrucktParam=1;
    Scanner myReader;
	ArrayList<String> tempList,tempFuncName;

    // classesAndFunctionsMap contains the names of classes as keys and a list of their functions as values
	HashMap<String, ArrayList<String>>  classesAndFunctionsMap = new HashMap<String, ArrayList<String>>();

    // classesStructsAndLinesMap contains the names of classes as keys and a list of the lines where their struct begins and ends
	HashMap<String, ArrayList<Integer>> classesStructsAndLinesMap = new HashMap<String, ArrayList<Integer>>();

    // classesAndFieldsMap contains the names of classes as keys and a list of their fields as values
	HashMap<String, ArrayList<String>> classesAndFieldsMap = new HashMap<String, ArrayList<String>>();

    // classesAndObjectsmap contains the names of the classes as keys and a list of the objects of that type of class, as values
	HashMap<String, ArrayList<String>> classesAndObjectsMap = new HashMap<String, ArrayList<String>>();

    // childAndParentMap contains the names of the classes that inherent a class as keys and the names of the classes that get inherited, as values
	HashMap<String, String> childAndParentMap = new HashMap<String, String>();

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

    // Add new entity to scopes_list
    public class AddEntity{
        public void add_new_function(String name){
            Function fun = new Function(name);
            scopes_list.get(scopes_list.size()-1).getEntitiesList().add(fun);    
        }
        
        public void add_parameter(String param){
            
            //go to the last entity of the last scope and add the parameters
            FormalParameter objParam = new FormalParameter(param);
            ArrayList <Entity> entities_list = scopes_list.get(scopes_list.size()-1).getEntitiesList();

            // Important. Downcast the return object of the entities_list, because it stores Entity type objects
            Function fun = (Function) entities_list.get(entities_list.size()-1);
            checkUniqueParameter(objParam, fun);
        }

        public void add_variable(String name){
            Variable objVar = new Variable(name);
            int nesting_level = (scopes_list.get(scopes_list.size() - 1)).getNestingLevel();
            // Check if variable already exist
            for (Entity ent : scopes_list.get(nesting_level).getEntitiesList()){
                if(ent.getName() == name){
                    System.err.println("Error: Variable name '" + ent.getName() + "' already used");
                    System.exit(1);    

                }
                else scopes_list.get(scopes_list.size()-1).getEntitiesList().add(objVar);
            }
        }
        public void checkUniqueParameter(FormalParameter parameter, Function function){
            Boolean parameterIsNotUnique = false;
            for (FormalParameter param:function.formal_par_list){                
                if (param.getName().equals(parameter.getName())){
                    parameterIsNotUnique = true;
                    System.err.println("Error: Paremeter name '" + parameter + "' already used");
                    System.exit(1);    
                }
            }
            function.appendParToFormalParList(parameter);
        }
    }
    public class WriteToFile {
        private FileWriter myWriter;
		private String filename;

        public void openFile(String filename,boolean f) {
			this.filename = filename;
            try {
              myWriter = new FileWriter(dirPath+filename,f);
            } catch (IOException e) {
              System.out.println("Open file,an error occurred while opening the file.");
              e.printStackTrace();
            }
        }
        public void merge(String filename)
        {
            try {
                File temp = new File(dirPath+filename);
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
                System.out.println("An error occurred while mergin the file.");
                e.printStackTrace();
            }
        }
        public void writeFile(String str) {
            try {
                myWriter.write(str);
            }
            catch (IOException e) {
                System.out.println("An error occurred while writing to file.");
                e.printStackTrace();
            }
        }
		public void seekInfile(int leng,String s)
		{
			try (RandomAccessFile file = new RandomAccessFile(dirPath+this.filename, "rw")) {
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
                System.out.println("An error occurred while closing the file.");
                e.printStackTrace();
            }
        }

        public void deleteFile() {
            try {
                // Close the FileWriter before attempting to delete the file
                if (myWriter != null) {
                    myWriter.close();
                }

                // Create a File object and delete the file
                File fileToDelete = new File(dirPath + filename);
                if (!(fileToDelete.delete())) {
                    System.out.println("Failed to delete " + filename);
                }
            } catch (IOException e) {
                System.out.println("An error occurred while deleting the file.");
                e.printStackTrace();
            }
        }
    }

    // Given a line, it counts the number of tabs it has and returns their number.
    // It also skips all empty lines and newlines
    // Big mistake here, it always returns -1
    // public int returnTotalNumberOfTabs(String line){
    //     int total = 0;
    //     if (!(line.startsWith("class"))){
    //         while (myReader.hasNextLine()){
    //             // System.out.println("line at while ="+line);
    //             // Skip empty lines and newlines
    //             if (line.isEmpty() || line.trim().equals("") || line.trim().equals("\n")) {
    //                 line = myReader.nextLine();
    //             }
    //             else {  
    //                 // System.out.println("line at else ="+line);
    //                 // Big mistake here
    //                 return -1;
    //                 // break;
    //             }
    //         }
    //         // Count the tabs on that line
    //         // System.out.println("line at else ="+line);
    //         // System.out.println("line length ="+line.length());
    //         // This is bad, tabs are always at the beginning
    //         // why go through the whole line, char by char?
    //         for (int i = 0; i < line.length(); i++) {
    //             char ch = line.charAt(i);
    //             if (ch == ' ' || ch == '\t') {
    //                 total++;
    //             }
    //             else return total;
    //         }
    //     }
    //     return total;
    // }



    // Count tabs and return their number
    // Four spaces are equal to a tab
    // It's possible to accept a tab followed by four spaces (bad practise but still acceptable)
    // Return -1 if the spaces are less that four (incomplete tab)
    public int countLeadingWhitespace(String line) {

        while (line.trim().isEmpty()){
            line = myReader.nextLine();
        }
        
        // Now line is a non-empty line, process it
        int tabCount = 0;
        int consecutiveSpaces = 0;
        final int spacesPerTab = 4; // Number of spaces equivalent to one tab

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch == '\t') {
                tabCount++;
                consecutiveSpaces = 0;
            } else if (ch == ' ') {
                consecutiveSpaces++;
                if (consecutiveSpaces == spacesPerTab) {
                    tabCount++;
                    consecutiveSpaces = 0;
                }
            } else {
                break; // Stop counting once a non-whitespace character is encountered
            }
        }

        if (consecutiveSpaces > 0) {
            return -1; // Indentation error: incomplete tab
        }

        return tabCount; // Return the number of tabs
    }





	public String placeObject(StringBuilder content,BufferedReader reader,String line,String key,String str,String[] templine ){
		String templ="",str2 = "";
		for(int i=0;i<templine.length;i++){
			templ += templine[i];
			if(i<templine.length-1)templ +=", ";
			else if(i>0){
				str2+="\t"+"self->"+str+" = "+str+";";//we made this becuase we want to declare the obj in the function
			}
		}
		line = templ;
		content.append(line).append(System.lineSeparator());
		line = str2;	

		try{
			if(templine.length == 1){
                // We append every line in the file
				content.append(line).append(System.lineSeparator()); 
				line = reader.readLine();
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		return line;
	}
	public String outputPrintf(String line){
		if(line.contains("printf")){
			String[] printlist = line.split(",");
			String out="\"";
			for(int i=0;i<printlist.length;i++){
				if(printlist.length>1 && i<printlist.length-1)out+="%d, ";
				else if(printlist.length == 1 || i == printlist.length-1)out+="%d ";
			}
			out+="\\n\",";
			String[] tempprint = printlist[0].split("\\(");
			line = line.replace(tempprint[1],out+tempprint[1]);
		}
		return line;
	}
	public void doAlotOfThingsForParameters(String paraitem){
		// check if the parameter is not a number
		if(!(paraitem.matches("-?\\d+(\\.\\d+)?"))){
			//take all class names from hashmap to return their obj to check if parameter is an object or not 
			for (String key : classesAndObjectsMap.keySet()) {
				if(classesAndObjectsMap.get(key).contains(paraitem)){
					try {
						// Read the content of the file
						BufferedReader reader = new BufferedReader(new FileReader(dirPath+"outputFile.c"));
						StringBuilder content = new StringBuilder();
						String line;
						int currentLineNumber = 1;
						Boolean endStruc = false;
						String str="";
						HashMap<String, ArrayList<String>> structInfoMap = new HashMap<String, ArrayList<String>>();
						ArrayList<String> structlist = new  ArrayList<String>();
						Boolean fl = false,f=false;
						Set<String> keys = classesStructsAndLinesMap.keySet();
						List<String> keyList = List.copyOf(keys);
						Set<String> Classeskeys = classesAndFunctionsMap.keySet();
						List<String> ClasseskeysList = List.copyOf(keys);
						int step = keyList.size()-1;
						int paramCounter = 1;//not init
						while ((line = reader.readLine()) != null) 
						{
							if (classesStructsAndLinesMap != null && checkIdForParmObj != null)
							{
								if(currentLineNumber == classesStructsAndLinesMap.get(keyList.get(step)).get(1) && step>0){
									structInfoMap.put((line.replace("}","")).replace(";",""),structlist);
									fl = false;
									step-=1;
									structlist = new  ArrayList<String>();
								}
								if(fl == true){
									int len = line.split(" ").length-1;
									structlist.add(line.split(" ")[len].replace(";",""));	
								}
								if(line.contains("typedef struct{")){
									fl = true;
								}
								// we use this condition to check if we are in the proper struct 
								if (ClasseskeysList.contains(checkIdForParmObj) && currentLineNumber == classesStructsAndLinesMap.get(checkIdForParmObj).get(0) && lineNumberOfstrucktParam>0){
									//we use this loop to find and put the proper declaration into our variable 
									//actually with this loop we move our pointer into the proper line which is the lineNumberOfstrucktParam
									//which we have taken from main were the function was called 
									for(int i=0;i<lineNumberOfstrucktParam;i++){
										content.append(line).append(System.lineSeparator());//we append every line we dont need to change in the file 
										line = reader.readLine();// we hold the last line which we need to change
									}
									 // Modify the line with the replacement text
									line = "\t"+key+" *"+line.split("int")[1].trim();
									endStruc = true;
								}
								//we made this condition to place the proper object in parameters 
								else if(line.contains(checkIdForParmObj+"_init") && endStruc == true){
										String[] templine = line.split(",");
										str = templine[lineNumberOfstrucktParam].split("int")[1].trim();
										str = str.replace(") {","");
										templine[lineNumberOfstrucktParam]=key+" *"+templine[lineNumberOfstrucktParam].split("int")[1].trim();
										line = placeObject(content,reader,line,key, str,templine);
										endStruc = false;
										f = true; 
								}
								else if(line.split("_").length > 1 && line.contains(checkIdForParmObj+"_"+(((line.split("_"))[1]).split(" \\("))[0])){
									String[] templine = line.split(",");
									if(templine.length > 1 ){
										str = templine[paramCounter].split("int")[1].trim();
										str = str.replace(") {","");
										templine[paramCounter]=key+" *"+templine[paramCounter].split("int")[1].trim();
										line = placeObject(content,reader,line,key, str,templine);
									}
									else if(templine.length == 1){
										content.append(line).append(System.lineSeparator());//we append every line in the file
										line = reader.readLine();
									}
									f = true; 
									paramCounter++;
								}
								if(line.contains("}"))f=false;
							}
                            
                            // Check if there is the keyword "base", for inheritance
							if(!(structInfoMap.isEmpty()) && f == true){
								for(String parameter: structInfoMap.get(key)){
									if(line.contains(parameter))continue;
									else{
										String mamaClass = childAndParentMap.get(key);
										for(String mamaparameter:structInfoMap.get(mamaClass)){
											if(line.contains(mamaparameter))line = line.replace(mamaparameter,"base."+mamaparameter);
											else continue;
										}
									}
									break;
								}
							}
							content.append(line).append(System.lineSeparator());//we append every line in the file
							currentLineNumber++;
						}
						reader.close();
						// Write the modified content back to the file
						BufferedWriter writer = new BufferedWriter(new FileWriter(dirPath+"outputFile.c"));
						writer.write(content.toString());
						writer.close();
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
        File pyFile = new File(pythonInput);
        try{
            myReader = new Scanner(pyFile);
        }catch (IOException e) {
                System.out.println("An error occurred while reading the python input file.");
                e.printStackTrace();
            }
        RW = new WriteToFile();
        RW.openFile("outputFile.c",false);
        RW.writeFile("#include <stdio.h>\n");
    }class+  main
;
class
    // First rule for classes without inheritance
    : 'class' ID ':'
    {  
        // Check for already used class name
        String className = $ID.text;
        if (!classesList.contains(className)){
            classesList.add(className);
        }
        else if (classesList.contains(className)){
            System.err.println("Error: Class name '" + className + "' already used");
            System.exit(1);    
        }
        
        line = myReader.nextLine();

        // This temp will be 0 
        int temp = countLeadingWhitespace(line);


        // System.out.println("line in class ="+line);
        // System.out.println("tabCounter in class ="+tabCounter);
        // System.out.println("tabs in class ="+temp);
        // System.out.println("=======================================");


        if(temp!=tabCounter){
            System.err.println("IndentationError at line: "+line);
            System.exit(1);    
        }
        AddScope scope = new AddScope();
        scope.add_new_scope();
        entity = new AddEntity();
        tempNameClass = $ID.text;
        RW.writeFile("\ntypedef struct{ \n");
    }
    initFunction functions
    {
        scope.remove_scope();
    }  

    // Second rule for classes with inheritance
    |'class' ID{
        
        // Check for already used class name
        String className = $ID.text;
        if (!classesList.contains(className)){
            classesList.add(className);
        }
        else if (classesList.contains(className)){
            System.err.println("Error: Class name '" + className + "' already used");
            System.exit(1);    
        }

        line = myReader.nextLine();
        
        int temp = countLeadingWhitespace(line) ;
        
        // System.out.println("line in class ="+line);
        // System.out.println("tabCounter in class ="+tabCounter);
        // System.out.println("tabs in class ="+temp);
        // System.out.println("=======================================");

        //if(temp != -1 && temp!=tabCounter){
        if(temp!=tabCounter){
            System.out.println("Check your tabs in the begining of your class");
            System.exit(1);
        }
        tempNameClass = $ID.text;
    } '('ID { inheritedClass = $ID.text;}')' ':'
    {  
        childAndParentMap.put(tempNameClass,inheritedClass);
		inheritance = true;
        AddScope scope = new AddScope();
        scope.add_new_scope();
        RW.writeFile("\ntypedef struct{ \n");
    }
    initFunction  functions
    {
		inheritance = false;
        scope.remove_scope();
    }
;
main:
    'if' '__name__' '==' '\'__main__\'' ':'
    {
        line = myReader.nextLine();

        // This tabs will be 0 
        int tabs = countLeadingWhitespace(line);


        // System.out.println("line in main ="+line);
        // System.out.println("tabCounter in main ="+tabCounter);
        // System.out.println("tabs in main ="+tabs);
        // System.out.println("=======================================");


        if(tabs!=tabCounter){
            System.err.println("IndentationError at line: "+line);
            System.exit(1);    
        }



        //tabCounter+=1;
        returnFlag = -1;
        TmpRw.openFile("tempCFile.c",false);      
        RW.writeFile("int main(){\n");
		RW.closeFile();
		File temp = new File(dirPath+"outputFile.c");
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
					classesStructsAndLinesMap.put((line.split("}")[1].trim()).split(";")[0],templ);
					structFlag = false;
				}
				lineCounter+=1;
			}
			myReader.close();
			RW.openFile("outputFile.c",true);
		}catch (IOException e) {
			e.printStackTrace();
		}
    }

    statements
    
    {
        TmpRw.closeFile();
        
        // Reset the return flag for the next function
        RW.merge("tempCFile.c");

        // Delete temp c file after merging with main output C file
        TmpRw.deleteFile();
        
        RW.writeFile("\treturn 0;\n");
        RW.writeFile("}\n");
        RW.closeFile();
		temp = new File(dirPath+"outputFile.c");
		StringBuilder content = new StringBuilder();
		try{
			Scanner myReader = new Scanner(temp);
			while (myReader.hasNextLine()) {
				String line = myReader.nextLine();
				if(!(line.contains("%d")))line = outputPrintf(line);
				content.append(line).append(System.lineSeparator());//we append every line in the file
			}
			myReader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(dirPath+"outputFile.c"));
			writer.write(content.toString());
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
    }
;
initFunction
    :'def''__init__'
    {
        tabCounter +=1;
        line = myReader.nextLine();
        
        //int temp = returnTotalNumberOfTabs(line) ;
        int temp = countLeadingWhitespace(line);

        // Big mistake here
        // temp is always -1 because of returnTotalNumberOfTabs
        // so this condition is always false
        // if(temp != -1 && temp!=tabCounter)

        if(temp!=tabCounter)
        {
            System.err.println("IndentationError at line: "+line);
            System.exit(1);
        }
        entity.add_new_function("__init__");
    }
    '('formalparlist')'':'
    {  
        AddScope scope = new AddScope();
        scope.add_new_scope();
        ArrayList <Entity> entities_list = scopes_list.get(scopes_list.size()-2).getEntitiesList();

        // Function fun is the last function in the entiies_list
        Function fun = (Function) entities_list.get(entities_list.size()-1);

        // Fill in the struct
		if(inheritance == true){
			RW.writeFile("\t".repeat(tabCounter)+inheritedClass+" base;\n");
		}
		tempList = new ArrayList<String>();
        
        for(int i=0;i<fun.getFormalParList().size();i++){
			tempList.add(fun.getFormalParList().get(i).getName());
			classesAndFieldsMap.put(tempNameClass,tempList);
			if(i>0 && inheritance == true){
				if (!((classesAndFieldsMap.get(inheritedClass)).contains(fun.getFormalParList().get(i).getName()))){
					RW.writeFile("\t".repeat(tabCounter)+"int "+fun.getFormalParList().get(i).getName()+";\n");
				}
			}
            else if(i>0 && inheritance == false) RW.writeFile("\t".repeat(tabCounter)+"int "+fun.getFormalParList().get(i).getName()+";\n");
        }
        RW.writeFile("}"+tempNameClass+";\n");
        //for the parameters
        for(int i=0;i<fun.getFormalParList().size();i++){
            if(i==0)RW.writeFile("void "+tempNameClass+"_init ("+tempNameClass+" *"+fun.getFormalParList().get(i).getName());
            else if(i>0)RW.writeFile(",int "+fun.getFormalParList().get(i).getName());
        }
        RW.writeFile(") {\n");
        wrInFinalCFile = true;
		counterForFields =2;
    }
    statements
    {
        wrInFinalCFile = false;
        RW.writeFile("\n}\n");
        scope.remove_scope();
        tabCounter -=1;
    }
;
functions
    :{tempFuncName = new ArrayList<String>();}function ( function)*
    |
;
function
    :'def' ID
    {
		tempFuncName.add($ID.text);
		classesAndFunctionsMap.put(tempNameClass,tempFuncName);
        tabCounter +=1;

        line = myReader.nextLine();


        int temp = countLeadingWhitespace(line) ;

        // if(temp != -1 && temp!=tabCounter)
        if(temp!=tabCounter){
            System.out.println("Check your tabs near line: "+line);
            System.exit(1);
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
        TmpRw.openFile("tempCFile.c",false);      
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
        // TODO fix this return
        // c needs return 0 always, no matter if there is an else
        if (elseFlag == false){
            TmpRw.writeFile("\t".repeat(tabCounter)+"return 0;\n");
            elseFlag = true;
        }
        TmpRw.writeFile("\n}\n");
        TmpRw.closeFile();
        // Reset the return flag for the next function
        RW.merge("tempCFile.c");
        returnFlag = 0;
        scope.remove_scope();
        tabCounter -=1;
    }
;
statements
    :{tabCounter += 1;}
    (
        {

            line = myReader.nextLine();
            

            int temp = countLeadingWhitespace(line);

            // System.out.println("line in statements ="+line);
            // System.out.println("tabCounter at statements ="+tabCounter);
            // System.out.println("tabs at statements ="+temp);
            // System.out.println("=======================================");

            // if(temp != -1 && temp!=tabCounter+1)
            if(temp!=tabCounter){
                System.out.println("Check your tabs near line: "+line);
                System.exit(1);
            }
        }
        statement
    )+
    {tabCounter -= 1;}
    |{tabCounter -= 1;}
;
statement
    :
    // {

    //     line = myReader.nextLine();
        
    //     int temp = countLeadingWhitespace(line) ;

    //     // if(temp != -1 && temp!=tabCounter+1)
    //     if(temp!=tabCounter){
    //         System.out.println("Check your tabs near line: "+line);
    //         System.exit(1);
    //     }
    // }
    assignmentStat

    |ifStat
    |whileStat
    |printStat
    // {
    //     line = myReader.nextLine();


    //     int temp = countLeadingWhitespace(line) ;
    //     // if(temp != -1 && temp!=tabCounter+1)
    //     if(temp!=tabCounter){
    //         System.out.println("Check your tabs near line: "+line);
    //         System.exit(1);
    //     }
    // }
    |returnStat
    // {
    //     line = myReader.nextLine();
    //     int temp = countLeadingWhitespace(line) ;
    //     // if(temp != -1 && temp!=tabCounter+1)
    //     if(temp!=tabCounter){
    //         System.out.println("Check your tabs near line: "+line);
    //         System.exit(1);
    //     }
    // }
    |{callStatFlag = true;}callStat
    // {
    //     line = myReader.nextLine();
    //     int temp = countLeadingWhitespace(line) ;
    //     // if(temp != -1 && temp!=tabCounter+1)
    //     if(temp!=tabCounter){
    //         System.out.println("Check your tabs near line: "+line);
    //         System.exit(1);
    //     }
    // }
    | 'pass'
;
/*
A list of formal parameters
eg. def foo(x)
the x would be a formal parameter item
*/
formalparlist
    :
    formalparitem (','formalparitem)*
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
        if(!($actualparitem.text.isEmpty())){
			doAlotOfThingsForParameters($actualparitem.text);
            if(wrInFinalCFile==true){
				RW.closeFile();
				RW.seekInfile($actualparitem.text.length()+2,",");
				RW.openFile("outputFile.c",true);
			}
            else{
				TmpRw.closeFile();
				TmpRw.seekInfile($actualparitem.text.length()+2,",");
				TmpRw.openFile("tempCFile.c",true);
			}
        }
    }
    (','
    {
        if(wrInFinalCFile == true)RW.writeFile(",");
        else TmpRw.writeFile(",");
    }
    actualparitem {doAlotOfThingsForParameters($actualparitem.text);})*
    |
;
actualparitem
    :expression
    |obj
    |ID
    {
        if(wrInFinalCFile == true)RW.writeFile($ID.text+" ");
        else TmpRw.writeFile($ID.text+" ");
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
                // TODO fix x=5 in main
                //TmpRw.writeFile("\t".repeat(tabCounter)+$ID.text+" = ");

            }
        )
        |obj{
			if(inheritance == true){
				if(counterForFields-1 > classesAndFieldsMap.get(inheritedClass).size()){
					if (wrInFinalCFile == true)RW.writeFile(" = ");
					// Also store the equal sign. Will remove it later if in callStat
					else TmpRw.writeFile(" = ");
				}
				else dontWriteInheritanceData = true;
            }
			else
			{
				if (wrInFinalCFile == true)RW.writeFile(" = ");
				// Also store the equal sign. Will remove it later if in callStat
				else TmpRw.writeFile(" = ");
			}
		}
    )
    // expression or callStat for e.g.  george = Person(200223, 2002)
    '=' {assignFlag = true;}(callStat | expression){dontWriteInheritanceData = false;assignFlag = false;}
    {
		if(inheritance == true){
			if(counterForFields-1 > classesAndFieldsMap.get(inheritedClass).size()){
				if (wrInFinalCFile == true) RW.writeFile(";\n");
				else TmpRw.writeFile(";\n");
			}
		}
		else
		{
			if (wrInFinalCFile == true) RW.writeFile(";\n");
			else TmpRw.writeFile(";\n");
		}
    }
;
// Two option, one with parentheses and one without
// because python accepts both
ifStat
    :'if'
        {
            // line = myReader.nextLine();
            // int temp = countLeadingWhitespace(line) ;
            // // if(temp != -1 && temp!=tabCounter+1)
            // if(temp!=tabCounter){
            //     System.out.println("Check your tabs near line: "+line);
            //     System.exit(1);
            // }

            // Need to set elseFlag false for each if
            elseFlag = false;
            if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"if (");
            else TmpRw.writeFile("\t".repeat(tabCounter)+"if (");
			rmTabsCallstat = true;
        }
    condition':'
    {
		rmTabsCallstat = false;

        // tabCounter +=1;

        if(wrInFinalCFile==true)RW.writeFile("){\n");
        else TmpRw.writeFile("){\n");
    }
        statements
    {

        // tabCounter -=1;
        if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"}\n");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
    }
    elsepart
    |'if' '('
    {
        // line = myReader.nextLine();
        // int temp = countLeadingWhitespace(line) ;
        // // if(temp != -1 && temp!=tabCounter+1)
        // if(temp!=tabCounter){
        //     System.out.println("Check your tabs near line: "+line);
        //     System.exit(1);
        // }

        elseFlag = false;
        if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"if (");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"if (");
		rmTabsCallstat = true;
    }
    condition')'':'
    {
		rmTabsCallstat = false;
        //tabCounter +=1;
        if(wrInFinalCFile==true)RW.writeFile("){\n");
        else TmpRw.writeFile("){\n");
    }
    statements
    {
        //tabCounter -=1;
        if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"}\n");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
    }
    elsepart
;
elsepart
    :'else'':'
    {
        line = myReader.nextLine();
        int temp = countLeadingWhitespace(line) ;

        // if(temp != -1 && temp!=tabCounter+1)
        if(temp!=tabCounter){
            System.out.println("Check your tabs near line: "+line);
            System.exit(1);
        }

        if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"else {\n");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"else {\n");

        // Need this flag here to add return 0 at C when else doesn't exist
        elseFlag = true;
        //tabCounter+=1;
    }
    statements
    {
        //tabCounter-=1;
        if(wrInFinalCFile==true)RW.writeFile("}\n");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
    }
    |
;
whileStat
    :'while'
    {
            if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"while (");
            else TmpRw.writeFile("\t".repeat(tabCounter)+"while (");
			rmTabsCallstat = true;
    }
    '(' condition ')' ':'
    {
		rmTabsCallstat = false;
        //tabCounter +=1;
        if(wrInFinalCFile==true)RW.writeFile("){\n");
        else TmpRw.writeFile("){\n");
    }
    statements
    {
        //tabCounter -=1;
        if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"}\n");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
    }
    |'while'
    {
        if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"while (");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"while (");
		rmTabsCallstat = true;
    }
    condition ':'
    {
		rmTabsCallstat = false;
        //tabCounter +=1;
        if(wrInFinalCFile==true)RW.writeFile("){\n");
        else TmpRw.writeFile("){\n");
    }
    statements
    {
        //tabCounter -=1;
        if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"}\n");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
    }
;
printStat
    :'print'
    {
        if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"printf (");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"printf (");
		rmTabsCallstat = true;
    }
    '(' expression(
	','
	{
		if(wrInFinalCFile==true)RW.writeFile(",");
        else TmpRw.writeFile(",");
	}expression)*')'
    {
		rmTabsCallstat = false;
        if(wrInFinalCFile==true)RW.writeFile(");\n");
        else TmpRw.writeFile(");\n");
    }
;
returnStat
    : 'return '
        {
            if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"return ");
            else {
                TmpRw.writeFile("\t".repeat(tabCounter)+"return ");
            }
			rmTabsCallstat = true;
        }
        expression
        {
			rmTabsCallstat = false;
            if(wrInFinalCFile==true)RW.writeFile(";\n");
            else TmpRw.writeFile(";\n");
            returnFlag = 1;
        }
    |'return ''('
    {
        if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"return (");
        else TmpRw.writeFile("\t".repeat(tabCounter)+"return (");
    }
    expression ')'
        {
            if(wrInFinalCFile==true)RW.writeFile(");\n");
            else TmpRw.writeFile(");\n");
            returnFlag = 1;
        }
;

// This rule is called whenever a function is called in python
callStat
    :obj |
    (ID
    {
		checkIdForParmObj = $ID.text;
		if(dontWriteInheritanceData ==false ){
			if(assignFlag == true){
				/*
					Only keep the tabs and the name of the ID, without the "="
					Write in C file: "Person george" when you see "george = Person (...)"
					The declaration of the object george of type Person
				*/
				String[]temp = tempAssignment.split(" =");
				if(!(classesAndObjectsMap.containsKey($ID.text))){
					classesAndObjectsMap.put($ID.text,new ArrayList<>());
				}

                // Store "george" in the list of values for the proper class
				classesAndObjectsMap.get($ID.text).add(temp[0].trim());
				if(wrInFinalCFile==true){
					RW.writeFile("\t".repeat(tabCounter)+$ID.text+temp[0]+";\n");
					RW.writeFile("\t".repeat(tabCounter)+$ID.text+"_init");
				}
				else {
					TmpRw.writeFile("\t".repeat(tabCounter)+$ID.text+temp[0]+";\n");
					TmpRw.writeFile("\t".repeat(tabCounter)+$ID.text+"_init");
					}
			}
			else{
				for(String className: classesAndObjectsMap.keySet()){
                    // Check what type of class is the object id
					if(classesAndObjectsMap.get(className).contains(id)){
                        
                        // Check what class is the function from
                        if(classesAndFunctionsMap.get(className).contains($ID.text)){
                            // Set this to not do downcasting, since the function is in this class
                            classNameForDowncasting = className;
                            if(wrInFinalCFile==true){
                                if(rmTabsCallstat == true)RW.writeFile(className+"_"+$ID.text);
                                else RW.writeFile("\t".repeat(tabCounter)+className+"_"+$ID.text);
                            }
                            else {
                                if(rmTabsCallstat == true)TmpRw.writeFile(className+"_"+$ID.text);
                                else TmpRw.writeFile("\t".repeat(tabCounter)+className+"_"+$ID.text);
                            }
                            break;
                        }
                        
                        // This is where downcasting is needed for when a parent class calls a function of a child class on an
                        // object that has the parent class type
                        else {
                            for(String className2: classesAndFunctionsMap.keySet()){
                                if(classesAndFunctionsMap.get(className2).contains($ID.text)){
                                    classNameForDowncasting = className2;
                                    if(wrInFinalCFile==true){
                                        if(rmTabsCallstat == true)RW.writeFile(className2+"_"+$ID.text);
                                        else RW.writeFile("\t".repeat(tabCounter)+className2+"_"+$ID.text);
                                    }
                                    else {
                                        if(rmTabsCallstat == true)TmpRw.writeFile(className2+"_"+$ID.text);
                                        else TmpRw.writeFile("\t".repeat(tabCounter)+className2+"_"+$ID.text);
                                    }
                                    break;
                                }
                            }
                        }
					}
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
        Solution: TODO explanation
    */
    '('
    {
		if(dontWriteInheritanceData == false){
			if(wrInFinalCFile == true)RW.writeFile("(");
			else TmpRw.writeFile("(");
			if(assignFlag == true){
				String[]temp = tempAssignment.split(" =");
				if(wrInFinalCFile==true){
					//to keno meta to trim to exoume gia na min mas trwei ton xaraktira to seek pou kaname gia thn topothetisi tou komatos 
					RW.writeFile("&"+temp[0].trim()+"  ");
				}
				else {
					TmpRw.writeFile("&"+temp[0].trim()+"  ");
					}
			}
			else{
				for(String key:classesAndObjectsMap.keySet()){
					if(classesAndObjectsMap.get(key).contains(id)&& !(classNameForDowncasting.equals(key))){
						if(wrInFinalCFile==true){
							RW.writeFile("("+classNameForDowncasting+" *)&"+id+"  ");
						}
						else {
							TmpRw.writeFile("("+classNameForDowncasting+" *)&"+id+"  ");
						}
						break;
					}
					else{
						if(wrInFinalCFile==true){
							RW.writeFile("&"+id+"  ");
						}
						else {
							TmpRw.writeFile("&"+id+"  ");
						}
						break;
					}
				}
			}
		}
    }
    actualparlist')'
    {
		if(dontWriteInheritanceData == false){
			if(wrInFinalCFile == true){
				RW.writeFile(")");
				if (assignFlag == false){
					if(wrInFinalCFile == true)RW.writeFile(";");
					else TmpRw.writeFile(";");
					assignFlag = false;
				}
			}
			else if(wrInFinalCFile == false && callStatFlag==true ) {
				TmpRw.writeFile(");\n");
				callStatFlag = false;
			}
			else TmpRw.writeFile(")");		
		}
		lineNumberOfstrucktParam = 1;
    }
;
condition
    :boolterm
    ('or'
    {
        if(wrInFinalCFile==true)RW.writeFile(" or ");
        else TmpRw.writeFile(" or ");
    }
    boolterm)*
;
boolterm
    :boolfactor
    ('and'
    {
        if(wrInFinalCFile==true)RW.writeFile(" and ");
        else TmpRw.writeFile(" and ");
    }
    boolfactor)*
;
// Parentheses are mandatory here because of left-recursiveness error
boolfactor
    : 'not' '('
    {
        if(wrInFinalCFile==true)RW.writeFile(" not (");
        else TmpRw.writeFile(" not (");
    }
    condition ')'
    {
        if(wrInFinalCFile==true)RW.writeFile(")");
        else TmpRw.writeFile(")");        
    }
    | '('
    {
        if(wrInFinalCFile==true)RW.writeFile("(");
        else TmpRw.writeFile("(");        
    }
    condition ')'
    {
        if(wrInFinalCFile==true)RW.writeFile(")");
        else TmpRw.writeFile(")");        
    }
    | expression REL_OP
    {
        if(wrInFinalCFile==true)RW.writeFile($REL_OP.text);
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
            // If there is an inheritance of data, then check if the class has inheritance
			if(dontWriteInheritanceData == false){
				if(wrInFinalCFile == true){
                    // For init functions that don't inherent
					if(inheritance == false){
						if (rmTabsCallstat == true)RW.writeFile("self->"+id+"->");
						else RW.writeFile("\t".repeat(tabCounter)+id+"->");
						RW.writeFile($ID.text);
					}
					else {
                        // Check if every init function has inherited fields
						if ((classesAndFieldsMap.get(inheritedClass)).contains($ID.text)){
							if((classesAndFieldsMap.get(inheritedClass)).size() == counterForFields){
								RW.writeFile("\t".repeat(tabCounter)+inheritedClass+"_init(("+inheritedClass+"*)");
								ArrayList<String> values = new ArrayList<String>();
								for (String value : classesAndFieldsMap.get(inheritedClass)){
									values.add(value);
								}
								RW.writeFile(String.join(", ", values)+");\n");
							}
						}
						else {
							RW.writeFile("\t".repeat(tabCounter)+id+"->");
							RW.writeFile($ID.text);
						}
						counterForFields+=1;
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
			}
        }
	'.'{rmTabsCallstat = true;}callStat{rmTabsCallstat = false;}
;
expression
    :optionalSign
    {
		if(dontWriteInheritanceData == false){
			if(wrInFinalCFile==true)RW.writeFile($optionalSign.text);
			else TmpRw.writeFile($optionalSign.text);
		}
    }
    term
    (ADD_OP
    {
		if(dontWriteInheritanceData == false){
			if(wrInFinalCFile==true)RW.writeFile($ADD_OP.text);
			else TmpRw.writeFile($ADD_OP.text); 
		}
    }
    term)*
;
term
    :factor (MUL_OP
    {
		if(dontWriteInheritanceData == false){
			if(wrInFinalCFile==true)RW.writeFile($MUL_OP.text);
			else TmpRw.writeFile($MUL_OP.text);
		}
    }
    factor)*
;
factor
    :INT
    {
		if(dontWriteInheritanceData == false){
			if(wrInFinalCFile==true)RW.writeFile($INT.text);
			else TmpRw.writeFile($INT.text);
			}
    }
    |ID
    {
		if(dontWriteInheritanceData == false){
			Boolean flag = false;
			if(wrInFinalCFile==true){
				for(String key:classesAndObjectsMap.keySet()){
					if(classesAndObjectsMap.get(key).contains($ID.text)){
						flag =true;
						break;
					}
				}
				if(flag == true)RW.writeFile(" &"+$ID.text);
				else RW.writeFile($ID.text);
			}
			else {
				for(String key:classesAndObjectsMap.keySet()){
					if(classesAndObjectsMap.get(key).contains($ID.text)){
						flag =true;
						break;
					}
				}
				if(flag == true)TmpRw.writeFile(" &"+$ID.text);
				else TmpRw.writeFile($ID.text);
			}
		}
    }
    |obj
    |'('expression')'
;
optionalSign
    :ADD_OP
    |
;
ID: [a-zA-Z_]+ [a-zA-Z0-9_]*;
INT: [0-9]+ ([0-9]+)?;
REL_OP: '=='|'<='|'>='|'!='|'<'|'>';
ADD_OP: '+'|'-';
MUL_OP: '*'|'/';
BLOCK_COMMENT           : ('\'\'\'' .*? '\'\'\'' | '"""' .*? '"""') ->channel(HIDDEN);
// match any line that starts with # and consumes all characters until the end of the line (~[\r\n]*).
COMMENT                 : '#' ~[\r\n]* -> channel(HIDDEN);
WS: [ \r\n\t]+ -> skip;