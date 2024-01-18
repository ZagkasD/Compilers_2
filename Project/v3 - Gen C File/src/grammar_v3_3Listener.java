// Generated from grammar_v3_3.g4 by ANTLR 4.13.1

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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link grammar_v3_3Parser}.
 */
public interface grammar_v3_3Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(grammar_v3_3Parser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(grammar_v3_3Parser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#classes}.
	 * @param ctx the parse tree
	 */
	void enterClasses(grammar_v3_3Parser.ClassesContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#classes}.
	 * @param ctx the parse tree
	 */
	void exitClasses(grammar_v3_3Parser.ClassesContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#class}.
	 * @param ctx the parse tree
	 */
	void enterClass(grammar_v3_3Parser.ClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#class}.
	 * @param ctx the parse tree
	 */
	void exitClass(grammar_v3_3Parser.ClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(grammar_v3_3Parser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(grammar_v3_3Parser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#initFunction}.
	 * @param ctx the parse tree
	 */
	void enterInitFunction(grammar_v3_3Parser.InitFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#initFunction}.
	 * @param ctx the parse tree
	 */
	void exitInitFunction(grammar_v3_3Parser.InitFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctions(grammar_v3_3Parser.FunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctions(grammar_v3_3Parser.FunctionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(grammar_v3_3Parser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(grammar_v3_3Parser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(grammar_v3_3Parser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(grammar_v3_3Parser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(grammar_v3_3Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(grammar_v3_3Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#formalparlist}.
	 * @param ctx the parse tree
	 */
	void enterFormalparlist(grammar_v3_3Parser.FormalparlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#formalparlist}.
	 * @param ctx the parse tree
	 */
	void exitFormalparlist(grammar_v3_3Parser.FormalparlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#formalparitem}.
	 * @param ctx the parse tree
	 */
	void enterFormalparitem(grammar_v3_3Parser.FormalparitemContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#formalparitem}.
	 * @param ctx the parse tree
	 */
	void exitFormalparitem(grammar_v3_3Parser.FormalparitemContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#actualparlist}.
	 * @param ctx the parse tree
	 */
	void enterActualparlist(grammar_v3_3Parser.ActualparlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#actualparlist}.
	 * @param ctx the parse tree
	 */
	void exitActualparlist(grammar_v3_3Parser.ActualparlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#actualparitem}.
	 * @param ctx the parse tree
	 */
	void enterActualparitem(grammar_v3_3Parser.ActualparitemContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#actualparitem}.
	 * @param ctx the parse tree
	 */
	void exitActualparitem(grammar_v3_3Parser.ActualparitemContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#assignmentStat}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStat(grammar_v3_3Parser.AssignmentStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#assignmentStat}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStat(grammar_v3_3Parser.AssignmentStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(grammar_v3_3Parser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(grammar_v3_3Parser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#elsepart}.
	 * @param ctx the parse tree
	 */
	void enterElsepart(grammar_v3_3Parser.ElsepartContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#elsepart}.
	 * @param ctx the parse tree
	 */
	void exitElsepart(grammar_v3_3Parser.ElsepartContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#whileStat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(grammar_v3_3Parser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#whileStat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(grammar_v3_3Parser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#printStat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(grammar_v3_3Parser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#printStat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(grammar_v3_3Parser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#returnStat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(grammar_v3_3Parser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#returnStat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(grammar_v3_3Parser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#callStat}.
	 * @param ctx the parse tree
	 */
	void enterCallStat(grammar_v3_3Parser.CallStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#callStat}.
	 * @param ctx the parse tree
	 */
	void exitCallStat(grammar_v3_3Parser.CallStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(grammar_v3_3Parser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(grammar_v3_3Parser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#boolterm}.
	 * @param ctx the parse tree
	 */
	void enterBoolterm(grammar_v3_3Parser.BooltermContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#boolterm}.
	 * @param ctx the parse tree
	 */
	void exitBoolterm(grammar_v3_3Parser.BooltermContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#boolfactor}.
	 * @param ctx the parse tree
	 */
	void enterBoolfactor(grammar_v3_3Parser.BoolfactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#boolfactor}.
	 * @param ctx the parse tree
	 */
	void exitBoolfactor(grammar_v3_3Parser.BoolfactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#obj}.
	 * @param ctx the parse tree
	 */
	void enterObj(grammar_v3_3Parser.ObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#obj}.
	 * @param ctx the parse tree
	 */
	void exitObj(grammar_v3_3Parser.ObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(grammar_v3_3Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(grammar_v3_3Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(grammar_v3_3Parser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(grammar_v3_3Parser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(grammar_v3_3Parser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(grammar_v3_3Parser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_3Parser#optionalSign}.
	 * @param ctx the parse tree
	 */
	void enterOptionalSign(grammar_v3_3Parser.OptionalSignContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_3Parser#optionalSign}.
	 * @param ctx the parse tree
	 */
	void exitOptionalSign(grammar_v3_3Parser.OptionalSignContext ctx);
}