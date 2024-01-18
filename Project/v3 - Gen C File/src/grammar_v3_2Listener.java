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
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link grammar_v3_2Parser}.
 */
public interface grammar_v3_2Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(grammar_v3_2Parser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(grammar_v3_2Parser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#classes}.
	 * @param ctx the parse tree
	 */
	void enterClasses(grammar_v3_2Parser.ClassesContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#classes}.
	 * @param ctx the parse tree
	 */
	void exitClasses(grammar_v3_2Parser.ClassesContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#class}.
	 * @param ctx the parse tree
	 */
	void enterClass(grammar_v3_2Parser.ClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#class}.
	 * @param ctx the parse tree
	 */
	void exitClass(grammar_v3_2Parser.ClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(grammar_v3_2Parser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(grammar_v3_2Parser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#initFunction}.
	 * @param ctx the parse tree
	 */
	void enterInitFunction(grammar_v3_2Parser.InitFunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#initFunction}.
	 * @param ctx the parse tree
	 */
	void exitInitFunction(grammar_v3_2Parser.InitFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#functions}.
	 * @param ctx the parse tree
	 */
	void enterFunctions(grammar_v3_2Parser.FunctionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#functions}.
	 * @param ctx the parse tree
	 */
	void exitFunctions(grammar_v3_2Parser.FunctionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(grammar_v3_2Parser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(grammar_v3_2Parser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(grammar_v3_2Parser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(grammar_v3_2Parser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(grammar_v3_2Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(grammar_v3_2Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#formalparlist}.
	 * @param ctx the parse tree
	 */
	void enterFormalparlist(grammar_v3_2Parser.FormalparlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#formalparlist}.
	 * @param ctx the parse tree
	 */
	void exitFormalparlist(grammar_v3_2Parser.FormalparlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#formalparitem}.
	 * @param ctx the parse tree
	 */
	void enterFormalparitem(grammar_v3_2Parser.FormalparitemContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#formalparitem}.
	 * @param ctx the parse tree
	 */
	void exitFormalparitem(grammar_v3_2Parser.FormalparitemContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#actualparlist}.
	 * @param ctx the parse tree
	 */
	void enterActualparlist(grammar_v3_2Parser.ActualparlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#actualparlist}.
	 * @param ctx the parse tree
	 */
	void exitActualparlist(grammar_v3_2Parser.ActualparlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#actualparitem}.
	 * @param ctx the parse tree
	 */
	void enterActualparitem(grammar_v3_2Parser.ActualparitemContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#actualparitem}.
	 * @param ctx the parse tree
	 */
	void exitActualparitem(grammar_v3_2Parser.ActualparitemContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#assignmentStat}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStat(grammar_v3_2Parser.AssignmentStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#assignmentStat}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStat(grammar_v3_2Parser.AssignmentStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#ifStat}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(grammar_v3_2Parser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#ifStat}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(grammar_v3_2Parser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#elsepart}.
	 * @param ctx the parse tree
	 */
	void enterElsepart(grammar_v3_2Parser.ElsepartContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#elsepart}.
	 * @param ctx the parse tree
	 */
	void exitElsepart(grammar_v3_2Parser.ElsepartContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#whileStat}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(grammar_v3_2Parser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#whileStat}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(grammar_v3_2Parser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#printStat}.
	 * @param ctx the parse tree
	 */
	void enterPrintStat(grammar_v3_2Parser.PrintStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#printStat}.
	 * @param ctx the parse tree
	 */
	void exitPrintStat(grammar_v3_2Parser.PrintStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#returnStat}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(grammar_v3_2Parser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#returnStat}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(grammar_v3_2Parser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#callStat}.
	 * @param ctx the parse tree
	 */
	void enterCallStat(grammar_v3_2Parser.CallStatContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#callStat}.
	 * @param ctx the parse tree
	 */
	void exitCallStat(grammar_v3_2Parser.CallStatContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(grammar_v3_2Parser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(grammar_v3_2Parser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#boolterm}.
	 * @param ctx the parse tree
	 */
	void enterBoolterm(grammar_v3_2Parser.BooltermContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#boolterm}.
	 * @param ctx the parse tree
	 */
	void exitBoolterm(grammar_v3_2Parser.BooltermContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#boolfactor}.
	 * @param ctx the parse tree
	 */
	void enterBoolfactor(grammar_v3_2Parser.BoolfactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#boolfactor}.
	 * @param ctx the parse tree
	 */
	void exitBoolfactor(grammar_v3_2Parser.BoolfactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#obj}.
	 * @param ctx the parse tree
	 */
	void enterObj(grammar_v3_2Parser.ObjContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#obj}.
	 * @param ctx the parse tree
	 */
	void exitObj(grammar_v3_2Parser.ObjContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(grammar_v3_2Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(grammar_v3_2Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(grammar_v3_2Parser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(grammar_v3_2Parser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(grammar_v3_2Parser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(grammar_v3_2Parser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link grammar_v3_2Parser#optionalSign}.
	 * @param ctx the parse tree
	 */
	void enterOptionalSign(grammar_v3_2Parser.OptionalSignContext ctx);
	/**
	 * Exit a parse tree produced by {@link grammar_v3_2Parser#optionalSign}.
	 * @param ctx the parse tree
	 */
	void exitOptionalSign(grammar_v3_2Parser.OptionalSignContext ctx);
}