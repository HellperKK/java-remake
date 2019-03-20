/**
 * Définition abstraite de bloc
 *
 * @author Hellper (Adrien Baudet)
 * @version 19/11/2017
 */
public class BoolBlock
{
    // Lambda encapsulee par le bloc
    AtomLam<Unit, Bool> lam;
    
    /**
     * Constructeur
     */
    public BoolBlock(AtomLam<Unit, Bool> lam)
    {
        this.lam = lam;
    }
    
    /**
     * Appel du bloc
     */
    public Bool value(Unit valeur)
    {
        return lam.call(valeur);
    }
    
    /**
     * Remplacement du while
     */
    public Unit whileTrue(AtomLam<Unit, Unit> otherLam)
    {
        lam.call(Constantes.unit).ifTrueIfFalse((x) -> {otherLam.call(Constantes.unit); return this.whileTrue(otherLam);}, (x) -> {return Constantes.unit;});
        return Constantes.unit;
    }
}