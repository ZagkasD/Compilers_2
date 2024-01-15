// Generated from Language.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LanguageParser}.
 */
public interface LanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(LanguageParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(LanguageParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#classes}.
	 * @param ctx the parse tree
	 */
	void enterClasses(LanguageParser.ClassesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#classes}.
	 * @param ctx the parse tree
	 */
	void exitClasses(LanguageParser.ClassesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#class}.
	 * @param ctx the parse tree
	 */
	void enterClass(LanguageParser.ClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#class}.
	 * @param ctx the parse tree
	 */
	void exitClass(LanguageParser.ClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#initFunction}.
	 * @param ctx the parse tree
	 */
	void enterInitFunction(LanguageParser.InitFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#initFunction}.
	 * @param ctx the parse tree
	 */
	void exitInitFunction(LanguageParser.InitFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctions(LanguageParser.FunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctions(LanguageParser.FunctionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(LanguageParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(LanguageParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(LanguageParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(LanguageParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(LanguageParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(LanguageParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LanguageParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LanguageParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#assignmentStat}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStat(LanguageParser.AssignmentStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#assignmentStat}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStat(LanguageParser.AssignmentStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(LanguageParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(LanguageParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(LanguageParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#whileStat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(LanguageParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#printStat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(LanguageParser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#printStat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(LanguageParser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(LanguageParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#returnStat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(LanguageParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#callStat}.
	 * @param ctx the parse tree
	 */
	void enterCallStat(LanguageParser.CallStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#callStat}.
	 * @param ctx the parse tree
	 */
	void exitCallStat(LanguageParser.CallStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(LanguageParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(LanguageParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#boolterm}.
	 * @param ctx the parse tree
	 */
	void enterBoolterm(LanguageParser.BooltermContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#boolterm}.
	 * @param ctx the parse tree
	 */
	void exitBoolterm(LanguageParser.BooltermContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#boolfactor}.
	 * @param ctx the parse tree
	 */
	void enterBoolfactor(LanguageParser.BoolfactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#boolfactor}.
	 * @param ctx the parse tree
	 */
	void exitBoolfactor(LanguageParser.BoolfactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#elsepart}.
	 * @param ctx the parse tree
	 */
	void enterElsepart(LanguageParser.ElsepartContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#elsepart}.
	 * @param ctx the parse tree
	 */
	void exitElsepart(LanguageParser.ElsepartContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#formalparlist}.
	 * @param ctx the parse tree
	 */
	void enterFormalparlist(LanguageParser.FormalparlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#formalparlist}.
	 * @param ctx the parse tree
	 */
	void exitFormalparlist(LanguageParser.FormalparlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#formalparitem}.
	 * @param ctx the parse tree
	 */
	void enterFormalparitem(LanguageParser.FormalparitemContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#formalparitem}.
	 * @param ctx the parse tree
	 */
	void exitFormalparitem(LanguageParser.FormalparitemContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#obj}.
	 * @param ctx the parse tree
	 */
	void enterObj(LanguageParser.ObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#obj}.
	 * @param ctx the parse tree
	 */
	void exitObj(LanguageParser.ObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(LanguageParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(LanguageParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#optionalSign}.
	 * @param ctx the parse tree
	 */
	void enterOptionalSign(LanguageParser.OptionalSignContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#optionalSign}.
	 * @param ctx the parse tree
	 */
	void exitOptionalSign(LanguageParser.OptionalSignContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(LanguageParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(LanguageParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(LanguageParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(LanguageParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#actualparlist}.
	 * @param ctx the parse tree
	 */
	void enterActualparlist(LanguageParser.ActualparlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#actualparlist}.
	 * @param ctx the parse tree
	 */
	void exitActualparlist(LanguageParser.ActualparlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link LanguageParser#actualparitem}.
	 * @param ctx the parse tree
	 */
	void enterActualparitem(LanguageParser.ActualparitemContext ctx);
	/**
	 * Exit a parse tree produced by {@link LanguageParser#actualparitem}.
	 * @param ctx the parse tree
	 */
	void exitActualparitem(LanguageParser.ActualparitemContext ctx);
}