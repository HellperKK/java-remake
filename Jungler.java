
/**
 * Classe Gag sur l'utilisation des generiques
 *
 * @author Adrien Baudet
 * @version 20/03/2019
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
     * Swappe les deux premiers types
     */
    public Jungler<B, A, C> swapConv()
    {
        return new Jungler();
    }
    
    /**
     * Swappe les premier et dernier types
     */
    public Jungler<C, B, A> swapJump()
    {
        return new Jungler();
    }
    
    /**
     * Swappe les deux derniers types
     */
    public Jungler<A, C, B> swap()
    {
        return new Jungler();
    }
}
