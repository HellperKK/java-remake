
/**
 * Décrivez votre classe Phantom ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Jungler<A, B, C>
{
    /**
     * Constructeur d'objets de classe Phantom
     */
    public Jungler()
    {
        
    }

    /**
     * Swappe les types
     */
    public Jungler<B, A, C> swapConv()
    {
        return new Jungler();
    }
    
    /**
     * Swappe les types
     */
    public Jungler<C, B, A> swapJump()
    {
        return new Jungler();
    }
    
    /**
     * Swappe les types
     */
    public Jungler<A, C, B> swap()
    {
        return new Jungler();
    }
}
