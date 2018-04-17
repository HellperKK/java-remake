/**
 * Classe gérant les nombres
 *
 * @author Hellper (Adrien Baudet)
 * @version 14/03/2018
 */
public class Nombre
{
    public Zero value;

    /**
     * Constructeur d'objets de classe Nombre
     */
    public Nombre()
    {
        // initialisation des variables d'instance
        value = new Zero();
    }
    
    public Nombre(Mint x)
    {
        // initialisation des variables d'instance
        Container<Zero> cont = new Container<Zero>(new Zero());
        x.times((Mint elm) -> {value.increment(); return Constantes.unit;});
    }

    /**
     * Increment
     */
    public Nombre increment()
    {
        value = value.increment();
        return this;
    }
    
    /**
     * Decrement
     */
    public Nombre decrement()
    {
        value = value.decrement();
        return this;
    }
    
    /**
     * Repete une action x fois
     */
    public Unit times(AtomLam<Mint, Unit> lam)
    {
        try{
            lam.call(value.value());
            return this.decrement().times(lam);
        }
        catch(UnsupportedOperationException err){
            return Constantes.unit;
        }
    }
}
