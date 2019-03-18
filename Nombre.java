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
    
    public Nombre(Zero zero)
    {
        // initialisation des variables d'instance
        value = zero;
    }
    
    public Nombre(Mint x)
    {
        // initialisation des variables d'instance
        Container<Zero> cont = new Container<Zero>(new Zero());
        x.times((Mint elm) -> {
            cont.value = cont.value.increment(); 
            return Constantes.unit;
        });
        value = cont.value;
    }
    
    /**
     * Teste l'egalite
     */
    public Bool equals(Nombre bis)
    {
        Container<Nombre> self = new Container<Nombre>(this);
        Container<Nombre> other = new Container<Nombre>(bis);
        Container<Bool> test = new Container<Bool>(Constantes.vrai);
        try{
            new BoolBlock((x) -> {return Constantes.vrai;})
            .whileTrue((x) -> {
                    self.update((Nombre nbr) -> nbr.decrement());
                    test.set(Constantes.faux);
                    other.update((Nombre nbr) -> nbr.decrement());
                    test.set(Constantes.vrai);
                    return Constantes.unit;
                }
            );
        }
        catch (UnsupportedOperationException exp){
            
        }
        return self.value.is_zero().and(other.value.is_zero()).and(test.value);
    }
    
    /**
     * Test si vaux zero
     */
    public Bool different(Nombre bis)
    {
        return this.equals(bis).not();
    }
    
    /**
     * Teste la superiorite
     */
    public Bool sup(Nombre bis)
    {
        Container<Nombre> self = new Container<Nombre>(this);
        Container<Nombre> other = new Container<Nombre>(bis);
        Container<Bool> test = new Container<Bool>(Constantes.vrai);
        try{
            new BoolBlock((x) -> {return Constantes.vrai;})
            .whileTrue((x) -> {
                    self.update((Nombre nbr) -> nbr.decrement());
                    test.set(Constantes.faux);
                    other.update((Nombre nbr) -> nbr.decrement());
                    test.set(Constantes.vrai);
                    return Constantes.unit;
                }
            );
        }
        catch (UnsupportedOperationException exp){
            
        }
        return test.value.not();
    }
    
    /**
     * Teste de superieur ou egal
     */
    public Bool supEq(Nombre bis)
    {
        return this.sup(bis).or(this.equals(bis));
    }
    
    /**
     * Teste d'inferieurite
     */
    public Bool inf(Nombre bis)
    {
        return this.supEq(bis).not();
    }
    
    /**
     * Teste d'inferieur ou egal
     */
    public Bool infEq(Nombre bis)
    {
        return this.sup(bis).not();
    }
    
    /**
     * Test si vaux zero
     */
    public Bool is_zero()
    {
        return value.is_zero();
    }
    
    /**
     * Incremente
     */
    public Nombre increment()
    {
        return new Nombre(value.increment());
    }
    
    /**
     * Decremente
     */
    public Nombre decrement()
    {
        return new Nombre(value.decrement());
    }
    
    /**
     * Incremente en place
     */
    public Nombre increment_()
    {
        value = value.increment();
        return this;
    }
    
    /**
     * Decremente en place
     */
    public Nombre decrement_()
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
            return this.decrement_().times(lam);
        }
        catch(UnsupportedOperationException err){
            return Constantes.unit;
        }
    }
    
    /**
     * Pour calculer la valeur
     */
    public Mint value()
    {
        return value.value();
    }
    
    /**
     * Pour afficher la valeur
     */
    public String toString()
    {
        return this.value().toString();
    }
}
