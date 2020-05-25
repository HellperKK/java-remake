package src.singletons;

import src.functionnal.AtomLam;

/**
 * Definit la valeur Unit
 *
 * @author Hellper (Adrien Baudet)
 * @version 19/11/2017
 */
public class FalseClass extends Bool {
    static private FalseClass INSTANCE = null;

    static public FalseClass getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FalseClass();
        }
        return INSTANCE;
    }

    /**
     * Constructeur d'objets de classe Unit
     */
    private FalseClass() {
    }

    public Bool not(){
        return TrueClass.getInstance();
    }
    
    public Bool and(Bool otherBool){
        return this;
    }
    
    public Bool or(Bool otherBool){
        return otherBool;
    }
    
    public Bool xnor(Bool otherBool){
        return otherBool.not();
    }
    
    public Unit ifTrue(AtomLam<Unit, Unit> lam)
    {
        return Unit.getInstance();
    }
    
    public Unit ifFalse(AtomLam<Unit, Unit> lam)
    {
        return lam.call(Unit.getInstance());
    }
    
    public <A> A ifTrueIfFalse(AtomLam<Unit, A> lam, AtomLam<Unit, A> otherLam)
    {
        return otherLam.call(Unit.getInstance());
    }
    
    public <A> A ifFalseIfTrue(AtomLam<Unit, A> lam, AtomLam<Unit, A> otherLam)
    {
        return lam.call(Unit.getInstance());
    }
    
    public String toString(){
        return "Faux";
    }
}
