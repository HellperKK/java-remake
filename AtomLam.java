/**
 * Interface pour lambda atome
 *
 * @author  Adrien Baudet
 * @version 23/10/2017
 */

public interface AtomLam<A, B>
{
    /**
     * Methode d'appel
     */
    B call(A value);
}
