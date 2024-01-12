import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Open and create the generated C file
        String generatedCFile = "generatedC.c";
        CFileWriter.getInstance().openFile(generatedCFile);

        // Input the Python file
        String filePath = "pythonExample1.py";
        CharStream input = CharStreams.fromFileName(filePath);

        // Instantiate the lexer
        LanguageLexer lexer = new LanguageLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Instantiate the parser
        LanguageParser parser = new LanguageParser(tokens);

        ParseTree tree = parser.prog(); // 'prog' is the start rule in the grammar

        // Create a custom listener
        ParseTreeWalker walker = new ParseTreeWalker();
        ClassesListener classesListener = new ClassesListener();

        // Walk the parse tree with the listener
        walker.walk(classesListener, tree);

        // Close the file
        CFileWriter.getInstance().closeFile();
    }
}

