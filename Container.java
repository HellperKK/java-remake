/**
 * Pour contenir une valeur et la changer
 *
 * @author Hellper (Adrien Baudet)
 * @version 21/11/2017
 */
public class Container<A>
{
    //Une valeur contenue
    public A value;

    /**
     * Constructeur d'objets de classe Container
     */
    public Container(A value)
    {
        // initialisation des variables d'instance
        this.value = value;
    }

    /**
     * Change la valeur du container
     */
    public Container<A> set(A value)
    {
        this.value = value;
        return this;
    }
}
