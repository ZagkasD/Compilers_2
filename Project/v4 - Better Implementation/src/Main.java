import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Path to the Python file
        String filePath = "pythonExample1.py";
        CharStream input = CharStreams.fromFileName(filePath);

        // Instantiate the lexer
        LanguageLexer lexer = new LanguageLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);

        // Instantiate the parser
        LanguageParser parser = new LanguageParser(tokens);

        ParseTree tree = parser.prog(); // 'prog' is the start rule in your grammar

        // Create a custom listener
        ParseTreeWalker walker = new ParseTreeWalker();
        MyListener listener = new MyListener();


        // Walk the parse tree with the listener
        walker.walk(listener, tree);
    }
}
