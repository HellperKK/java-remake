
/**
 * Definit un int mutable
 *
 * @author Adrien Baudet
 * @version 21.10.2017
 */
public class Mint
{
    // variables d'instance - int contenu dans l'objet
    public int value;

    /**
     * Constructeur d'objets de classe Mint
     */
    public Mint(int value)
    {
        // initialisation des variables d'instance
        this.value = value;
    }
    
    /**
     * Constructeur d'objets statique de classe Mint
     */
    public static Mint make(int value)
    {
        // initialisation des variables d'instance
        return new Mint(value);
    }
    
    /**
     * Getter de value
     */
    public int _value()
    {
        return this.value;
    }
    
    /**
     * Setter de value
     */
    public void value_(int value)
    {
        this.value = value;
    }

    /**
     * Remplace le +
     */
    public Mint add(int y)
    {
        return Mint.make(this.value + y);
    }
    
    /**
     * Remplace le -
     */
    public Mint subs(int y)
    {
        return Mint.make(this.value - y);
    }
    
    /**
     * Remplace le *
     */
    public Mint prod(int y)
    {
        return Mint.make(this.value * y);
    }
    
    /**
     * Remplace le /
     */
    public Mint div(int y)
    {
        return Mint.make(this.value / y);
    }
    
    
    /**
     * Remplace le %
     */
    public Mint mod(int y)
    {
        return Mint.make(this.value % y);
    }
    
    /**
     * Test d'egalite
     */
    public Bool eq(Mint aMint)
    {
        return this.value == aMint._value() ? Constantes.vrai : Constantes.faux;
    }
    
    /**
     * Test d'inferieurite
     */
    public Bool inf(Mint aMint)
    {
        return this.value < aMint._value() ? Constantes.vrai : Constantes.faux;
    }
    
    /**
     * Test de superieurite
     */
    public Bool sup(Mint aMint)
    {
        return this.value > aMint._value() ? Constantes.vrai : Constantes.faux;
    }
    
    /**
     * Repete une action x fois
     */
    public Unit times(AtomLam<Mint, Unit> lam)
    {
        return this.eq(new Mint(0)).ifTrueIfFalse(
            (x) -> {return Constantes.unit;},
            (x) -> {
                    lam.call(this); 
                    return this.subs(1).times(lam);
                }
        );
    }

    /**
     * Remplace le + en modifiant en place
     */
    public Mint add_(int y)
    {
        this.value += y;
        return this;
    }
    
    /**
     * Remplace le - en modifiant en place
     */
    public Mint subs_(int y)
    {
        this.value -= y;
        return this;
    }
    
    /**
     * Remplace le * en modifiant en place
     */
    public Mint prod_(int y)
    {
        this.value *= y;
        return this;
    }
    
    /**
     * Remplace le / en modifiant en place
     */
    public Mint div_(int y)
    {
        this.value /= y;
        return this;
    }
    
    
    /**
     * Remplace le % en modifiant en place
     */
    public Mint mod_(int y)
    {
        this.value %= y;
        return this;
    }
    
    /**
     * Pour afficher dans la console
     */
    public String toString()
    {
        return String.valueOf(value);
    }
}
