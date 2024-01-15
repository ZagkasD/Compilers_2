public class MyVisitor extends LanguageBaseVisitor<Void> {
    @Override
    public Void visitClasses(LanguageParser.ClassesContext ctx) {
        try {
            CFileWriter.getInstance().writeToFile("#include <stdio.h>\\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return visitChildren(ctx); // Continue visiting children nodes
    }
}
