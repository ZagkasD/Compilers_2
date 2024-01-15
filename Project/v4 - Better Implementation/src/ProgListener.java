
public class ProgListener extends LanguageBaseListener {
    private ClassesListener classesListener;

    public ProgListener(){
        classesListener = new ClassesListener();
    }

    @Override
    public void enterProg(LanguageParser.ProgContext ctx) {
        System.out.println("Entered rule prog");
    }

    @Override
    public void enterClasses(LanguageParser.ClassesContext ctx) {
        classesListener.enterClasses(ctx);
    }
}
