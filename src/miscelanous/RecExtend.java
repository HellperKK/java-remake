package src.miscelanous;

import src.functionnal.AtomLam;
import src.numbers.Num;

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
    public A execute(Num pow, A val)
    {
        
        return pow.is_zero().ifTrueIfFalse(
            (x) -> {
                return lam.call(val);
            },
            (x) -> {
                Num dec = pow.decrement();
                A valb = this.execute(dec, val);
                return this.execute(dec, valb);
            }
        );
    }
}
