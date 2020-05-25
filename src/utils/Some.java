package src.utils;

import src.singletons.*;

/**
 * Pseudo equivalent du Some de Ocaml
 *
 * @author Hellper (Adrien Baudet)
 * @version 13/11/2017
 */
public class Some<A> extends Option<A>
{
    // valeur encapsulee
    private A value;

    /**
     * Constructeur d'objets de classe Some
     */
    public Some(A value)
    {
        // initialisation des variables d'instance
        this.value = value;
    }

    /**
     * Pour recuperer la potenitelle valeur encapsulee
     */
    public A may_get(A replacement)
    {
        return this.value;
    }
    
    /**
     * Pour recuperer de force la potenitelle valeur encapsulee
     */
    public A force_get()
    {
        return this.value;
    }
    
    /**
     * Definit le statut
     */
    public Bool is_some()
    {
        return TrueClass.getInstance();
    }
}
