/**
 * Classe gérant le zero
 *
 * @author Hellper (Adrien Baudet)
 * @version 14/03/2018
 */
public class Zero
{
    /**
     * Constructeur d'objets de classe Zero
     */
    public Zero()
    {
        
    }

    /**
     * Dis si vaut zero
     */
    public Bool is_zero()
    {
        return Constantes.vrai;
    }
    
    /**
     * Donne sa valeur
     */
    public Mint value()
    {
        return new Mint(0);
    }
    
    /**
     * Incremente
     */
    public Zero increment()
    {
        return new Un(this);
    }
    
    /**
     * Decremente
     */
    public Zero decrement()
    {
        throw new UnsupportedOperationException();
    }
}
