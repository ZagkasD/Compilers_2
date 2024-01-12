import java.io.IOException;

public class ClassesListener extends LanguageBaseListener {
    @Override
    public void enterClasses(LanguageParser.ClassesContext ctx) {
        try {
            String include = "#include <stdio.h>\n";
            CFileWriter.getInstance().writeToFile(include);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
