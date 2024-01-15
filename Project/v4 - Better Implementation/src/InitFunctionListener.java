public class InitFunctionListener extends LanguageBaseListener{
    private FormalParListListener formalParListListener;

    public InitFunctionListener(){
        formalParListListener = new FormalParListListener();
    }
    
    @Override
    public void enterInitFunction(LanguageParser.InitFunctionContext ctx) {
        System.out.println("Entered Init Function");
    }

    @Override
    public void enterFormalparlist(LanguageParser.FormalparlistContext ctx) {
        // Delegate the handling of this method to InitFunctionListener
        formalParListListener.enterFormalparlist(ctx);
    }
}
