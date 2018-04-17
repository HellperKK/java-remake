/**
 * Classe gérant le un
 *
 * @author Hellper (Adrien Baudet)
 * @version 14/03/2018
 */
public class Un extends Zero
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    public Zero next;

    /**
     * Constructeur d'objets de classe Un
     */
    public Un()
    {
        // initialisation des variables d'instance
        next = new Zero();
    }
    
    public Un(Zero x)
    {
        // initialisation des variables d'instance
        next = x;
    }

    /**
     * Dis si vaut zero
     */
    public Bool is_zero()
    {
        return Constantes.faux;
    }
    
    /**
     * Donne sa valeur
     */
    public Mint value()
    {
        return (new Mint(1)).add_(next.value().value);
    }
    
    /**
     * Decremente
     */
    public Zero decrement()
    {
        return next;
    }
}
