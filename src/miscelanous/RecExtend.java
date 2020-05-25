package src.miscelanous;

import src.functionnal.AtomLam;
import src.numbers.Num;
import src.singletons.Unit;
import src.utils.Container;

/**
 * Classe pour outrepasser la recursive stack
 *
 * @author Hellper (Adrien Baudet)
 * @version 21/11/2017
 */
public class RecExtend<A>
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private AtomLam<A, A> lam;

    /**
     * Constructeur d'objets de classe RecExtend
     */
    public RecExtend(AtomLam<A, A> lam)
    {
        // initialisation des variables d'instance
        this.lam = lam;
    }

    /**
     * Methode d'extension
     */
    public A execute(Num pow, Container<A> cont)
    {
        
        pow.equals(new Num()).ifTrueIfFalse(
            (x) -> {
                cont.update(lam);
                return Unit.getInstance();
            },
            (x) -> {
                Num dec = pow.decrement();
                this.execute(dec, cont);
                this.execute(dec, cont);
                return Unit.getInstance();
            }
        );
        return cont.value;
    }
    
    /**
     * Methode d'appel
     */
    public A sampleMethod(A value)
    {
        Container<A> cont = new Container<A>(value);
        return cont.value;
    }

}
