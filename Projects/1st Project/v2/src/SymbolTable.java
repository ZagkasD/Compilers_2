import java.util.ArrayList;

public class SymbolTable {

    // This arraylist will store the scopes and the entities
    ArrayList <Scope> scopes_list = new ArrayList<>();

    // Constructor of the SymbolTable class
    public SymbolTable() {
    }

    private class Scope{
        private int nestingLevel;

        public Scope (int nestingLevel){
            this.nestingLevel = nestingLevel;
        }

        public int getNestingLevel(){
            return this.nestingLevel;
        }
    }

    private abstract class Entity {
        private String name;
    
        public Entity(String name) {
            this.name = name;
        }
    
        public String getName() {
            return this.name;
        }
    }
    
    private class Variable extends Entity {
    
        public Variable(String name) {
            super(name);
        }
        
    }

    public void add_new_scope(){
        Scope new_scope = new Scope(0);
    }

    public static void main(String[] args) {
        SymbolTable symbolTable = new SymbolTable();
        int nesting_level = 0;
        Scope new_scope = symbolTable.new Scope(nesting_level);
        System.out.println("scope nesting level = "+new_scope.getNestingLevel());
    }
}