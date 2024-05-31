package src.utils;

import src.functionnal.AtomLam;
import src.singletons.*;

/**
 * Définition abstraite de bloc
 *
 * @author Hellper (Adrien Baudet)
 * @version 19/11/2017
 */
public class BoolBlock
{
    // Lambda encapsulee par le bloc
    AtomLam<Unit, Bool> condition;
    
    /**
     * Constructeur
     */
    public BoolBlock(AtomLam<Unit, Bool> lam)
    {
        this.condition = lam;
    }
    
    /**
     * Appel du bloc
     */
    public Bool value(Unit valeur)
    {
        return condition.call(valeur);
    }
    
    /**
     * Remplacement du while
     */
    public Unit whileTrue(AtomLam<Unit, Unit> body)
    {
        return this.condition.call(Unit.getInstance())
            .ifTrueIfFalse(
                (_u) -> {body.call(Unit.getInstance()); return this.whileTrue(body);},
                (_u) -> {return Unit.getInstance();}
            );
    }
}