/**
 * Décrivez votre classe Container ici.
 *
 * @author Hellper (Adrien Baudet)
 * @version 21/11/2017
 */
public class Container<A>
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
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
     * Un exemple de méthode - remplacez ce commentaire par le vôtre
     */
    public Container<A> set(A value)
    {
        this.value = value;
        return this;
    }
}
