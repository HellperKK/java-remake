package src.utils;

import src.functionnal.AtomLam;

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
    
    /**
     * Change la valeur du container d'apres une lambda
     */
    public Container<A> update(AtomLam<A, A> lam)
    {
        value = lam.call(value);
        return this;
    }
}
