
public class FormalParListListener extends LanguageBaseListener{

    public FormalParListListener(){

    }

    @Override
    public void enterFormalparlist(LanguageParser.FormalparlistContext ctx) {
        System.out.println("Entered Formalparlist");
    }
}
