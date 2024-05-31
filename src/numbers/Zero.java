package src.numbers;

import src.singletons.Bool;
import src.singletons.TrueClass;

/**
 * Classe gérant le zero
 *
 * @author Hellper (Adrien Baudet)
 * @version 14/03/2018
 */
public class Zero extends AbstractNum
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
        return TrueClass.getInstance();
    }
    
    /**
     * Donne sa valeur
     */
    public int value()
    {
        return 0;
    }
    
    /**
     * Decremente
     */
    public AbstractNum decrement()
    {
        throw new UnsupportedOperationException();
    }
}
