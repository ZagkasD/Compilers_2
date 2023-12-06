// Generated from grammar_v1.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link grammar_v1Parser}.
 */
public interface grammar_v1Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(grammar_v1Parser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(grammar_v1Parser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(grammar_v1Parser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(grammar_v1Parser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#classes}.
	 * @param ctx the parse tree
	 */
	void enterClasses(grammar_v1Parser.ClassesContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#classes}.
	 * @param ctx the parse tree
	 */
	void exitClasses(grammar_v1Parser.ClassesContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#class}.
	 * @param ctx the parse tree
	 */
	void enterClass(grammar_v1Parser.ClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#class}.
	 * @param ctx the parse tree
	 */
	void exitClass(grammar_v1Parser.ClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#initFunction}.
	 * @param ctx the parse tree
	 */
	void enterInitFunction(grammar_v1Parser.InitFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#initFunction}.
	 * @param ctx the parse tree
	 */
	void exitInitFunction(grammar_v1Parser.InitFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctions(grammar_v1Parser.FunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctions(grammar_v1Parser.FunctionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(grammar_v1Parser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(grammar_v1Parser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(grammar_v1Parser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(grammar_v1Parser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(grammar_v1Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(grammar_v1Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#formalparlist}.
	 * @param ctx the parse tree
	 */
	void enterFormalparlist(grammar_v1Parser.FormalparlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#formalparlist}.
	 * @param ctx the parse tree
	 */
	void exitFormalparlist(grammar_v1Parser.FormalparlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#formalparitem}.
	 * @param ctx the parse tree
	 */
	void enterFormalparitem(grammar_v1Parser.FormalparitemContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#formalparitem}.
	 * @param ctx the parse tree
	 */
	void exitFormalparitem(grammar_v1Parser.FormalparitemContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#actualparlist}.
	 * @param ctx the parse tree
	 */
	void enterActualparlist(grammar_v1Parser.ActualparlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#actualparlist}.
	 * @param ctx the parse tree
	 */
	void exitActualparlist(grammar_v1Parser.ActualparlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#actualparitem}.
	 * @param ctx the parse tree
	 */
	void enterActualparitem(grammar_v1Parser.ActualparitemContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#actualparitem}.
	 * @param ctx the parse tree
	 */
	void exitActualparitem(grammar_v1Parser.ActualparitemContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#assignmentStat}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStat(grammar_v1Parser.AssignmentStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#assignmentStat}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStat(grammar_v1Parser.AssignmentStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(grammar_v1Parser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(grammar_v1Parser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#elsepart}.
	 * @param ctx the parse tree
	 */
	void enterElsepart(grammar_v1Parser.ElsepartContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#elsepart}.
	 * @param ctx the parse tree
	 */
	void exitElsepart(grammar_v1Parser.ElsepartContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#whileStat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(grammar_v1Parser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#whileStat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(grammar_v1Parser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#printStat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(grammar_v1Parser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#printStat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(grammar_v1Parser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#returnStat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(grammar_v1Parser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#returnStat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(grammar_v1Parser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#callStat}.
	 * @param ctx the parse tree
	 */
	void enterCallStat(grammar_v1Parser.CallStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#callStat}.
	 * @param ctx the parse tree
	 */
	void exitCallStat(grammar_v1Parser.CallStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(grammar_v1Parser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(grammar_v1Parser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#boolterm}.
	 * @param ctx the parse tree
	 */
	void enterBoolterm(grammar_v1Parser.BooltermContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#boolterm}.
	 * @param ctx the parse tree
	 */
	void exitBoolterm(grammar_v1Parser.BooltermContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#boolfactor}.
	 * @param ctx the parse tree
	 */
	void enterBoolfactor(grammar_v1Parser.BoolfactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#boolfactor}.
	 * @param ctx the parse tree
	 */
	void exitBoolfactor(grammar_v1Parser.BoolfactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#obj}.
	 * @param ctx the parse tree
	 */
	void enterObj(grammar_v1Parser.ObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#obj}.
	 * @param ctx the parse tree
	 */
	void exitObj(grammar_v1Parser.ObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(grammar_v1Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(grammar_v1Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(grammar_v1Parser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(grammar_v1Parser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(grammar_v1Parser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(grammar_v1Parser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#optionalSign}.
	 * @param ctx the parse tree
	 */
	void enterOptionalSign(grammar_v1Parser.OptionalSignContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#optionalSign}.
	 * @param ctx the parse tree
	 */
	void exitOptionalSign(grammar_v1Parser.OptionalSignContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(grammar_v1Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(grammar_v1Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#printTabs}.
	 * @param ctx the parse tree
	 */
	void enterPrintTabs(grammar_v1Parser.PrintTabsContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#printTabs}.
	 * @param ctx the parse tree
	 */
	void exitPrintTabs(grammar_v1Parser.PrintTabsContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#tabs}.
	 * @param ctx the parse tree
	 */
	void enterTabs(grammar_v1Parser.TabsContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#tabs}.
	 * @param ctx the parse tree
	 */
	void exitTabs(grammar_v1Parser.TabsContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v1Parser#point}.
	 * @param ctx the parse tree
	 */
	void enterPoint(grammar_v1Parser.PointContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v1Parser#point}.
	 * @param ctx the parse tree
	 */
	void exitPoint(grammar_v1Parser.PointContext ctx);
}