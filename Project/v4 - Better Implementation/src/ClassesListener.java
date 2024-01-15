
public class ClassesListener extends LanguageBaseListener {

    public ClassesListener(){

    }

    @Override
    public void enterClasses(LanguageParser.ClassesContext ctx) {
        System.out.println("Entered rule classes");
        
    }
}
