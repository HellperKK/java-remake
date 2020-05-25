package src.numbers;

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
