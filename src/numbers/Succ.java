package src.numbers;

import src.singletons.Bool;
import src.singletons.FalseClass;

/**
 * Classe gérant le un
 *
 * @author Hellper (Adrien Baudet)
 * @version 14/03/2018
 */
public class Succ extends AbstractNum
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    public AbstractNum next;

    /**
     * Constructeur d'objets de classe Un
     */
    public Succ()
    {
        // initialisation des variables d'instance
        next = new Zero();
    }
    
    public Succ(AbstractNum x)
    {
        // initialisation des variables d'instance
        next = x;
    }

    /**
     * Dis si vaut zero
     */
    public Bool is_zero()
    {
        return FalseClass.getInstance();
    }
    
    /**
     * Donne sa valeur
     */
    public int value()
    {
        return 1 + next.value();
    }
    
    /**
     * Decremente
     */
    public AbstractNum decrement()
    {
        return next;
    }
}
