// Generated from grammar_v1.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class grammar_v1Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, NEWLINE=21, ID=22, INT=23, REL_OP=24, ADD_OP=25, 
		MUL_OP=26, COMMENT=27, WS=28;
	public static final int
		RULE_prog = 0, RULE_classes = 1, RULE_class = 2, RULE_initFunction = 3, 
		RULE_functions = 4, RULE_function = 5, RULE_statements = 6, RULE_statement = 7, 
		RULE_formalparlist = 8, RULE_formalparitem = 9, RULE_actualparlist = 10, 
		RULE_actualparitem = 11, RULE_assignmentStat = 12, RULE_ifStat = 13, RULE_elsepart = 14, 
		RULE_whileStat = 15, RULE_printStat = 16, RULE_returnStat = 17, RULE_callStat = 18, 
		RULE_condition = 19, RULE_boolterm = 20, RULE_boolfactor = 21, RULE_obj = 22, 
		RULE_expression = 23, RULE_term = 24, RULE_factor = 25, RULE_optionalSign = 26, 
		RULE_block = 27;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "classes", "class", "initFunction", "functions", "function", 
			"statements", "statement", "formalparlist", "formalparitem", "actualparlist", 
			"actualparitem", "assignmentStat", "ifStat", "elsepart", "whileStat", 
			"printStat", "returnStat", "callStat", "condition", "boolterm", "boolfactor", 
			"obj", "expression", "term", "factor", "optionalSign", "block"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'class'", "':'", "'def'", "'__init__'", "'('", "')'", "'pass'", 
			"'\\n'", "'\\t'", "','", "'='", "'if'", "'else'", "'while'", "'print'", 
			"'return'", "'or'", "'and'", "'not'", "'.'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "NEWLINE", "ID", 
			"INT", "REL_OP", "ADD_OP", "MUL_OP", "COMMENT", "WS"
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
	public String getGrammarFileName() { return "grammar_v1.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public grammar_v1Parser(TokenStream input) {
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
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitProg(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
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
		public List<ClassContext> class_() {
			return getRuleContexts(ClassContext.class);
		}
		public ClassContext class_(int i) {
			return getRuleContext(ClassContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(grammar_v1Parser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(grammar_v1Parser.NEWLINE, i);
		}
		public ClassesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterClasses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitClasses(this);
		}
	}

	public final ClassesContext classes() throws RecognitionException {
		ClassesContext _localctx = new ClassesContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			class_();
			setState(63);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(59);
				match(NEWLINE);
				setState(60);
				class_();
				}
				}
				setState(65);
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
	public static class ClassContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(grammar_v1Parser.ID, 0); }
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
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
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitClass(this);
		}
	}

	public final ClassContext class_() throws RecognitionException {
		ClassContext _localctx = new ClassContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_class);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(66);
			match(T__0);
			setState(67);
			match(ID);
			setState(68);
			match(T__1);
			setState(69);
			block();
			setState(70);
			initFunction();
			setState(71);
			block();
			setState(72);
			functions();
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterInitFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitInitFunction(this);
		}
	}

	public final InitFunctionContext initFunction() throws RecognitionException {
		InitFunctionContext _localctx = new InitFunctionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_initFunction);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(T__2);
			setState(75);
			match(T__3);
			setState(76);
			match(T__4);
			setState(77);
			formalparlist();
			setState(78);
			match(T__5);
			setState(79);
			match(T__1);
			setState(80);
			block();
			setState(83);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
			case T__11:
			case T__13:
			case T__14:
			case T__15:
			case ID:
				{
				setState(81);
				statements();
				}
				break;
			case T__6:
				{
				setState(82);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class FunctionsContext extends ParserRuleContext {
		public List<FunctionContext> function() {
			return getRuleContexts(FunctionContext.class);
		}
		public FunctionContext function(int i) {
			return getRuleContext(FunctionContext.class,i);
		}
		public List<BlockContext> block() {
			return getRuleContexts(BlockContext.class);
		}
		public BlockContext block(int i) {
			return getRuleContext(BlockContext.class,i);
		}
		public FunctionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterFunctions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitFunctions(this);
		}
	}

	public final FunctionsContext functions() throws RecognitionException {
		FunctionsContext _localctx = new FunctionsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functions);
		int _la;
		try {
			setState(95);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				function();
				setState(91);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__7) {
					{
					{
					setState(86);
					block();
					setState(87);
					function();
					}
					}
					setState(93);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case EOF:
			case NEWLINE:
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
		public TerminalNode ID() { return getToken(grammar_v1Parser.ID, 0); }
		public FormalparlistContext formalparlist() {
			return getRuleContext(FormalparlistContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
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
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitFunction(this);
		}
	}

	public final FunctionContext function() throws RecognitionException {
		FunctionContext _localctx = new FunctionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_function);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__2);
			setState(98);
			match(ID);
			setState(99);
			match(T__4);
			setState(100);
			formalparlist();
			setState(101);
			match(T__5);
			setState(102);
			match(T__1);
			setState(103);
			block();
			setState(106);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case EOF:
			case T__7:
			case T__11:
			case T__13:
			case T__14:
			case T__15:
			case NEWLINE:
			case ID:
				{
				setState(104);
				statements();
				}
				break;
			case T__6:
				{
				setState(105);
				match(T__6);
				}
				break;
			default:
				throw new NoViableAltException(this);
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
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitStatements(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statements);
		int _la;
		try {
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4313088L) != 0)) {
					{
					{
					setState(108);
					statement();
					setState(109);
					match(T__7);
					setState(110);
					match(T__8);
					}
					}
					setState(116);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_statement);
		try {
			setState(126);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(120);
				assignmentStat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(121);
				ifStat();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(122);
				whileStat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(123);
				printStat();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(124);
				returnStat();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(125);
				callStat();
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
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterFormalparlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitFormalparlist(this);
		}
	}

	public final FormalparlistContext formalparlist() throws RecognitionException {
		FormalparlistContext _localctx = new FormalparlistContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_formalparlist);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			formalparitem();
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__9) {
				{
				{
				setState(129);
				match(T__9);
				setState(130);
				formalparitem();
				}
				}
				setState(135);
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
		public TerminalNode ID() { return getToken(grammar_v1Parser.ID, 0); }
		public ObjContext obj() {
			return getRuleContext(ObjContext.class,0);
		}
		public FormalparitemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalparitem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterFormalparitem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitFormalparitem(this);
		}
	}

	public final FormalparitemContext formalparitem() throws RecognitionException {
		FormalparitemContext _localctx = new FormalparitemContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_formalparitem);
		try {
			setState(138);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136);
				match(ID);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(137);
				obj();
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
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterActualparlist(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitActualparlist(this);
		}
	}

	public final ActualparlistContext actualparlist() throws RecognitionException {
		ActualparlistContext _localctx = new ActualparlistContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_actualparlist);
		int _la;
		try {
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__4:
			case ID:
			case INT:
			case ADD_OP:
				enterOuterAlt(_localctx, 1);
				{
				setState(140);
				actualparitem();
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__9) {
					{
					{
					setState(141);
					match(T__9);
					setState(142);
					actualparitem();
					}
					}
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case T__5:
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ObjContext obj() {
			return getRuleContext(ObjContext.class,0);
		}
		public TerminalNode ID() { return getToken(grammar_v1Parser.ID, 0); }
		public ActualparitemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualparitem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterActualparitem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitActualparitem(this);
		}
	}

	public final ActualparitemContext actualparitem() throws RecognitionException {
		ActualparitemContext _localctx = new ActualparitemContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_actualparitem);
		try {
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(151);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(152);
				obj();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(153);
				match(ID);
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
		public TerminalNode ID() { return getToken(grammar_v1Parser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterAssignmentStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitAssignmentStat(this);
		}
	}

	public final AssignmentStatContext assignmentStat() throws RecognitionException {
		AssignmentStatContext _localctx = new AssignmentStatContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_assignmentStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(ID);
			setState(157);
			match(T__10);
			setState(158);
			expression();
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
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitIfStat(this);
		}
	}

	public final IfStatContext ifStat() throws RecognitionException {
		IfStatContext _localctx = new IfStatContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_ifStat);
		try {
			setState(174);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160);
				match(T__11);
				setState(161);
				condition();
				setState(162);
				match(T__1);
				setState(163);
				statements();
				setState(164);
				elsepart();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				match(T__11);
				setState(167);
				match(T__4);
				setState(168);
				condition();
				setState(169);
				match(T__5);
				setState(170);
				match(T__1);
				setState(171);
				statements();
				setState(172);
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
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterElsepart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitElsepart(this);
		}
	}

	public final ElsepartContext elsepart() throws RecognitionException {
		ElsepartContext _localctx = new ElsepartContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_elsepart);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__12:
				enterOuterAlt(_localctx, 1);
				{
				setState(176);
				match(T__12);
				setState(177);
				match(T__1);
				setState(178);
				statements();
				}
				break;
			case T__7:
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
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitWhileStat(this);
		}
	}

	public final WhileStatContext whileStat() throws RecognitionException {
		WhileStatContext _localctx = new WhileStatContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_whileStat);
		try {
			setState(194);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182);
				match(T__13);
				setState(183);
				match(T__4);
				setState(184);
				condition();
				setState(185);
				match(T__5);
				setState(186);
				match(T__1);
				setState(187);
				statements();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(189);
				match(T__13);
				setState(190);
				condition();
				setState(191);
				match(T__1);
				setState(192);
				statements();
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
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterPrintStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitPrintStat(this);
		}
	}

	public final PrintStatContext printStat() throws RecognitionException {
		PrintStatContext _localctx = new PrintStatContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_printStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			match(T__14);
			setState(197);
			match(T__4);
			setState(198);
			expression();
			setState(199);
			match(T__5);
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
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterReturnStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitReturnStat(this);
		}
	}

	public final ReturnStatContext returnStat() throws RecognitionException {
		ReturnStatContext _localctx = new ReturnStatContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_returnStat);
		try {
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(201);
				match(T__15);
				setState(202);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(203);
				match(T__15);
				setState(204);
				match(T__4);
				setState(205);
				expression();
				setState(206);
				match(T__5);
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
		public TerminalNode ID() { return getToken(grammar_v1Parser.ID, 0); }
		public ActualparlistContext actualparlist() {
			return getRuleContext(ActualparlistContext.class,0);
		}
		public CallStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callStat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterCallStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitCallStat(this);
		}
	}

	public final CallStatContext callStat() throws RecognitionException {
		CallStatContext _localctx = new CallStatContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_callStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			match(ID);
			setState(211);
			match(T__4);
			setState(212);
			actualparlist();
			setState(213);
			match(T__5);
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
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
			boolterm();
			setState(220);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
				setState(216);
				match(T__16);
				setState(217);
				boolterm();
				}
				}
				setState(222);
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
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterBoolterm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitBoolterm(this);
		}
	}

	public final BooltermContext boolterm() throws RecognitionException {
		BooltermContext _localctx = new BooltermContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_boolterm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(223);
			boolfactor();
			setState(228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__17) {
				{
				{
				setState(224);
				match(T__17);
				setState(225);
				boolfactor();
				}
				}
				setState(230);
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
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode REL_OP() { return getToken(grammar_v1Parser.REL_OP, 0); }
		public BoolfactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolfactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterBoolfactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitBoolfactor(this);
		}
	}

	public final BoolfactorContext boolfactor() throws RecognitionException {
		BoolfactorContext _localctx = new BoolfactorContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_boolfactor);
		try {
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				match(T__18);
				setState(232);
				match(T__4);
				setState(233);
				condition();
				setState(234);
				match(T__5);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				match(T__4);
				setState(237);
				condition();
				setState(238);
				match(T__5);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(240);
				expression();
				setState(241);
				match(REL_OP);
				setState(242);
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
		public List<TerminalNode> ID() { return getTokens(grammar_v1Parser.ID); }
		public TerminalNode ID(int i) {
			return getToken(grammar_v1Parser.ID, i);
		}
		public AssignmentStatContext assignmentStat() {
			return getRuleContext(AssignmentStatContext.class,0);
		}
		public ObjContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_obj; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterObj(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitObj(this);
		}
	}

	public final ObjContext obj() throws RecognitionException {
		ObjContext _localctx = new ObjContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_obj);
		try {
			setState(253);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(246);
				match(ID);
				setState(247);
				match(T__19);
				setState(248);
				match(ID);
				setState(249);
				assignmentStat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(250);
				match(ID);
				setState(251);
				match(T__19);
				setState(252);
				match(ID);
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
		public OptionalSignContext optionalSign() {
			return getRuleContext(OptionalSignContext.class,0);
		}
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> ADD_OP() { return getTokens(grammar_v1Parser.ADD_OP); }
		public TerminalNode ADD_OP(int i) {
			return getToken(grammar_v1Parser.ADD_OP, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(255);
			optionalSign();
			setState(256);
			term();
			setState(261);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(257);
					match(ADD_OP);
					setState(258);
					term();
					}
					} 
				}
				setState(263);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MUL_OP() { return getTokens(grammar_v1Parser.MUL_OP); }
		public TerminalNode MUL_OP(int i) {
			return getToken(grammar_v1Parser.MUL_OP, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_term);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			factor();
			setState(269);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(265);
					match(MUL_OP);
					setState(266);
					factor();
					}
					} 
				}
				setState(271);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
		public TerminalNode INT() { return getToken(grammar_v1Parser.INT, 0); }
		public TerminalNode ID() { return getToken(grammar_v1Parser.ID, 0); }
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
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitFactor(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_factor);
		try {
			setState(279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(272);
				match(INT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(273);
				match(ID);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(274);
				obj();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(275);
				match(T__4);
				setState(276);
				expression();
				setState(277);
				match(T__5);
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
		public TerminalNode ADD_OP() { return getToken(grammar_v1Parser.ADD_OP, 0); }
		public OptionalSignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_optionalSign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterOptionalSign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitOptionalSign(this);
		}
	}

	public final OptionalSignContext optionalSign() throws RecognitionException {
		OptionalSignContext _localctx = new OptionalSignContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_optionalSign);
		try {
			setState(283);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD_OP:
				enterOuterAlt(_localctx, 1);
				{
				setState(281);
				match(ADD_OP);
				}
				break;
			case T__4:
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
	public static class BlockContext extends ParserRuleContext {
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof grammar_v1Listener ) ((grammar_v1Listener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(T__7);
			setState(286);
			match(T__8);
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
		"\u0004\u0001\u001c\u0121\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0005"+
		"\u0001>\b\u0001\n\u0001\f\u0001A\t\u0001\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003T\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004Z\b\u0004\n\u0004\f\u0004]\t"+
		"\u0004\u0001\u0004\u0003\u0004`\b\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0003\u0005k\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006q\b\u0006\n\u0006\f\u0006t\t\u0006\u0001\u0006\u0003"+
		"\u0006w\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0003\u0007\u007f\b\u0007\u0001\b\u0001\b\u0001\b\u0005"+
		"\b\u0084\b\b\n\b\f\b\u0087\t\b\u0001\t\u0001\t\u0003\t\u008b\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0005\n\u0090\b\n\n\n\f\n\u0093\t\n\u0001\n\u0003\n"+
		"\u0096\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u009b\b\u000b"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0003\r\u00af\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u00b5\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0003\u000f\u00c3\b\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u00d1\b\u0011\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0005\u0013\u00db\b\u0013\n\u0013\f\u0013\u00de\t\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u00e3\b\u0014\n\u0014"+
		"\f\u0014\u00e6\t\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u00f5\b\u0015\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0003\u0016\u00fe\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0005\u0017\u0104\b\u0017\n\u0017\f\u0017\u0107\t\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0005\u0018\u010c\b\u0018\n\u0018\f\u0018\u010f\t\u0018"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u0118\b\u0019\u0001\u001a\u0001\u001a\u0003\u001a"+
		"\u011c\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0000\u0000"+
		"\u001c\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.0246\u0000\u0000\u0125\u00008\u0001\u0000\u0000"+
		"\u0000\u0002:\u0001\u0000\u0000\u0000\u0004B\u0001\u0000\u0000\u0000\u0006"+
		"J\u0001\u0000\u0000\u0000\b_\u0001\u0000\u0000\u0000\na\u0001\u0000\u0000"+
		"\u0000\fv\u0001\u0000\u0000\u0000\u000e~\u0001\u0000\u0000\u0000\u0010"+
		"\u0080\u0001\u0000\u0000\u0000\u0012\u008a\u0001\u0000\u0000\u0000\u0014"+
		"\u0095\u0001\u0000\u0000\u0000\u0016\u009a\u0001\u0000\u0000\u0000\u0018"+
		"\u009c\u0001\u0000\u0000\u0000\u001a\u00ae\u0001\u0000\u0000\u0000\u001c"+
		"\u00b4\u0001\u0000\u0000\u0000\u001e\u00c2\u0001\u0000\u0000\u0000 \u00c4"+
		"\u0001\u0000\u0000\u0000\"\u00d0\u0001\u0000\u0000\u0000$\u00d2\u0001"+
		"\u0000\u0000\u0000&\u00d7\u0001\u0000\u0000\u0000(\u00df\u0001\u0000\u0000"+
		"\u0000*\u00f4\u0001\u0000\u0000\u0000,\u00fd\u0001\u0000\u0000\u0000."+
		"\u00ff\u0001\u0000\u0000\u00000\u0108\u0001\u0000\u0000\u00002\u0117\u0001"+
		"\u0000\u0000\u00004\u011b\u0001\u0000\u0000\u00006\u011d\u0001\u0000\u0000"+
		"\u000089\u0003\u0002\u0001\u00009\u0001\u0001\u0000\u0000\u0000:?\u0003"+
		"\u0004\u0002\u0000;<\u0005\u0015\u0000\u0000<>\u0003\u0004\u0002\u0000"+
		"=;\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?=\u0001\u0000\u0000"+
		"\u0000?@\u0001\u0000\u0000\u0000@\u0003\u0001\u0000\u0000\u0000A?\u0001"+
		"\u0000\u0000\u0000BC\u0005\u0001\u0000\u0000CD\u0005\u0016\u0000\u0000"+
		"DE\u0005\u0002\u0000\u0000EF\u00036\u001b\u0000FG\u0003\u0006\u0003\u0000"+
		"GH\u00036\u001b\u0000HI\u0003\b\u0004\u0000I\u0005\u0001\u0000\u0000\u0000"+
		"JK\u0005\u0003\u0000\u0000KL\u0005\u0004\u0000\u0000LM\u0005\u0005\u0000"+
		"\u0000MN\u0003\u0010\b\u0000NO\u0005\u0006\u0000\u0000OP\u0005\u0002\u0000"+
		"\u0000PS\u00036\u001b\u0000QT\u0003\f\u0006\u0000RT\u0005\u0007\u0000"+
		"\u0000SQ\u0001\u0000\u0000\u0000SR\u0001\u0000\u0000\u0000T\u0007\u0001"+
		"\u0000\u0000\u0000U[\u0003\n\u0005\u0000VW\u00036\u001b\u0000WX\u0003"+
		"\n\u0005\u0000XZ\u0001\u0000\u0000\u0000YV\u0001\u0000\u0000\u0000Z]\u0001"+
		"\u0000\u0000\u0000[Y\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000"+
		"\\`\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^`\u0001\u0000\u0000"+
		"\u0000_U\u0001\u0000\u0000\u0000_^\u0001\u0000\u0000\u0000`\t\u0001\u0000"+
		"\u0000\u0000ab\u0005\u0003\u0000\u0000bc\u0005\u0016\u0000\u0000cd\u0005"+
		"\u0005\u0000\u0000de\u0003\u0010\b\u0000ef\u0005\u0006\u0000\u0000fg\u0005"+
		"\u0002\u0000\u0000gj\u00036\u001b\u0000hk\u0003\f\u0006\u0000ik\u0005"+
		"\u0007\u0000\u0000jh\u0001\u0000\u0000\u0000ji\u0001\u0000\u0000\u0000"+
		"k\u000b\u0001\u0000\u0000\u0000lm\u0003\u000e\u0007\u0000mn\u0005\b\u0000"+
		"\u0000no\u0005\t\u0000\u0000oq\u0001\u0000\u0000\u0000pl\u0001\u0000\u0000"+
		"\u0000qt\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rs\u0001\u0000"+
		"\u0000\u0000sw\u0001\u0000\u0000\u0000tr\u0001\u0000\u0000\u0000uw\u0001"+
		"\u0000\u0000\u0000vr\u0001\u0000\u0000\u0000vu\u0001\u0000\u0000\u0000"+
		"w\r\u0001\u0000\u0000\u0000x\u007f\u0003\u0018\f\u0000y\u007f\u0003\u001a"+
		"\r\u0000z\u007f\u0003\u001e\u000f\u0000{\u007f\u0003 \u0010\u0000|\u007f"+
		"\u0003\"\u0011\u0000}\u007f\u0003$\u0012\u0000~x\u0001\u0000\u0000\u0000"+
		"~y\u0001\u0000\u0000\u0000~z\u0001\u0000\u0000\u0000~{\u0001\u0000\u0000"+
		"\u0000~|\u0001\u0000\u0000\u0000~}\u0001\u0000\u0000\u0000\u007f\u000f"+
		"\u0001\u0000\u0000\u0000\u0080\u0085\u0003\u0012\t\u0000\u0081\u0082\u0005"+
		"\n\u0000\u0000\u0082\u0084\u0003\u0012\t\u0000\u0083\u0081\u0001\u0000"+
		"\u0000\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000"+
		"\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086\u0011\u0001\u0000"+
		"\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088\u008b\u0005\u0016"+
		"\u0000\u0000\u0089\u008b\u0003,\u0016\u0000\u008a\u0088\u0001\u0000\u0000"+
		"\u0000\u008a\u0089\u0001\u0000\u0000\u0000\u008b\u0013\u0001\u0000\u0000"+
		"\u0000\u008c\u0091\u0003\u0016\u000b\u0000\u008d\u008e\u0005\n\u0000\u0000"+
		"\u008e\u0090\u0003\u0016\u000b\u0000\u008f\u008d\u0001\u0000\u0000\u0000"+
		"\u0090\u0093\u0001\u0000\u0000\u0000\u0091\u008f\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0096\u0001\u0000\u0000\u0000"+
		"\u0093\u0091\u0001\u0000\u0000\u0000\u0094\u0096\u0001\u0000\u0000\u0000"+
		"\u0095\u008c\u0001\u0000\u0000\u0000\u0095\u0094\u0001\u0000\u0000\u0000"+
		"\u0096\u0015\u0001\u0000\u0000\u0000\u0097\u009b\u0003.\u0017\u0000\u0098"+
		"\u009b\u0003,\u0016\u0000\u0099\u009b\u0005\u0016\u0000\u0000\u009a\u0097"+
		"\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000\u009a\u0099"+
		"\u0001\u0000\u0000\u0000\u009b\u0017\u0001\u0000\u0000\u0000\u009c\u009d"+
		"\u0005\u0016\u0000\u0000\u009d\u009e\u0005\u000b\u0000\u0000\u009e\u009f"+
		"\u0003.\u0017\u0000\u009f\u0019\u0001\u0000\u0000\u0000\u00a0\u00a1\u0005"+
		"\f\u0000\u0000\u00a1\u00a2\u0003&\u0013\u0000\u00a2\u00a3\u0005\u0002"+
		"\u0000\u0000\u00a3\u00a4\u0003\f\u0006\u0000\u00a4\u00a5\u0003\u001c\u000e"+
		"\u0000\u00a5\u00af\u0001\u0000\u0000\u0000\u00a6\u00a7\u0005\f\u0000\u0000"+
		"\u00a7\u00a8\u0005\u0005\u0000\u0000\u00a8\u00a9\u0003&\u0013\u0000\u00a9"+
		"\u00aa\u0005\u0006\u0000\u0000\u00aa\u00ab\u0005\u0002\u0000\u0000\u00ab"+
		"\u00ac\u0003\f\u0006\u0000\u00ac\u00ad\u0003\u001c\u000e\u0000\u00ad\u00af"+
		"\u0001\u0000\u0000\u0000\u00ae\u00a0\u0001\u0000\u0000\u0000\u00ae\u00a6"+
		"\u0001\u0000\u0000\u0000\u00af\u001b\u0001\u0000\u0000\u0000\u00b0\u00b1"+
		"\u0005\r\u0000\u0000\u00b1\u00b2\u0005\u0002\u0000\u0000\u00b2\u00b5\u0003"+
		"\f\u0006\u0000\u00b3\u00b5\u0001\u0000\u0000\u0000\u00b4\u00b0\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b3\u0001\u0000\u0000\u0000\u00b5\u001d\u0001\u0000"+
		"\u0000\u0000\u00b6\u00b7\u0005\u000e\u0000\u0000\u00b7\u00b8\u0005\u0005"+
		"\u0000\u0000\u00b8\u00b9\u0003&\u0013\u0000\u00b9\u00ba\u0005\u0006\u0000"+
		"\u0000\u00ba\u00bb\u0005\u0002\u0000\u0000\u00bb\u00bc\u0003\f\u0006\u0000"+
		"\u00bc\u00c3\u0001\u0000\u0000\u0000\u00bd\u00be\u0005\u000e\u0000\u0000"+
		"\u00be\u00bf\u0003&\u0013\u0000\u00bf\u00c0\u0005\u0002\u0000\u0000\u00c0"+
		"\u00c1\u0003\f\u0006\u0000\u00c1\u00c3\u0001\u0000\u0000\u0000\u00c2\u00b6"+
		"\u0001\u0000\u0000\u0000\u00c2\u00bd\u0001\u0000\u0000\u0000\u00c3\u001f"+
		"\u0001\u0000\u0000\u0000\u00c4\u00c5\u0005\u000f\u0000\u0000\u00c5\u00c6"+
		"\u0005\u0005\u0000\u0000\u00c6\u00c7\u0003.\u0017\u0000\u00c7\u00c8\u0005"+
		"\u0006\u0000\u0000\u00c8!\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005\u0010"+
		"\u0000\u0000\u00ca\u00d1\u0003.\u0017\u0000\u00cb\u00cc\u0005\u0010\u0000"+
		"\u0000\u00cc\u00cd\u0005\u0005\u0000\u0000\u00cd\u00ce\u0003.\u0017\u0000"+
		"\u00ce\u00cf\u0005\u0006\u0000\u0000\u00cf\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d0\u00c9\u0001\u0000\u0000\u0000\u00d0\u00cb\u0001\u0000\u0000\u0000"+
		"\u00d1#\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005\u0016\u0000\u0000\u00d3"+
		"\u00d4\u0005\u0005\u0000\u0000\u00d4\u00d5\u0003\u0014\n\u0000\u00d5\u00d6"+
		"\u0005\u0006\u0000\u0000\u00d6%\u0001\u0000\u0000\u0000\u00d7\u00dc\u0003"+
		"(\u0014\u0000\u00d8\u00d9\u0005\u0011\u0000\u0000\u00d9\u00db\u0003(\u0014"+
		"\u0000\u00da\u00d8\u0001\u0000\u0000\u0000\u00db\u00de\u0001\u0000\u0000"+
		"\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dc\u00dd\u0001\u0000\u0000"+
		"\u0000\u00dd\'\u0001\u0000\u0000\u0000\u00de\u00dc\u0001\u0000\u0000\u0000"+
		"\u00df\u00e4\u0003*\u0015\u0000\u00e0\u00e1\u0005\u0012\u0000\u0000\u00e1"+
		"\u00e3\u0003*\u0015\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e3\u00e6"+
		"\u0001\u0000\u0000\u0000\u00e4\u00e2\u0001\u0000\u0000\u0000\u00e4\u00e5"+
		"\u0001\u0000\u0000\u0000\u00e5)\u0001\u0000\u0000\u0000\u00e6\u00e4\u0001"+
		"\u0000\u0000\u0000\u00e7\u00e8\u0005\u0013\u0000\u0000\u00e8\u00e9\u0005"+
		"\u0005\u0000\u0000\u00e9\u00ea\u0003&\u0013\u0000\u00ea\u00eb\u0005\u0006"+
		"\u0000\u0000\u00eb\u00f5\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005\u0005"+
		"\u0000\u0000\u00ed\u00ee\u0003&\u0013\u0000\u00ee\u00ef\u0005\u0006\u0000"+
		"\u0000\u00ef\u00f5\u0001\u0000\u0000\u0000\u00f0\u00f1\u0003.\u0017\u0000"+
		"\u00f1\u00f2\u0005\u0018\u0000\u0000\u00f2\u00f3\u0003.\u0017\u0000\u00f3"+
		"\u00f5\u0001\u0000\u0000\u0000\u00f4\u00e7\u0001\u0000\u0000\u0000\u00f4"+
		"\u00ec\u0001\u0000\u0000\u0000\u00f4\u00f0\u0001\u0000\u0000\u0000\u00f5"+
		"+\u0001\u0000\u0000\u0000\u00f6\u00f7\u0005\u0016\u0000\u0000\u00f7\u00f8"+
		"\u0005\u0014\u0000\u0000\u00f8\u00f9\u0005\u0016\u0000\u0000\u00f9\u00fe"+
		"\u0003\u0018\f\u0000\u00fa\u00fb\u0005\u0016\u0000\u0000\u00fb\u00fc\u0005"+
		"\u0014\u0000\u0000\u00fc\u00fe\u0005\u0016\u0000\u0000\u00fd\u00f6\u0001"+
		"\u0000\u0000\u0000\u00fd\u00fa\u0001\u0000\u0000\u0000\u00fe-\u0001\u0000"+
		"\u0000\u0000\u00ff\u0100\u00034\u001a\u0000\u0100\u0105\u00030\u0018\u0000"+
		"\u0101\u0102\u0005\u0019\u0000\u0000\u0102\u0104\u00030\u0018\u0000\u0103"+
		"\u0101\u0001\u0000\u0000\u0000\u0104\u0107\u0001\u0000\u0000\u0000\u0105"+
		"\u0103\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106"+
		"/\u0001\u0000\u0000\u0000\u0107\u0105\u0001\u0000\u0000\u0000\u0108\u010d"+
		"\u00032\u0019\u0000\u0109\u010a\u0005\u001a\u0000\u0000\u010a\u010c\u0003"+
		"2\u0019\u0000\u010b\u0109\u0001\u0000\u0000\u0000\u010c\u010f\u0001\u0000"+
		"\u0000\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010d\u010e\u0001\u0000"+
		"\u0000\u0000\u010e1\u0001\u0000\u0000\u0000\u010f\u010d\u0001\u0000\u0000"+
		"\u0000\u0110\u0118\u0005\u0017\u0000\u0000\u0111\u0118\u0005\u0016\u0000"+
		"\u0000\u0112\u0118\u0003,\u0016\u0000\u0113\u0114\u0005\u0005\u0000\u0000"+
		"\u0114\u0115\u0003.\u0017\u0000\u0115\u0116\u0005\u0006\u0000\u0000\u0116"+
		"\u0118\u0001\u0000\u0000\u0000\u0117\u0110\u0001\u0000\u0000\u0000\u0117"+
		"\u0111\u0001\u0000\u0000\u0000\u0117\u0112\u0001\u0000\u0000\u0000\u0117"+
		"\u0113\u0001\u0000\u0000\u0000\u01183\u0001\u0000\u0000\u0000\u0119\u011c"+
		"\u0005\u0019\u0000\u0000\u011a\u011c\u0001\u0000\u0000\u0000\u011b\u0119"+
		"\u0001\u0000\u0000\u0000\u011b\u011a\u0001\u0000\u0000\u0000\u011c5\u0001"+
		"\u0000\u0000\u0000\u011d\u011e\u0005\b\u0000\u0000\u011e\u011f\u0005\t"+
		"\u0000\u0000\u011f7\u0001\u0000\u0000\u0000\u0019?S[_jrv~\u0085\u008a"+
		"\u0091\u0095\u009a\u00ae\u00b4\u00c2\u00d0\u00dc\u00e4\u00f4\u00fd\u0105"+
		"\u010d\u0117\u011b";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}