/**
 * Interface pour lambda atome
 *
 * @author  Adrien Baudet
 * @version 23/10/2017
 */

/**
 * Prend une valeur de type A et en retourne une de type B
 */
public interface AtomLam<A, B>
{
    /**
     * Methode d'appel
     */
    B call(A value);
}
