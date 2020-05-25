package src.singletons;

import src.functionnal.AtomLam;

/**
 * Definit la valeur Unit
 *
 * @author Hellper (Adrien Baudet)
 * @version 19/11/2017
 */
public class TrueClass extends Bool{
    static private TrueClass INSTANCE = null;

    static public TrueClass getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TrueClass();
        }
        return INSTANCE;
    }

    /**
     * Constructeur d'objets de classe Unit
     */
    private TrueClass() {}

    public Bool not(){
        return FalseClass.getInstance();
    }

    public Bool and(Bool otherBool){
        return otherBool;
    }
    
    public Bool or(Bool otherBool){
        return this;
    }
    
    public Bool xnor(Bool otherBool){
        return otherBool;
    }
    
    public Unit ifTrue(AtomLam<Unit, Unit> lam)
    {
        return lam.call(Unit.getInstance());
    }
    
    public Unit ifFalse(AtomLam<Unit, Unit> lam)
    {
        return Unit.getInstance();
    }
    
    public <A> A ifTrueIfFalse(AtomLam<Unit, A> lam, AtomLam<Unit, A> otherLam)
    {
        return lam.call(Unit.getInstance());
    }
    
    public <A> A ifFalseIfTrue(AtomLam<Unit, A> lam, AtomLam<Unit, A> otherLam)
    {
        return otherLam.call(Unit.getInstance());
    }
    
    public String toString(){
        return "Vrai";
    }
}
