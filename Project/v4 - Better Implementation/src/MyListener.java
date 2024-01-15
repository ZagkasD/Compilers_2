public class MyListener extends LanguageBaseListener {
    private ProgListener progListener;

    public MyListener(){
        progListener = new ProgListener();
    }
    
    @Override
    public void enterProg(LanguageParser.ProgContext ctx) {
        progListener.enterProg(ctx);   
    }
}
