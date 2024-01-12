public class ClassListener extends LanguageBaseListener {
    @Override
    public void enterClass(LanguageParser.ClassContext ctx) {
        System.out.println("Entered a class rule: ");
    }
}
