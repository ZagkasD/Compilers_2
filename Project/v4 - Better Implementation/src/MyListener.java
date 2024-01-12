public class MyListener extends LanguageBaseListener {
    @Override
    public void enterClass(LanguageParser.ClassContext ctx) {
        System.out.println("Entered a class rule: ");
    }

    // Add more overrides if needed
}
