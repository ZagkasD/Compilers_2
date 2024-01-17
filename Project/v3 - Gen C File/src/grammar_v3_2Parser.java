// Generated from grammar_v3_2.g4 by ANTLR 4.13.1

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

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class grammar_v3_2Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, NEWLINE=22, ID=23, INT=24, REL_OP=25, 
		ADD_OP=26, MUL_OP=27, BLOCK_COMMENT=28, COMMENT=29, WS=30;
	public static final int
		RULE_prog = 0, RULE_classes = 1, RULE_class = 2, RULE_main = 3, RULE_initFunction = 4, 
		RULE_functions = 5, RULE_function = 6, RULE_statements = 7, RULE_statement = 8, 
		RULE_formalparlist = 9, RULE_formalparitem = 10, RULE_actualparlist = 11, 
		RULE_actualparitem = 12, RULE_assignmentStat = 13, RULE_ifStat = 14, RULE_elsepart = 15, 
		RULE_whileStat = 16, RULE_printStat = 17, RULE_returnStat = 18, RULE_callStat = 19, 
		RULE_condition = 20, RULE_boolterm = 21, RULE_boolfactor = 22, RULE_obj = 23, 
		RULE_expression = 24, RULE_term = 25, RULE_factor = 26, RULE_optionalSign = 27, 
		RULE_point = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "classes", "class", "main", "initFunction", "functions", "function", 
			"statements", "statement", "formalparlist", "formalparitem", "actualparlist", 
			"actualparitem", "assignmentStat", "ifStat", "elsepart", "whileStat", 
			"printStat", "returnStat", "callStat", "condition", "boolterm", "boolfactor", 
			"obj", "expression", "term", "factor", "optionalSign", "point"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "':'", "'('", "')'", "'if'", "'__name__'", "'=='", "''__main__''", 
			"'def'", "'__init__'", "'pass'", "','", "'='", "'else'", "'while'", "'print'", 
			"'return '", "'or'", "'and'", "'not'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "NEWLINE", 
			"ID", "INT", "REL_OP", "ADD_OP", "MUL_OP", "BLOCK_COMMENT", "COMMENT", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "grammar_v3_2.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	    // Change this to the directory where the output file will go
	    String dirPath = "C:\\Users\\dimos\\OneDrive - ΠΑΝΕΠΙΣΤΗΜΙΟ ΙΩΑΝΝΙΝΩΝ\\School\\6th Year\\11th Semester\\Compilers 2\\Project\\v3 - Gen C File\\src\\";
	    // Change this to the directory where your python input is
	    String pythonInput = "pythonBasicInput.py";


	    ArrayList <Scope> scopes_list = new ArrayList<Scope>();
	    // List for storing class names
	    ArrayList <String> classesList = new ArrayList <String>();
	    addEntity entity;
	    WriteToFile RW;
	    WriteToFile TmpRw;
	    String tempNameClass,line,tempAssignment,klironomikotitaName,id,checkIdForParmObj,classNameForDowncasting;
	    Boolean wrInFinalCFile,klironomikotita=false,elseFlag = true,rmTabsCallstat = false,dontWriteInheritanceData= false, assignFlag = false,callStatFlag=false;
	    // Raise assignFlag in assignmentStat before callStat|expression and lower it after them
	    int returnFlag,tabCounter = 0,counterFileds=2,lineCounter = 1,lineNumberOfstrucktParam=1;
	    File pyFile;
	    Scanner myReader;
		ArrayList<String> tempList,tempFuncName;
		HashMap<String, ArrayList<String>>  classesAndFunctions= new HashMap<String, ArrayList<String>>();
		HashMap<String, ArrayList<Integer>> lineOfClassStruct = new HashMap<String, ArrayList<Integer>>();
		HashMap<String, ArrayList<String>> classesFieldsMap = new HashMap<String, ArrayList<String>>();
		HashMap<String, ArrayList<String>> objectPointsClassNameMap = new HashMap<String, ArrayList<String>>();
		HashMap<String, String> childAndParent = new HashMap<String, String>();

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
	            FormalParameter objParam = new FormalParameter(param);
	            ArrayList <Entity> entities_list = scopes_list.get(scopes_list.size()-1).getEntitiesList();
	            // Important. Downcast the return object of the entities_list, because it stores Entity type objects
	            Function fun = (Function) entities_list.get(entities_list.size()-1);
	            checkUniqueParameter(objParam, fun);
	        }
	        public void add_variable(String name){
	            Variable objVar = new Variable(name);
	            int nesting_level = (scopes_list.get(scopes_list.size() - 1)).getNestingLevel();
	            // Check for variable that already exist
	            for (Entity ent : scopes_list.get(nesting_level).getEntitiesList()){
	                if(ent.getName() == name){
	                    // TODO fix this
	                    System.out.println("Error, bro same name wtf!!!");
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
			//we use this condition to make sure the declarationof the objects in the function will not be changed
			//for(int i=0;i<classesFieldsMap.get(checkIdForParmObj).size()-1;i++){
			try{
				if(templine.length == 1){
					content.append(line).append(System.lineSeparator());//we append every line in the file
					line = reader.readLine();
				}
			}catch (IOException e) {
				e.printStackTrace();
			}
			//}
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
		public void objectParam(String paraitem){
			// check if the parameter is not a number
			if(!(paraitem.matches("-?\\d+(\\.\\d+)?"))){
				//take all class names from hashmap to return their obj to check if parameter is an object or not 
				for (String key : objectPointsClassNameMap.keySet()) {
					if(objectPointsClassNameMap.get(key).contains(paraitem)){
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
							Set<String> keys = lineOfClassStruct.keySet();
							List<String> keyList = List.copyOf(keys);
							Set<String> Classeskeys = classesAndFunctions.keySet();
							List<String> ClasseskeysList = List.copyOf(keys);
							int step = keyList.size()-1;
							int paramCounter = 1;//not init
							while ((line = reader.readLine()) != null) 
							{
								if (lineOfClassStruct != null && checkIdForParmObj != null)
								{
									if(currentLineNumber == lineOfClassStruct.get(keyList.get(step)).get(1) && step>0){
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
									if (ClasseskeysList.contains(checkIdForParmObj) && currentLineNumber == lineOfClassStruct.get(checkIdForParmObj).get(0) && lineNumberOfstrucktParam>0){
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
								// this condition checks if tere is a keyword base for inheritance
								if(!(structInfoMap.isEmpty()) && f == true){
									for(String parameter: structInfoMap.get(key)){
										if(line.contains(parameter))continue;
										else{
											String mamaClass = childAndParent.get(key);
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

	public grammar_v3_2Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public ClassesContext classes() {
			return getRuleContext(ClassesContext.class,0);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			classes();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassesContext extends ParserRuleContext {
		public MainContext main() {
			return getRuleContext(MainContext.class,0);
		}
		public List<ClassContext> class_() {
			return getRuleContexts(ClassContext.class);
		}
		public ClassContext class_(int i) {
			return getRuleContext(ClassContext.class,i);
		}
		public ClassesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterClasses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitClasses(this);
		}
	}

	public final ClassesContext classes() throws RecognitionException {
		ClassesContext _localctx = new ClassesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			        pyFile = new File(pythonInput);
			        try{
			            myReader = new Scanner(pyFile);
			        }catch (IOException e) {
			                System.out.println("An error occurred.");
			                e.printStackTrace();
			            }
			        RW = new WriteToFile();
			        RW.openFile("outputFile.c",false);
			        RW.writeFile("#include <stdio.h>\n");
			    
			setState(62); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(61);
				class_();
				}
				}
				setState(64); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__0 );
			setState(66);
			main();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassContext extends ParserRuleContext {
		public Token ID;
		public List<TerminalNode> ID() { return getTokens(grammar_v3_2Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(grammar_v3_2Parser.ID, i);
		}
		public InitFunctionContext initFunction() {
			return getRuleContext(InitFunctionContext.class,0);
		}
		public FunctionsContext functions() {
			return getRuleContext(FunctionsContext.class,0);
		}
		public ClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitClass(this);
		}
	}

	public final ClassContext class_() throws RecognitionException {
		ClassContext _localctx = new ClassContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_class);
		try {
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68);
				match(T__0);
				setState(69);
				((ClassContext)_localctx).ID = match(ID);
				setState(70);
				match(T__1);
				  
				        // Check for already used class name
				        String className = (((ClassContext)_localctx).ID!=null?((ClassContext)_localctx).ID.getText():null);
				        if (!classesList.contains(className)){
				            classesList.add(className);
				        }
				        else if (classesList.contains(className)){
				            System.err.println("Error: Class name '" + className + "' already used");
				            System.exit(1);    
				        }
				        
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
				        tempNameClass = (((ClassContext)_localctx).ID!=null?((ClassContext)_localctx).ID.getText():null);
				        RW.writeFile("\ntypedef struct{ \n");
				    
				setState(72);
				initFunction();
				setState(73);
				functions();

				        scope.remove_scope();
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(76);
				match(T__0);
				setState(77);
				((ClassContext)_localctx).ID = match(ID);

				        
				        // Check for already used class name
				        String className = (((ClassContext)_localctx).ID!=null?((ClassContext)_localctx).ID.getText():null);
				        if (!classesList.contains(className)){
				            classesList.add(className);
				        }
				        else if (classesList.contains(className)){
				            System.err.println("Error: Class name '" + className + "' already used");
				            System.exit(1);    
				        }

				        line = myReader.nextLine();
				        int temp = ReturnTotalNumberOftabs(line) ;
				        if( temp != -1 && temp!=tabCounter)
				        {
				            System.out.println("Check your tabs in the begining of your class");
				            System.exit(0);
				        }
				        tempNameClass = (((ClassContext)_localctx).ID!=null?((ClassContext)_localctx).ID.getText():null);
				    
				setState(79);
				match(T__2);
				setState(80);
				((ClassContext)_localctx).ID = match(ID);
				 klironomikotitaName = (((ClassContext)_localctx).ID!=null?((ClassContext)_localctx).ID.getText():null);
				setState(82);
				match(T__3);
				setState(83);
				match(T__1);
				  
						klironomikotita = true;
				        AddScope scope = new AddScope();
				        scope.add_new_scope();
				        RW.writeFile("\ntypedef struct{ \n");
				    
				setState(85);
				initFunction();
				setState(86);
				functions();

						klironomikotita = false;
				        scope.remove_scope();
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MainContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public MainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_main; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterMain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitMain(this);
		}
	}

	public final MainContext main() throws RecognitionException {
		MainContext _localctx = new MainContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_main);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(T__4);
			setState(92);
			match(T__5);
			setState(93);
			match(T__6);
			setState(94);
			match(T__7);
			setState(95);
			match(T__1);

			        tabCounter+=1;
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
								lineOfClassStruct.put((line.split("}")[1].trim()).split(";")[0],templ);
								structFlag = false;
							}
							lineCounter+=1;
						}
						myReader.close();
						RW.openFile("outputFile.c",true);
					}catch (IOException e) {
						e.printStackTrace();
					}
			    
			setState(97);
			statements();

			        TmpRw.closeFile();
			        
			        // Reset the return flag for the next function
			        RW.merge("tempCFile.c");

			        // Delete temp c file after merging with main output C file
			        TmpRw.deleteFile();
			        
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
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InitFunctionContext extends ParserRuleContext {
		public FormalparlistContext formalparlist() {
			return getRuleContext(FormalparlistContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public InitFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initFunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterInitFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitInitFunction(this);
		}
	}

	public final InitFunctionContext initFunction() throws RecognitionException {
		InitFunctionContext _localctx = new InitFunctionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_initFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(T__8);
			setState(101);
			match(T__9);

			        tabCounter +=1;
			        line = myReader.nextLine();
			        int temp = ReturnTotalNumberOftabs(line) ;
			        if(temp != -1 && temp!=tabCounter)
			        {
			            System.out.println("Check your tabs near line: "+line);
			            System.exit(0);
			        }
			        entity.add_new_function("__init__");
			    
			setState(103);
			match(T__2);
			setState(104);
			formalparlist();
			setState(105);
			match(T__3);
			setState(106);
			match(T__1);
			  
			        AddScope scope = new AddScope();
			        scope.add_new_scope();
			        ArrayList <Entity> entities_list = scopes_list.get(scopes_list.size()-2).getEntitiesList();
			        Function fun = (Function) entities_list.get(entities_list.size()-1);
			        //we use this to fill the struct
					if(klironomikotita == true){
						childAndParent.put(tempNameClass,klironomikotitaName);
						RW.writeFile("\t".repeat(tabCounter)+klironomikotitaName+" base;\n");
					}
					tempList = new ArrayList<String>();
			        for(int i=0;i<fun.getFormalParList().size();i++){
						tempList.add(fun.getFormalParList().get(i).getName());
						classesFieldsMap.put(tempNameClass,tempList);
						if(i>0 && klironomikotita == true){
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
			        wrInFinalCFile = true;
					counterFileds =2;
			    
			setState(108);
			statements();

			        wrInFinalCFile = false;
			        RW.writeFile("\n}\n");
			        scope.remove_scope();
			        tabCounter -=1;
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionsContext extends ParserRuleContext {
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public FunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitFunctions(this);
		}
	}

	public final FunctionsContext functions() throws RecognitionException {
		FunctionsContext _localctx = new FunctionsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_functions);
		int _la;
		try {
			setState(120);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__8:
				enterOuterAlt(_localctx, 1);
				{
				tempFuncName = new ArrayList<String>();
				setState(112);
				function();
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__8) {
					{
					{
					setState(113);
					function();
					}
					}
					setState(118);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__0:
			case T__4:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionContext extends ParserRuleContext {
		public Token ID;
		public TerminalNode ID() { return getToken(grammar_v3_2Parser.ID, 0); }
		public FormalparlistContext formalparlist() {
			return getRuleContext(FormalparlistContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public FunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
			match(T__8);
			setState(123);
			((FunctionContext)_localctx).ID = match(ID);

					tempFuncName.add((((FunctionContext)_localctx).ID!=null?((FunctionContext)_localctx).ID.getText():null));
					classesAndFunctions.put(tempNameClass,tempFuncName);
			        tabCounter +=1;
			        line = myReader.nextLine();
			        int temp = ReturnTotalNumberOftabs(line) ;
			        if(temp != -1 && temp!=tabCounter)
			        {
			            System.out.println("Check your tabs near line: "+line);
			            System.exit(0);
			        }
			        entity.add_new_function((((FunctionContext)_localctx).ID!=null?((FunctionContext)_localctx).ID.getText():null));
			    
			setState(125);
			match(T__2);
			setState(126);
			formalparlist();
			setState(127);
			match(T__3);
			setState(128);
			match(T__1);
			  
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
			                TmpRw.writeFile(" "+tempNameClass+"_"+(((FunctionContext)_localctx).ID!=null?((FunctionContext)_localctx).ID.getText():null)+" ("+tempNameClass+" *"+fun.getFormalParList().get(i).getName());
			            }
			            // If it has more parameters than self
			            else if(i>0)TmpRw.writeFile(",int "+fun.getFormalParList().get(i).getName());
			        }
			        TmpRw.writeFile(") {\n");
			    
			setState(132);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(130);
				statements();
				}
				break;
			case 2:
				{
				setState(131);
				match(T__10);
				}
				break;
			}

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
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statements);
		try {
			int _alt;
			setState(142);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(137); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(136);
						statement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(139); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public AssignmentStatContext assignmentStat() {
			return getRuleContext(AssignmentStatContext.class,0);
		}
		public IfStatContext ifStat() {
			return getRuleContext(IfStatContext.class,0);
		}
		public WhileStatContext whileStat() {
			return getRuleContext(WhileStatContext.class,0);
		}
		public PrintStatContext printStat() {
			return getRuleContext(PrintStatContext.class,0);
		}
		public ReturnStatContext returnStat() {
			return getRuleContext(ReturnStatContext.class,0);
		}
		public CallStatContext callStat() {
			return getRuleContext(CallStatContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_statement);
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				assignmentStat();

				        line = myReader.nextLine();
				        int temp = ReturnTotalNumberOftabs(line) ;
				        if(temp != -1 && temp!=tabCounter+1)
				        {
				            System.out.println("Check your tabs near line: "+line);
				            System.exit(0);
				        }
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				ifStat();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				whileStat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				printStat();

				        line = myReader.nextLine();
				        int temp = ReturnTotalNumberOftabs(line) ;
				        if(temp != -1 && temp!=tabCounter+1)
				        {
				            System.out.println("Check your tabs near line: "+line);
				            System.exit(0);
				        }
				    
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(152);
				returnStat();

				        line = myReader.nextLine();
				        int temp = ReturnTotalNumberOftabs(line) ;
				        if(temp != -1 && temp!=tabCounter+1)
				        {
				            System.out.println("Check your tabs near line: "+line);
				            System.exit(0);
				        }
				    
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				callStatFlag = true;
				setState(156);
				callStat();

				        line = myReader.nextLine();
				        int temp = ReturnTotalNumberOftabs(line) ;
				        if(temp != -1 && temp!=tabCounter+1)
				        {
				            System.out.println("Check your tabs near line: "+line);
				            System.exit(0);
				        }
				    
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(159);
				match(T__10);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FormalparlistContext extends ParserRuleContext {
		public List<FormalparitemContext> formalparitem() {
			return getRuleContexts(FormalparitemContext.class);
		}
		public FormalparitemContext formalparitem(int i) {
			return getRuleContext(FormalparitemContext.class,i);
		}
		public FormalparlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalparlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterFormalparlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitFormalparlist(this);
		}
	}

	public final FormalparlistContext formalparlist() throws RecognitionException {
		FormalparlistContext _localctx = new FormalparlistContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_formalparlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{

			        // List for storing formal parameters
			        //ArrayList <String> formalParameterList = new ArrayList <String>();
			    
			setState(163);
			formalparitem();
			setState(168);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(164);
				match(T__11);
				setState(165);
				formalparitem();
				}
				}
				setState(170);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FormalparitemContext extends ParserRuleContext {
		public Token ID;
		public ObjContext obj;
		public TerminalNode ID() { return getToken(grammar_v3_2Parser.ID, 0); }
		public ObjContext obj() {
			return getRuleContext(ObjContext.class,0);
		}
		public FormalparitemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalparitem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterFormalparitem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitFormalparitem(this);
		}
	}

	public final FormalparitemContext formalparitem() throws RecognitionException {
		FormalparitemContext _localctx = new FormalparitemContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_formalparitem);
		try {
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(171);
				((FormalparitemContext)_localctx).ID = match(ID);

				        // Check for already used parameter name
				        // String parameterName = (((FormalparitemContext)_localctx).ID!=null?((FormalparitemContext)_localctx).ID.getText():null);
				        // if (!formalParameterList.contains(parameterName)){
				        //     formalParameterList.add(parameterName);
				        // }
				        // else if (formalParameterList.contains(parameterName)){
				        //     System.err.println("Error: Parameter name '" + parameterName + "' already used");
				        //     System.exit(1);    
				        // }

				        entity.add_parameter((((FormalparitemContext)_localctx).ID!=null?((FormalparitemContext)_localctx).ID.getText():null));
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				((FormalparitemContext)_localctx).obj = obj();

				        entity.add_parameter((((FormalparitemContext)_localctx).obj!=null?_input.getText(((FormalparitemContext)_localctx).obj.start,((FormalparitemContext)_localctx).obj.stop):null));
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ActualparlistContext extends ParserRuleContext {
		public ActualparitemContext actualparitem;
		public List<ActualparitemContext> actualparitem() {
			return getRuleContexts(ActualparitemContext.class);
		}
		public ActualparitemContext actualparitem(int i) {
			return getRuleContext(ActualparitemContext.class,i);
		}
		public ActualparlistContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualparlist; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterActualparlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitActualparlist(this);
		}
	}

	public final ActualparlistContext actualparlist() throws RecognitionException {
		ActualparlistContext _localctx = new ActualparlistContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_actualparlist);
		int _la;
		try {
			setState(191);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
			case ID:
			case INT:
			case ADD_OP:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				((ActualparlistContext)_localctx).actualparitem = actualparitem();

						//if(!((((ActualparlistContext)_localctx).actualparitem!=null?_input.getText(((ActualparlistContext)_localctx).actualparitem.start,((ActualparlistContext)_localctx).actualparitem.stop):null).isEmpty()) && assignFlag == true) auto den leitourgei stin periptosh tou komatos stin Employee_setDepartment(&peter,2)
						// alla stin katw sinthiki an kalesoume mi sinartisi apeythias mporei na valei koma ekei poy den theloume
				        if(!((((ActualparlistContext)_localctx).actualparitem!=null?_input.getText(((ActualparlistContext)_localctx).actualparitem.start,((ActualparlistContext)_localctx).actualparitem.stop):null).isEmpty())){
							objectParam((((ActualparlistContext)_localctx).actualparitem!=null?_input.getText(((ActualparlistContext)_localctx).actualparitem.start,((ActualparlistContext)_localctx).actualparitem.stop):null));
				            if(wrInFinalCFile==true){
								RW.closeFile();
								RW.seekInfile((((ActualparlistContext)_localctx).actualparitem!=null?_input.getText(((ActualparlistContext)_localctx).actualparitem.start,((ActualparlistContext)_localctx).actualparitem.stop):null).length()+2,",");
								RW.openFile("outputFile.c",true);
							}
				            else{
								TmpRw.closeFile();
								TmpRw.seekInfile((((ActualparlistContext)_localctx).actualparitem!=null?_input.getText(((ActualparlistContext)_localctx).actualparitem.start,((ActualparlistContext)_localctx).actualparitem.stop):null).length()+2,",");
								TmpRw.openFile("tempCFile.c",true);
							}
				        }
				    
				setState(187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__11) {
					{
					{
					setState(180);
					match(T__11);

					        if(wrInFinalCFile == true)RW.writeFile(",");
					        else TmpRw.writeFile(",");
					    
					setState(182);
					((ActualparlistContext)_localctx).actualparitem = actualparitem();
					objectParam((((ActualparlistContext)_localctx).actualparitem!=null?_input.getText(((ActualparlistContext)_localctx).actualparitem.start,((ActualparlistContext)_localctx).actualparitem.stop):null));
					}
					}
					setState(189);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ActualparitemContext extends ParserRuleContext {
		public Token ID;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ObjContext obj() {
			return getRuleContext(ObjContext.class,0);
		}
		public TerminalNode ID() { return getToken(grammar_v3_2Parser.ID, 0); }
		public ActualparitemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualparitem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterActualparitem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitActualparitem(this);
		}
	}

	public final ActualparitemContext actualparitem() throws RecognitionException {
		ActualparitemContext _localctx = new ActualparitemContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_actualparitem);
		try {
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(194);
				obj();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(195);
				((ActualparitemContext)_localctx).ID = match(ID);

				        if(wrInFinalCFile == true)RW.writeFile((((ActualparitemContext)_localctx).ID!=null?((ActualparitemContext)_localctx).ID.getText():null)+" ");
				        else TmpRw.writeFile((((ActualparitemContext)_localctx).ID!=null?((ActualparitemContext)_localctx).ID.getText():null)+" ");
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentStatContext extends ParserRuleContext {
		public Token ID;
		public ObjContext obj() {
			return getRuleContext(ObjContext.class,0);
		}
		public CallStatContext callStat() {
			return getRuleContext(CallStatContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ID() { return getToken(grammar_v3_2Parser.ID, 0); }
		public AssignmentStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterAssignmentStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitAssignmentStat(this);
		}
	}

	public final AssignmentStatContext assignmentStat() throws RecognitionException {
		AssignmentStatContext _localctx = new AssignmentStatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_assignmentStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(204);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				{
				{
				setState(199);
				((AssignmentStatContext)_localctx).ID = match(ID);

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
				                 tempAssignment =("\t".repeat(tabCounter)+(((AssignmentStatContext)_localctx).ID!=null?((AssignmentStatContext)_localctx).ID.getText():null)+" = ");
				            
				}
				}
				break;
			case 2:
				{
				setState(201);
				obj();

							if(klironomikotita == true){
								if(counterFileds-1 > classesFieldsMap.get(klironomikotitaName).size()){
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
				break;
			}
			setState(206);
			match(T__12);
			assignFlag = true;
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(208);
				callStat();
				}
				break;
			case 2:
				{
				setState(209);
				expression();
				}
				break;
			}
			dontWriteInheritanceData = false;assignFlag = false;

					if(klironomikotita == true){
						if(counterFileds-1 > classesFieldsMap.get(klironomikotitaName).size()){
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
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ElsepartContext elsepart() {
			return getRuleContext(ElsepartContext.class,0);
		}
		public IfStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitIfStat(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_ifStat);
		try {
			setState(235);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215);
				match(T__4);

				            line = myReader.nextLine();
				            int temp = ReturnTotalNumberOftabs(line) ;
				            if(temp != -1 && temp!=tabCounter+1)
				            {
				                System.out.println("Check your tabs near line: "+line);
				                System.exit(0);
				            }
				            // Need to set elseFlag false for each if
				            elseFlag = false;
				            if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"if (");
				            else TmpRw.writeFile("\t".repeat(tabCounter)+"if (");
							rmTabsCallstat = true;
				        
				setState(217);
				condition();
				setState(218);
				match(T__1);

						rmTabsCallstat = false;
				        tabCounter +=1;
				        if(wrInFinalCFile==true)RW.writeFile("){\n");
				        else TmpRw.writeFile("){\n");
				    
				setState(220);
				statements();

				        tabCounter -=1;
				        if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"}\n");
				        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
				    
				setState(222);
				elsepart();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(224);
				match(T__4);
				setState(225);
				match(T__2);

				        line = myReader.nextLine();
				        int temp = ReturnTotalNumberOftabs(line) ;
				        if(temp != -1 && temp!=tabCounter+1)
				        {
				            System.out.println("Check your tabs near line: "+line);
				            System.exit(0);
				        }
				        elseFlag = false;
				        if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"if (");
				        else TmpRw.writeFile("\t".repeat(tabCounter)+"if (");
						rmTabsCallstat = true;
				    
				setState(227);
				condition();
				setState(228);
				match(T__3);
				setState(229);
				match(T__1);

						rmTabsCallstat = false;
				        tabCounter +=1;
				        if(wrInFinalCFile==true)RW.writeFile("){\n");
				        else TmpRw.writeFile("){\n");
				    
				setState(231);
				statements();

				        tabCounter -=1;
				        if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"}\n");
				        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
				    
				setState(233);
				elsepart();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElsepartContext extends ParserRuleContext {
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public ElsepartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elsepart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterElsepart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitElsepart(this);
		}
	}

	public final ElsepartContext elsepart() throws RecognitionException {
		ElsepartContext _localctx = new ElsepartContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_elsepart);
		try {
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				match(T__13);
				setState(238);
				match(T__1);

				        line = myReader.nextLine();
				        int temp = ReturnTotalNumberOftabs(line) ;
				        if(temp != -1 && temp!=tabCounter+1)
				        {
				            System.out.println("Check your tabs near line: "+line);
				            System.exit(0);
				        }
				        if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"else {\n");
				        else TmpRw.writeFile("\t".repeat(tabCounter)+"else {\n");
				        // Need this flag here to add return 0 at C when else doesn't exist
				        elseFlag = true;
				        tabCounter+=1;
				    
				setState(240);
				statements();

				        tabCounter-=1;
				        if(wrInFinalCFile==true)RW.writeFile("}\n");
				        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public WhileStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitWhileStat(this);
		}
	}

	public final WhileStatContext whileStat() throws RecognitionException {
		WhileStatContext _localctx = new WhileStatContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_whileStat);
		try {
			setState(264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				match(T__14);

				            if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"while (");
				            else TmpRw.writeFile("\t".repeat(tabCounter)+"while (");
							rmTabsCallstat = true;
				    
				setState(248);
				match(T__2);
				setState(249);
				condition();
				setState(250);
				match(T__3);
				setState(251);
				match(T__1);

						rmTabsCallstat = false;
				        tabCounter +=1;
				        if(wrInFinalCFile==true)RW.writeFile("){\n");
				        else TmpRw.writeFile("){\n");
				    
				setState(253);
				statements();

				        tabCounter -=1;
				        if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"}\n");
				        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(256);
				match(T__14);

				        if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"while (");
				        else TmpRw.writeFile("\t".repeat(tabCounter)+"while (");
						rmTabsCallstat = true;
				    
				setState(258);
				condition();
				setState(259);
				match(T__1);

						rmTabsCallstat = false;
				        tabCounter +=1;
				        if(wrInFinalCFile==true)RW.writeFile("){\n");
				        else TmpRw.writeFile("){\n");
				    
				setState(261);
				statements();

				        tabCounter -=1;
				        if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"}\n");
				        else TmpRw.writeFile("\t".repeat(tabCounter)+"}\n");
				    
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrintStatContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public PrintStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterPrintStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitPrintStat(this);
		}
	}

	public final PrintStatContext printStat() throws RecognitionException {
		PrintStatContext _localctx = new PrintStatContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_printStat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			match(T__15);

			        if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"printf (");
			        else TmpRw.writeFile("\t".repeat(tabCounter)+"printf (");
					rmTabsCallstat = true;
			    
			setState(268);
			match(T__2);
			setState(269);
			expression();
			setState(275);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(270);
				match(T__11);

						if(wrInFinalCFile==true)RW.writeFile(",");
				        else TmpRw.writeFile(",");
					
				setState(272);
				expression();
				}
				}
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(278);
			match(T__3);

					rmTabsCallstat = false;
			        if(wrInFinalCFile==true)RW.writeFile(");\n");
			        else TmpRw.writeFile(");\n");
			    
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterReturnStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitReturnStat(this);
		}
	}

	public final ReturnStatContext returnStat() throws RecognitionException {
		ReturnStatContext _localctx = new ReturnStatContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_returnStat);
		try {
			setState(293);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				match(T__16);

				            if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"return ");
				            else {
				                TmpRw.writeFile("\t".repeat(tabCounter)+"return ");
				            }
							rmTabsCallstat = true;
				        
				setState(283);
				expression();

							rmTabsCallstat = false;
				            if(wrInFinalCFile==true)RW.writeFile(";\n");
				            else TmpRw.writeFile(";\n");
				            returnFlag = 1;
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(286);
				match(T__16);
				setState(287);
				match(T__2);

				        if(wrInFinalCFile==true)RW.writeFile("\t".repeat(tabCounter)+"return (");
				        else TmpRw.writeFile("\t".repeat(tabCounter)+"return (");
				    
				setState(289);
				expression();
				setState(290);
				match(T__3);

				            if(wrInFinalCFile==true)RW.writeFile(");\n");
				            else TmpRw.writeFile(");\n");
				            returnFlag = 1;
				        
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallStatContext extends ParserRuleContext {
		public Token ID;
		public ObjContext obj() {
			return getRuleContext(ObjContext.class,0);
		}
		public ActualparlistContext actualparlist() {
			return getRuleContext(ActualparlistContext.class,0);
		}
		public TerminalNode ID() { return getToken(grammar_v3_2Parser.ID, 0); }
		public CallStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterCallStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitCallStat(this);
		}
	}

	public final CallStatContext callStat() throws RecognitionException {
		CallStatContext _localctx = new CallStatContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_callStat);
		try {
			setState(305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(295);
				obj();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(296);
				((CallStatContext)_localctx).ID = match(ID);

						checkIdForParmObj = (((CallStatContext)_localctx).ID!=null?((CallStatContext)_localctx).ID.getText():null);
						if(dontWriteInheritanceData ==false ){
							if(assignFlag == true){
								/*
									Only keep the tabs and the name of the ID, without the "="
									Write in file: Person george
									The declaration of the object george of type Person
								*/
								String[]temp = tempAssignment.split(" =");
								if(!(objectPointsClassNameMap.containsKey((((CallStatContext)_localctx).ID!=null?((CallStatContext)_localctx).ID.getText():null)))){
									objectPointsClassNameMap.put((((CallStatContext)_localctx).ID!=null?((CallStatContext)_localctx).ID.getText():null),new ArrayList<>());
								}
								objectPointsClassNameMap.get((((CallStatContext)_localctx).ID!=null?((CallStatContext)_localctx).ID.getText():null)).add(temp[0].trim());
								if(wrInFinalCFile==true){
									RW.writeFile("\t".repeat(tabCounter)+(((CallStatContext)_localctx).ID!=null?((CallStatContext)_localctx).ID.getText():null)+temp[0]+";\n");
									RW.writeFile("\t".repeat(tabCounter)+(((CallStatContext)_localctx).ID!=null?((CallStatContext)_localctx).ID.getText():null)+"_init");
								}
								else {
									TmpRw.writeFile("\t".repeat(tabCounter)+(((CallStatContext)_localctx).ID!=null?((CallStatContext)_localctx).ID.getText():null)+temp[0]+";\n");
									TmpRw.writeFile("\t".repeat(tabCounter)+(((CallStatContext)_localctx).ID!=null?((CallStatContext)_localctx).ID.getText():null)+"_init");
									}
							}
							else{
								for(String className: objectPointsClassNameMap.keySet()){
				                    // Check what type of class is the object id
									if(objectPointsClassNameMap.get(className).contains(id)){
				                        
				                        // Check what class is the function from
				                        if(classesAndFunctions.get(className).contains((((CallStatContext)_localctx).ID!=null?((CallStatContext)_localctx).ID.getText():null))){
				                            // Set this to not do downcasting, since the function is in this class
				                            classNameForDowncasting = className;
				                            if(wrInFinalCFile==true){
				                                if(rmTabsCallstat == true)RW.writeFile(className+"_"+(((CallStatContext)_localctx).ID!=null?((CallStatContext)_localctx).ID.getText():null));
				                                else RW.writeFile("\t".repeat(tabCounter)+className+"_"+(((CallStatContext)_localctx).ID!=null?((CallStatContext)_localctx).ID.getText():null));
				                            }
				                            else {
				                                if(rmTabsCallstat == true)TmpRw.writeFile(className+"_"+(((CallStatContext)_localctx).ID!=null?((CallStatContext)_localctx).ID.getText():null));
				                                else TmpRw.writeFile("\t".repeat(tabCounter)+className+"_"+(((CallStatContext)_localctx).ID!=null?((CallStatContext)_localctx).ID.getText():null));
				                            }
				                            break;
				                        }
				                        
				                        // This is where downcasting is needed for when a parent class calls a function of a child class on an
				                        // object that has the parent class type
				                        else {
				                            for(String className2: classesAndFunctions.keySet()){
				                                if(classesAndFunctions.get(className2).contains((((CallStatContext)_localctx).ID!=null?((CallStatContext)_localctx).ID.getText():null))){
				                                    classNameForDowncasting = className2;
				                                    if(wrInFinalCFile==true){
				                                        if(rmTabsCallstat == true)RW.writeFile(className2+"_"+(((CallStatContext)_localctx).ID!=null?((CallStatContext)_localctx).ID.getText():null));
				                                        else RW.writeFile("\t".repeat(tabCounter)+className2+"_"+(((CallStatContext)_localctx).ID!=null?((CallStatContext)_localctx).ID.getText():null));
				                                    }
				                                    else {
				                                        if(rmTabsCallstat == true)TmpRw.writeFile(className2+"_"+(((CallStatContext)_localctx).ID!=null?((CallStatContext)_localctx).ID.getText():null));
				                                        else TmpRw.writeFile("\t".repeat(tabCounter)+className2+"_"+(((CallStatContext)_localctx).ID!=null?((CallStatContext)_localctx).ID.getText():null));
				                                    }
				                                    break;
				                                }
				                            }
				                        }
									}
								}
							}
						}
				    
				}
				setState(299);
				match(T__2);

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
								for(String key:objectPointsClassNameMap.keySet()){
									if(objectPointsClassNameMap.get(key).contains(id)&& !(classNameForDowncasting.equals(key))){
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
				    
				setState(301);
				actualparlist();
				setState(302);
				match(T__3);

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
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConditionContext extends ParserRuleContext {
		public List<BooltermContext> boolterm() {
			return getRuleContexts(BooltermContext.class);
		}
		public BooltermContext boolterm(int i) {
			return getRuleContext(BooltermContext.class,i);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307);
			boolterm();
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(308);
				match(T__17);

				        if(wrInFinalCFile==true)RW.writeFile(" or ");
				        else TmpRw.writeFile(" or ");
				    
				setState(310);
				boolterm();
				}
				}
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BooltermContext extends ParserRuleContext {
		public List<BoolfactorContext> boolfactor() {
			return getRuleContexts(BoolfactorContext.class);
		}
		public BoolfactorContext boolfactor(int i) {
			return getRuleContext(BoolfactorContext.class,i);
		}
		public BooltermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolterm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterBoolterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitBoolterm(this);
		}
	}

	public final BooltermContext boolterm() throws RecognitionException {
		BooltermContext _localctx = new BooltermContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_boolterm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			boolfactor();
			setState(322);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__18) {
				{
				{
				setState(317);
				match(T__18);

				        if(wrInFinalCFile==true)RW.writeFile(" and ");
				        else TmpRw.writeFile(" and ");
				    
				setState(319);
				boolfactor();
				}
				}
				setState(324);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BoolfactorContext extends ParserRuleContext {
		public Token REL_OP;
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode REL_OP() { return getToken(grammar_v3_2Parser.REL_OP, 0); }
		public BoolfactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolfactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterBoolfactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitBoolfactor(this);
		}
	}

	public final BoolfactorContext boolfactor() throws RecognitionException {
		BoolfactorContext _localctx = new BoolfactorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_boolfactor);
		try {
			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(325);
				match(T__19);
				setState(326);
				match(T__2);

				        if(wrInFinalCFile==true)RW.writeFile(" not (");
				        else TmpRw.writeFile(" not (");
				    
				setState(328);
				condition();
				setState(329);
				match(T__3);

				        if(wrInFinalCFile==true)RW.writeFile(")");
				        else TmpRw.writeFile(")");        
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(332);
				match(T__2);

				        if(wrInFinalCFile==true)RW.writeFile("(");
				        else TmpRw.writeFile("(");        
				    
				setState(334);
				condition();
				setState(335);
				match(T__3);

				        if(wrInFinalCFile==true)RW.writeFile(")");
				        else TmpRw.writeFile(")");        
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(338);
				expression();
				setState(339);
				((BoolfactorContext)_localctx).REL_OP = match(REL_OP);

				        if(wrInFinalCFile==true)RW.writeFile((((BoolfactorContext)_localctx).REL_OP!=null?((BoolfactorContext)_localctx).REL_OP.getText():null));
				        else TmpRw.writeFile((((BoolfactorContext)_localctx).REL_OP!=null?((BoolfactorContext)_localctx).REL_OP.getText():null));        
				    
				setState(341);
				expression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ObjContext extends ParserRuleContext {
		public Token ID;
		public List<TerminalNode> ID() { return getTokens(grammar_v3_2Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(grammar_v3_2Parser.ID, i);
		}
		public CallStatContext callStat() {
			return getRuleContext(CallStatContext.class,0);
		}
		public ObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitObj(this);
		}
	}

	public final ObjContext obj() throws RecognitionException {
		ObjContext _localctx = new ObjContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_obj);
		try {
			setState(357);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(345);
				((ObjContext)_localctx).ID = match(ID);

							id = (((ObjContext)_localctx).ID!=null?((ObjContext)_localctx).ID.getText():null);
				        
				setState(347);
				match(T__20);
				setState(348);
				((ObjContext)_localctx).ID = match(ID);

							/* an klironomis dedomena tote des an erxese apo klironomikotita h oxi */
							if(dontWriteInheritanceData == false){
								if(wrInFinalCFile == true){
									if(klironomikotita == false){//oi sunartiseis init pou den einai se klironomikotita
										if (rmTabsCallstat == true)RW.writeFile("self->"+id+"->");
										else RW.writeFile("\t".repeat(tabCounter)+id+"->");
										RW.writeFile((((ObjContext)_localctx).ID!=null?((ObjContext)_localctx).ID.getText():null));
									}
									else {
										/*we made this condition to check if every init function has inherited fields */
										if ((classesFieldsMap.get(klironomikotitaName)).contains((((ObjContext)_localctx).ID!=null?((ObjContext)_localctx).ID.getText():null))){
											if((classesFieldsMap.get(klironomikotitaName)).size() == counterFileds){
												RW.writeFile("\t".repeat(tabCounter)+klironomikotitaName+"_init(("+klironomikotitaName+"*)");
												ArrayList<String> values = new ArrayList<String>();
												for (String value : classesFieldsMap.get(klironomikotitaName)){
													values.add(value);
												}
												RW.writeFile(String.join(", ", values)+");\n");
											}
										}
										else {
											RW.writeFile("\t".repeat(tabCounter)+id+"->");
											RW.writeFile((((ObjContext)_localctx).ID!=null?((ObjContext)_localctx).ID.getText():null));
										}
										counterFileds+=1;
									}
								}
								else {
									if (rmTabsCallstat == true)TmpRw.writeFile(id+"->");
									else TmpRw.writeFile("\t".repeat(tabCounter)+id+"->");
									TmpRw.writeFile((((ObjContext)_localctx).ID!=null?((ObjContext)_localctx).ID.getText():null));
								}
							}
				        
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(350);
				((ObjContext)_localctx).ID = match(ID);

							if(dontWriteInheritanceData == false){
								id = (((ObjContext)_localctx).ID!=null?((ObjContext)_localctx).ID.getText():null);
							}
				        
				setState(352);
				match(T__20);
				rmTabsCallstat = true;
				setState(354);
				callStat();
				rmTabsCallstat = false;
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public OptionalSignContext optionalSign;
		public Token ADD_OP;
		public OptionalSignContext optionalSign() {
			return getRuleContext(OptionalSignContext.class,0);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> ADD_OP() { return getTokens(grammar_v3_2Parser.ADD_OP); }
		public TerminalNode ADD_OP(int i) {
			return getToken(grammar_v3_2Parser.ADD_OP, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_expression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359);
			((ExpressionContext)_localctx).optionalSign = optionalSign();

					if(dontWriteInheritanceData == false){
						if(wrInFinalCFile==true)RW.writeFile((((ExpressionContext)_localctx).optionalSign!=null?_input.getText(((ExpressionContext)_localctx).optionalSign.start,((ExpressionContext)_localctx).optionalSign.stop):null));
						else TmpRw.writeFile((((ExpressionContext)_localctx).optionalSign!=null?_input.getText(((ExpressionContext)_localctx).optionalSign.start,((ExpressionContext)_localctx).optionalSign.stop):null));
					}
			    
			setState(361);
			term();
			setState(367);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ADD_OP) {
				{
				{
				setState(362);
				((ExpressionContext)_localctx).ADD_OP = match(ADD_OP);

						if(dontWriteInheritanceData == false){
							if(wrInFinalCFile==true)RW.writeFile((((ExpressionContext)_localctx).ADD_OP!=null?((ExpressionContext)_localctx).ADD_OP.getText():null));
							else TmpRw.writeFile((((ExpressionContext)_localctx).ADD_OP!=null?((ExpressionContext)_localctx).ADD_OP.getText():null)); 
						}
				    
				setState(364);
				term();
				}
				}
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TermContext extends ParserRuleContext {
		public Token MUL_OP;
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MUL_OP() { return getTokens(grammar_v3_2Parser.MUL_OP); }
		public TerminalNode MUL_OP(int i) {
			return getToken(grammar_v3_2Parser.MUL_OP, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			factor();
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==MUL_OP) {
				{
				{
				setState(371);
				((TermContext)_localctx).MUL_OP = match(MUL_OP);

						if(dontWriteInheritanceData == false){
							if(wrInFinalCFile==true)RW.writeFile((((TermContext)_localctx).MUL_OP!=null?((TermContext)_localctx).MUL_OP.getText():null));
							else TmpRw.writeFile((((TermContext)_localctx).MUL_OP!=null?((TermContext)_localctx).MUL_OP.getText():null));
						}
				    
				setState(373);
				factor();
				}
				}
				setState(378);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FactorContext extends ParserRuleContext {
		public Token INT;
		public Token ID;
		public TerminalNode INT() { return getToken(grammar_v3_2Parser.INT, 0); }
		public TerminalNode ID() { return getToken(grammar_v3_2Parser.ID, 0); }
		public ObjContext obj() {
			return getRuleContext(ObjContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_factor);
		try {
			setState(388);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(379);
				((FactorContext)_localctx).INT = match(INT);

						if(dontWriteInheritanceData == false){
							if(wrInFinalCFile==true)RW.writeFile((((FactorContext)_localctx).INT!=null?((FactorContext)_localctx).INT.getText():null));
							else TmpRw.writeFile((((FactorContext)_localctx).INT!=null?((FactorContext)_localctx).INT.getText():null));
							}
				    
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(381);
				((FactorContext)_localctx).ID = match(ID);

						if(dontWriteInheritanceData == false){
							Boolean flag = false;
							if(wrInFinalCFile==true){
								for(String key:objectPointsClassNameMap.keySet()){
									if(objectPointsClassNameMap.get(key).contains((((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getText():null))){
										flag =true;
										break;
									}
								}
								if(flag == true)RW.writeFile(" &"+(((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getText():null));
								else RW.writeFile((((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getText():null));
							}
							else {
								for(String key:objectPointsClassNameMap.keySet()){
									if(objectPointsClassNameMap.get(key).contains((((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getText():null))){
										flag =true;
										break;
									}
								}
								if(flag == true)TmpRw.writeFile(" &"+(((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getText():null));
								else TmpRw.writeFile((((FactorContext)_localctx).ID!=null?((FactorContext)_localctx).ID.getText():null));
							}
						}
				    
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(383);
				obj();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(384);
				match(T__2);
				setState(385);
				expression();
				setState(386);
				match(T__3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OptionalSignContext extends ParserRuleContext {
		public TerminalNode ADD_OP() { return getToken(grammar_v3_2Parser.ADD_OP, 0); }
		public OptionalSignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionalSign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterOptionalSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitOptionalSign(this);
		}
	}

	public final OptionalSignContext optionalSign() throws RecognitionException {
		OptionalSignContext _localctx = new OptionalSignContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_optionalSign);
		try {
			setState(392);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD_OP:
				enterOuterAlt(_localctx, 1);
				{
				setState(390);
				match(ADD_OP);
				}
				break;
			case T__2:
			case ID:
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PointContext extends ParserRuleContext {
		public PointContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_point; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).enterPoint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v3_2Listener ) ((grammar_v3_2Listener)listener).exitPoint(this);
		}
	}

	public final PointContext point() throws RecognitionException {
		PointContext _localctx = new PointContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_point);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(394);
			match(T__20);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u001e\u018d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0004\u0001?\b\u0001\u000b\u0001\f\u0001@\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002Z\b\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u0005s\b\u0005"+
		"\n\u0005\f\u0005v\t\u0005\u0001\u0005\u0003\u0005y\b\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u0085\b\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0004\u0007\u008a\b\u0007\u000b\u0007\f\u0007"+
		"\u008b\u0001\u0007\u0003\u0007\u008f\b\u0007\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0003\b\u00a1\b\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0005\t\u00a7\b\t\n\t\f\t\u00aa\t\t\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0003\n\u00b1\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00ba\b\u000b\n\u000b"+
		"\f\u000b\u00bd\t\u000b\u0001\u000b\u0003\u000b\u00c0\b\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0003\f\u00c6\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u00cd\b\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u00d3\b\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00ec\b\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0003\u000f\u00f5\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u0109\b\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0005\u0011\u0112\b\u0011\n\u0011\f\u0011\u0115\t\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u0126\b\u0012\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0003\u0013\u0132\b\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0005\u0014\u0138\b\u0014\n\u0014\f\u0014\u013b\t\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u0141\b\u0015"+
		"\n\u0015\f\u0015\u0144\t\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0158\b\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0166"+
		"\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0005\u0018\u016e\b\u0018\n\u0018\f\u0018\u0171\t\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u0177\b\u0019\n\u0019"+
		"\f\u0019\u017a\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a"+
		"\u0185\b\u001a\u0001\u001b\u0001\u001b\u0003\u001b\u0189\b\u001b\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0000\u0000\u001d\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468\u0000\u0000\u0195\u0000:\u0001\u0000\u0000\u0000\u0002<\u0001\u0000"+
		"\u0000\u0000\u0004Y\u0001\u0000\u0000\u0000\u0006[\u0001\u0000\u0000\u0000"+
		"\bd\u0001\u0000\u0000\u0000\nx\u0001\u0000\u0000\u0000\fz\u0001\u0000"+
		"\u0000\u0000\u000e\u008e\u0001\u0000\u0000\u0000\u0010\u00a0\u0001\u0000"+
		"\u0000\u0000\u0012\u00a2\u0001\u0000\u0000\u0000\u0014\u00b0\u0001\u0000"+
		"\u0000\u0000\u0016\u00bf\u0001\u0000\u0000\u0000\u0018\u00c5\u0001\u0000"+
		"\u0000\u0000\u001a\u00cc\u0001\u0000\u0000\u0000\u001c\u00eb\u0001\u0000"+
		"\u0000\u0000\u001e\u00f4\u0001\u0000\u0000\u0000 \u0108\u0001\u0000\u0000"+
		"\u0000\"\u010a\u0001\u0000\u0000\u0000$\u0125\u0001\u0000\u0000\u0000"+
		"&\u0131\u0001\u0000\u0000\u0000(\u0133\u0001\u0000\u0000\u0000*\u013c"+
		"\u0001\u0000\u0000\u0000,\u0157\u0001\u0000\u0000\u0000.\u0165\u0001\u0000"+
		"\u0000\u00000\u0167\u0001\u0000\u0000\u00002\u0172\u0001\u0000\u0000\u0000"+
		"4\u0184\u0001\u0000\u0000\u00006\u0188\u0001\u0000\u0000\u00008\u018a"+
		"\u0001\u0000\u0000\u0000:;\u0003\u0002\u0001\u0000;\u0001\u0001\u0000"+
		"\u0000\u0000<>\u0006\u0001\uffff\uffff\u0000=?\u0003\u0004\u0002\u0000"+
		">=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@>\u0001\u0000\u0000"+
		"\u0000@A\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BC\u0003\u0006"+
		"\u0003\u0000C\u0003\u0001\u0000\u0000\u0000DE\u0005\u0001\u0000\u0000"+
		"EF\u0005\u0017\u0000\u0000FG\u0005\u0002\u0000\u0000GH\u0006\u0002\uffff"+
		"\uffff\u0000HI\u0003\b\u0004\u0000IJ\u0003\n\u0005\u0000JK\u0006\u0002"+
		"\uffff\uffff\u0000KZ\u0001\u0000\u0000\u0000LM\u0005\u0001\u0000\u0000"+
		"MN\u0005\u0017\u0000\u0000NO\u0006\u0002\uffff\uffff\u0000OP\u0005\u0003"+
		"\u0000\u0000PQ\u0005\u0017\u0000\u0000QR\u0006\u0002\uffff\uffff\u0000"+
		"RS\u0005\u0004\u0000\u0000ST\u0005\u0002\u0000\u0000TU\u0006\u0002\uffff"+
		"\uffff\u0000UV\u0003\b\u0004\u0000VW\u0003\n\u0005\u0000WX\u0006\u0002"+
		"\uffff\uffff\u0000XZ\u0001\u0000\u0000\u0000YD\u0001\u0000\u0000\u0000"+
		"YL\u0001\u0000\u0000\u0000Z\u0005\u0001\u0000\u0000\u0000[\\\u0005\u0005"+
		"\u0000\u0000\\]\u0005\u0006\u0000\u0000]^\u0005\u0007\u0000\u0000^_\u0005"+
		"\b\u0000\u0000_`\u0005\u0002\u0000\u0000`a\u0006\u0003\uffff\uffff\u0000"+
		"ab\u0003\u000e\u0007\u0000bc\u0006\u0003\uffff\uffff\u0000c\u0007\u0001"+
		"\u0000\u0000\u0000de\u0005\t\u0000\u0000ef\u0005\n\u0000\u0000fg\u0006"+
		"\u0004\uffff\uffff\u0000gh\u0005\u0003\u0000\u0000hi\u0003\u0012\t\u0000"+
		"ij\u0005\u0004\u0000\u0000jk\u0005\u0002\u0000\u0000kl\u0006\u0004\uffff"+
		"\uffff\u0000lm\u0003\u000e\u0007\u0000mn\u0006\u0004\uffff\uffff\u0000"+
		"n\t\u0001\u0000\u0000\u0000op\u0006\u0005\uffff\uffff\u0000pt\u0003\f"+
		"\u0006\u0000qs\u0003\f\u0006\u0000rq\u0001\u0000\u0000\u0000sv\u0001\u0000"+
		"\u0000\u0000tr\u0001\u0000\u0000\u0000tu\u0001\u0000\u0000\u0000uy\u0001"+
		"\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000wy\u0001\u0000\u0000\u0000"+
		"xo\u0001\u0000\u0000\u0000xw\u0001\u0000\u0000\u0000y\u000b\u0001\u0000"+
		"\u0000\u0000z{\u0005\t\u0000\u0000{|\u0005\u0017\u0000\u0000|}\u0006\u0006"+
		"\uffff\uffff\u0000}~\u0005\u0003\u0000\u0000~\u007f\u0003\u0012\t\u0000"+
		"\u007f\u0080\u0005\u0004\u0000\u0000\u0080\u0081\u0005\u0002\u0000\u0000"+
		"\u0081\u0084\u0006\u0006\uffff\uffff\u0000\u0082\u0085\u0003\u000e\u0007"+
		"\u0000\u0083\u0085\u0005\u000b\u0000\u0000\u0084\u0082\u0001\u0000\u0000"+
		"\u0000\u0084\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000"+
		"\u0000\u0086\u0087\u0006\u0006\uffff\uffff\u0000\u0087\r\u0001\u0000\u0000"+
		"\u0000\u0088\u008a\u0003\u0010\b\u0000\u0089\u0088\u0001\u0000\u0000\u0000"+
		"\u008a\u008b\u0001\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000"+
		"\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000"+
		"\u008d\u008f\u0001\u0000\u0000\u0000\u008e\u0089\u0001\u0000\u0000\u0000"+
		"\u008e\u008d\u0001\u0000\u0000\u0000\u008f\u000f\u0001\u0000\u0000\u0000"+
		"\u0090\u0091\u0003\u001a\r\u0000\u0091\u0092\u0006\b\uffff\uffff\u0000"+
		"\u0092\u00a1\u0001\u0000\u0000\u0000\u0093\u00a1\u0003\u001c\u000e\u0000"+
		"\u0094\u00a1\u0003 \u0010\u0000\u0095\u0096\u0003\"\u0011\u0000\u0096"+
		"\u0097\u0006\b\uffff\uffff\u0000\u0097\u00a1\u0001\u0000\u0000\u0000\u0098"+
		"\u0099\u0003$\u0012\u0000\u0099\u009a\u0006\b\uffff\uffff\u0000\u009a"+
		"\u00a1\u0001\u0000\u0000\u0000\u009b\u009c\u0006\b\uffff\uffff\u0000\u009c"+
		"\u009d\u0003&\u0013\u0000\u009d\u009e\u0006\b\uffff\uffff\u0000\u009e"+
		"\u00a1\u0001\u0000\u0000\u0000\u009f\u00a1\u0005\u000b\u0000\u0000\u00a0"+
		"\u0090\u0001\u0000\u0000\u0000\u00a0\u0093\u0001\u0000\u0000\u0000\u00a0"+
		"\u0094\u0001\u0000\u0000\u0000\u00a0\u0095\u0001\u0000\u0000\u0000\u00a0"+
		"\u0098\u0001\u0000\u0000\u0000\u00a0\u009b\u0001\u0000\u0000\u0000\u00a0"+
		"\u009f\u0001\u0000\u0000\u0000\u00a1\u0011\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a3\u0006\t\uffff\uffff\u0000\u00a3\u00a8\u0003\u0014\n\u0000\u00a4"+
		"\u00a5\u0005\f\u0000\u0000\u00a5\u00a7\u0003\u0014\n\u0000\u00a6\u00a4"+
		"\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000\u0000\u00a8\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000\u00a9\u0013"+
		"\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00ab\u00ac"+
		"\u0005\u0017\u0000\u0000\u00ac\u00b1\u0006\n\uffff\uffff\u0000\u00ad\u00ae"+
		"\u0003.\u0017\u0000\u00ae\u00af\u0006\n\uffff\uffff\u0000\u00af\u00b1"+
		"\u0001\u0000\u0000\u0000\u00b0\u00ab\u0001\u0000\u0000\u0000\u00b0\u00ad"+
		"\u0001\u0000\u0000\u0000\u00b1\u0015\u0001\u0000\u0000\u0000\u00b2\u00b3"+
		"\u0003\u0018\f\u0000\u00b3\u00bb\u0006\u000b\uffff\uffff\u0000\u00b4\u00b5"+
		"\u0005\f\u0000\u0000\u00b5\u00b6\u0006\u000b\uffff\uffff\u0000\u00b6\u00b7"+
		"\u0003\u0018\f\u0000\u00b7\u00b8\u0006\u000b\uffff\uffff\u0000\u00b8\u00ba"+
		"\u0001\u0000\u0000\u0000\u00b9\u00b4\u0001\u0000\u0000\u0000\u00ba\u00bd"+
		"\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000\u00bb\u00bc"+
		"\u0001\u0000\u0000\u0000\u00bc\u00c0\u0001\u0000\u0000\u0000\u00bd\u00bb"+
		"\u0001\u0000\u0000\u0000\u00be\u00c0\u0001\u0000\u0000\u0000\u00bf\u00b2"+
		"\u0001\u0000\u0000\u0000\u00bf\u00be\u0001\u0000\u0000\u0000\u00c0\u0017"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c6\u00030\u0018\u0000\u00c2\u00c6\u0003"+
		".\u0017\u0000\u00c3\u00c4\u0005\u0017\u0000\u0000\u00c4\u00c6\u0006\f"+
		"\uffff\uffff\u0000\u00c5\u00c1\u0001\u0000\u0000\u0000\u00c5\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c3\u0001\u0000\u0000\u0000\u00c6\u0019\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c8\u0005\u0017\u0000\u0000\u00c8\u00cd\u0006"+
		"\r\uffff\uffff\u0000\u00c9\u00ca\u0003.\u0017\u0000\u00ca\u00cb\u0006"+
		"\r\uffff\uffff\u0000\u00cb\u00cd\u0001\u0000\u0000\u0000\u00cc\u00c7\u0001"+
		"\u0000\u0000\u0000\u00cc\u00c9\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cf\u0005\r\u0000\u0000\u00cf\u00d2\u0006\r"+
		"\uffff\uffff\u0000\u00d0\u00d3\u0003&\u0013\u0000\u00d1\u00d3\u00030\u0018"+
		"\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d5\u0006\r\uffff\uffff"+
		"\u0000\u00d5\u00d6\u0006\r\uffff\uffff\u0000\u00d6\u001b\u0001\u0000\u0000"+
		"\u0000\u00d7\u00d8\u0005\u0005\u0000\u0000\u00d8\u00d9\u0006\u000e\uffff"+
		"\uffff\u0000\u00d9\u00da\u0003(\u0014\u0000\u00da\u00db\u0005\u0002\u0000"+
		"\u0000\u00db\u00dc\u0006\u000e\uffff\uffff\u0000\u00dc\u00dd\u0003\u000e"+
		"\u0007\u0000\u00dd\u00de\u0006\u000e\uffff\uffff\u0000\u00de\u00df\u0003"+
		"\u001e\u000f\u0000\u00df\u00ec\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005"+
		"\u0005\u0000\u0000\u00e1\u00e2\u0005\u0003\u0000\u0000\u00e2\u00e3\u0006"+
		"\u000e\uffff\uffff\u0000\u00e3\u00e4\u0003(\u0014\u0000\u00e4\u00e5\u0005"+
		"\u0004\u0000\u0000\u00e5\u00e6\u0005\u0002\u0000\u0000\u00e6\u00e7\u0006"+
		"\u000e\uffff\uffff\u0000\u00e7\u00e8\u0003\u000e\u0007\u0000\u00e8\u00e9"+
		"\u0006\u000e\uffff\uffff\u0000\u00e9\u00ea\u0003\u001e\u000f\u0000\u00ea"+
		"\u00ec\u0001\u0000\u0000\u0000\u00eb\u00d7\u0001\u0000\u0000\u0000\u00eb"+
		"\u00e0\u0001\u0000\u0000\u0000\u00ec\u001d\u0001\u0000\u0000\u0000\u00ed"+
		"\u00ee\u0005\u000e\u0000\u0000\u00ee\u00ef\u0005\u0002\u0000\u0000\u00ef"+
		"\u00f0\u0006\u000f\uffff\uffff\u0000\u00f0\u00f1\u0003\u000e\u0007\u0000"+
		"\u00f1\u00f2\u0006\u000f\uffff\uffff\u0000\u00f2\u00f5\u0001\u0000\u0000"+
		"\u0000\u00f3\u00f5\u0001\u0000\u0000\u0000\u00f4\u00ed\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f3\u0001\u0000\u0000\u0000\u00f5\u001f\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f7\u0005\u000f\u0000\u0000\u00f7\u00f8\u0006\u0010\uffff"+
		"\uffff\u0000\u00f8\u00f9\u0005\u0003\u0000\u0000\u00f9\u00fa\u0003(\u0014"+
		"\u0000\u00fa\u00fb\u0005\u0004\u0000\u0000\u00fb\u00fc\u0005\u0002\u0000"+
		"\u0000\u00fc\u00fd\u0006\u0010\uffff\uffff\u0000\u00fd\u00fe\u0003\u000e"+
		"\u0007\u0000\u00fe\u00ff\u0006\u0010\uffff\uffff\u0000\u00ff\u0109\u0001"+
		"\u0000\u0000\u0000\u0100\u0101\u0005\u000f\u0000\u0000\u0101\u0102\u0006"+
		"\u0010\uffff\uffff\u0000\u0102\u0103\u0003(\u0014\u0000\u0103\u0104\u0005"+
		"\u0002\u0000\u0000\u0104\u0105\u0006\u0010\uffff\uffff\u0000\u0105\u0106"+
		"\u0003\u000e\u0007\u0000\u0106\u0107\u0006\u0010\uffff\uffff\u0000\u0107"+
		"\u0109\u0001\u0000\u0000\u0000\u0108\u00f6\u0001\u0000\u0000\u0000\u0108"+
		"\u0100\u0001\u0000\u0000\u0000\u0109!\u0001\u0000\u0000\u0000\u010a\u010b"+
		"\u0005\u0010\u0000\u0000\u010b\u010c\u0006\u0011\uffff\uffff\u0000\u010c"+
		"\u010d\u0005\u0003\u0000\u0000\u010d\u0113\u00030\u0018\u0000\u010e\u010f"+
		"\u0005\f\u0000\u0000\u010f\u0110\u0006\u0011\uffff\uffff\u0000\u0110\u0112"+
		"\u00030\u0018\u0000\u0111\u010e\u0001\u0000\u0000\u0000\u0112\u0115\u0001"+
		"\u0000\u0000\u0000\u0113\u0111\u0001\u0000\u0000\u0000\u0113\u0114\u0001"+
		"\u0000\u0000\u0000\u0114\u0116\u0001\u0000\u0000\u0000\u0115\u0113\u0001"+
		"\u0000\u0000\u0000\u0116\u0117\u0005\u0004\u0000\u0000\u0117\u0118\u0006"+
		"\u0011\uffff\uffff\u0000\u0118#\u0001\u0000\u0000\u0000\u0119\u011a\u0005"+
		"\u0011\u0000\u0000\u011a\u011b\u0006\u0012\uffff\uffff\u0000\u011b\u011c"+
		"\u00030\u0018\u0000\u011c\u011d\u0006\u0012\uffff\uffff\u0000\u011d\u0126"+
		"\u0001\u0000\u0000\u0000\u011e\u011f\u0005\u0011\u0000\u0000\u011f\u0120"+
		"\u0005\u0003\u0000\u0000\u0120\u0121\u0006\u0012\uffff\uffff\u0000\u0121"+
		"\u0122\u00030\u0018\u0000\u0122\u0123\u0005\u0004\u0000\u0000\u0123\u0124"+
		"\u0006\u0012\uffff\uffff\u0000\u0124\u0126\u0001\u0000\u0000\u0000\u0125"+
		"\u0119\u0001\u0000\u0000\u0000\u0125\u011e\u0001\u0000\u0000\u0000\u0126"+
		"%\u0001\u0000\u0000\u0000\u0127\u0132\u0003.\u0017\u0000\u0128\u0129\u0005"+
		"\u0017\u0000\u0000\u0129\u012a\u0006\u0013\uffff\uffff\u0000\u012a\u012b"+
		"\u0001\u0000\u0000\u0000\u012b\u012c\u0005\u0003\u0000\u0000\u012c\u012d"+
		"\u0006\u0013\uffff\uffff\u0000\u012d\u012e\u0003\u0016\u000b\u0000\u012e"+
		"\u012f\u0005\u0004\u0000\u0000\u012f\u0130\u0006\u0013\uffff\uffff\u0000"+
		"\u0130\u0132\u0001\u0000\u0000\u0000\u0131\u0127\u0001\u0000\u0000\u0000"+
		"\u0131\u0128\u0001\u0000\u0000\u0000\u0132\'\u0001\u0000\u0000\u0000\u0133"+
		"\u0139\u0003*\u0015\u0000\u0134\u0135\u0005\u0012\u0000\u0000\u0135\u0136"+
		"\u0006\u0014\uffff\uffff\u0000\u0136\u0138\u0003*\u0015\u0000\u0137\u0134"+
		"\u0001\u0000\u0000\u0000\u0138\u013b\u0001\u0000\u0000\u0000\u0139\u0137"+
		"\u0001\u0000\u0000\u0000\u0139\u013a\u0001\u0000\u0000\u0000\u013a)\u0001"+
		"\u0000\u0000\u0000\u013b\u0139\u0001\u0000\u0000\u0000\u013c\u0142\u0003"+
		",\u0016\u0000\u013d\u013e\u0005\u0013\u0000\u0000\u013e\u013f\u0006\u0015"+
		"\uffff\uffff\u0000\u013f\u0141\u0003,\u0016\u0000\u0140\u013d\u0001\u0000"+
		"\u0000\u0000\u0141\u0144\u0001\u0000\u0000\u0000\u0142\u0140\u0001\u0000"+
		"\u0000\u0000\u0142\u0143\u0001\u0000\u0000\u0000\u0143+\u0001\u0000\u0000"+
		"\u0000\u0144\u0142\u0001\u0000\u0000\u0000\u0145\u0146\u0005\u0014\u0000"+
		"\u0000\u0146\u0147\u0005\u0003\u0000\u0000\u0147\u0148\u0006\u0016\uffff"+
		"\uffff\u0000\u0148\u0149\u0003(\u0014\u0000\u0149\u014a\u0005\u0004\u0000"+
		"\u0000\u014a\u014b\u0006\u0016\uffff\uffff\u0000\u014b\u0158\u0001\u0000"+
		"\u0000\u0000\u014c\u014d\u0005\u0003\u0000\u0000\u014d\u014e\u0006\u0016"+
		"\uffff\uffff\u0000\u014e\u014f\u0003(\u0014\u0000\u014f\u0150\u0005\u0004"+
		"\u0000\u0000\u0150\u0151\u0006\u0016\uffff\uffff\u0000\u0151\u0158\u0001"+
		"\u0000\u0000\u0000\u0152\u0153\u00030\u0018\u0000\u0153\u0154\u0005\u0019"+
		"\u0000\u0000\u0154\u0155\u0006\u0016\uffff\uffff\u0000\u0155\u0156\u0003"+
		"0\u0018\u0000\u0156\u0158\u0001\u0000\u0000\u0000\u0157\u0145\u0001\u0000"+
		"\u0000\u0000\u0157\u014c\u0001\u0000\u0000\u0000\u0157\u0152\u0001\u0000"+
		"\u0000\u0000\u0158-\u0001\u0000\u0000\u0000\u0159\u015a\u0005\u0017\u0000"+
		"\u0000\u015a\u015b\u0006\u0017\uffff\uffff\u0000\u015b\u015c\u0005\u0015"+
		"\u0000\u0000\u015c\u015d\u0005\u0017\u0000\u0000\u015d\u0166\u0006\u0017"+
		"\uffff\uffff\u0000\u015e\u015f\u0005\u0017\u0000\u0000\u015f\u0160\u0006"+
		"\u0017\uffff\uffff\u0000\u0160\u0161\u0005\u0015\u0000\u0000\u0161\u0162"+
		"\u0006\u0017\uffff\uffff\u0000\u0162\u0163\u0003&\u0013\u0000\u0163\u0164"+
		"\u0006\u0017\uffff\uffff\u0000\u0164\u0166\u0001\u0000\u0000\u0000\u0165"+
		"\u0159\u0001\u0000\u0000\u0000\u0165\u015e\u0001\u0000\u0000\u0000\u0166"+
		"/\u0001\u0000\u0000\u0000\u0167\u0168\u00036\u001b\u0000\u0168\u0169\u0006"+
		"\u0018\uffff\uffff\u0000\u0169\u016f\u00032\u0019\u0000\u016a\u016b\u0005"+
		"\u001a\u0000\u0000\u016b\u016c\u0006\u0018\uffff\uffff\u0000\u016c\u016e"+
		"\u00032\u0019\u0000\u016d\u016a\u0001\u0000\u0000\u0000\u016e\u0171\u0001"+
		"\u0000\u0000\u0000\u016f\u016d\u0001\u0000\u0000\u0000\u016f\u0170\u0001"+
		"\u0000\u0000\u0000\u01701\u0001\u0000\u0000\u0000\u0171\u016f\u0001\u0000"+
		"\u0000\u0000\u0172\u0178\u00034\u001a\u0000\u0173\u0174\u0005\u001b\u0000"+
		"\u0000\u0174\u0175\u0006\u0019\uffff\uffff\u0000\u0175\u0177\u00034\u001a"+
		"\u0000\u0176\u0173\u0001\u0000\u0000\u0000\u0177\u017a\u0001\u0000\u0000"+
		"\u0000\u0178\u0176\u0001\u0000\u0000\u0000\u0178\u0179\u0001\u0000\u0000"+
		"\u0000\u01793\u0001\u0000\u0000\u0000\u017a\u0178\u0001\u0000\u0000\u0000"+
		"\u017b\u017c\u0005\u0018\u0000\u0000\u017c\u0185\u0006\u001a\uffff\uffff"+
		"\u0000\u017d\u017e\u0005\u0017\u0000\u0000\u017e\u0185\u0006\u001a\uffff"+
		"\uffff\u0000\u017f\u0185\u0003.\u0017\u0000\u0180\u0181\u0005\u0003\u0000"+
		"\u0000\u0181\u0182\u00030\u0018\u0000\u0182\u0183\u0005\u0004\u0000\u0000"+
		"\u0183\u0185\u0001\u0000\u0000\u0000\u0184\u017b\u0001\u0000\u0000\u0000"+
		"\u0184\u017d\u0001\u0000\u0000\u0000\u0184\u017f\u0001\u0000\u0000\u0000"+
		"\u0184\u0180\u0001\u0000\u0000\u0000\u01855\u0001\u0000\u0000\u0000\u0186"+
		"\u0189\u0005\u001a\u0000\u0000\u0187\u0189\u0001\u0000\u0000\u0000\u0188"+
		"\u0186\u0001\u0000\u0000\u0000\u0188\u0187\u0001\u0000\u0000\u0000\u0189"+
		"7\u0001\u0000\u0000\u0000\u018a\u018b\u0005\u0015\u0000\u0000\u018b9\u0001"+
		"\u0000\u0000\u0000\u001d@Ytx\u0084\u008b\u008e\u00a0\u00a8\u00b0\u00bb"+
		"\u00bf\u00c5\u00cc\u00d2\u00eb\u00f4\u0108\u0113\u0125\u0131\u0139\u0142"+
		"\u0157\u0165\u016f\u0178\u0184\u0188";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}