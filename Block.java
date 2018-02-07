
/**
 * Définition abstraite de bloc
 *
 * @author Hellper (Adrien Baudet)
 * @version 19/11/2017
 */
public class Block<A, B>
{
    // variable d'instance - remplacez cet exemple par le vôtre
    AtomLam<A, B> lam;
    
    public Block(AtomLam<A, B> lam)
    {
        this.lam = lam;
    }
    
    /**
     * Appel du bloc
     */
    public B value(A valeur)
    {
        return lam.call(valeur);
    }
}
