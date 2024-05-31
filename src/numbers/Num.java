package src.numbers;

import src.functionnal.AtomLam;
import src.singletons.*;
import src.utils.BoolBlock;
import src.utils.Container;

/**
 * Classe gérant les Nums
 *
 * @author Hellper (Adrien Baudet)
 * @version 14/03/2018
 */
public class Num {
    static public Num ZERO = new Num();
    static public Num ONE = ZERO.increment();
    static public Num TWO = ONE.increment();
    static public Num THREE = TWO.increment();
    static public Num FOUR = THREE.increment();
    static public Num FIVE = FOUR.increment();
    static public Num SIX = FIVE.increment();
    static public Num SEVEN = SIX.increment();
    static public Num EIGHT = SEVEN.increment();
    static public Num NINE = EIGHT.increment();
    static public Num TEN = NINE.increment();
    static public Num HUNDRED = TEN.mult(TEN);
    
    public AbstractNum value;

    /**
     * Constructeur d'objets de classe Num
     */
    public Num() {
        // initialisation des variables d'instance
        value = new Zero();
    }

    public Num(AbstractNum num) {
        // initialisation des variables d'instance
        value = num;
    }

    /**
     * Teste l'egalite
     */
    public Bool equals(Num bis) {
        Container<Num> self = new Container<>(this);
        Container<Num> other = new Container<>(bis);
        Container<Bool> test = new Container<>(TrueClass.getInstance());
        try {
            new BoolBlock((x) -> {
                return TrueClass.getInstance();
            }).whileTrue((x) -> {
                self.update((Num nbr) -> nbr.decrement());
                test.set(FalseClass.getInstance());
                other.update((Num nbr) -> nbr.decrement());
                test.set(TrueClass.getInstance());
                return Unit.getInstance();
            });
        } catch (UnsupportedOperationException exp) {}
        return self.value.is_zero().and(other.value.is_zero()).and(test.value);
    }

    /**
     * Test si vaux zero
     */
    public Bool different(Num bis) {
        return this.equals(bis).not();
    }

    /**
     * Teste la superiorite
     */
    public Bool sup(Num bis) {
        Container<Num> self = new Container<Num>(this);
        Container<Num> other = new Container<Num>(bis);
        Container<Bool> test = new Container<Bool>(TrueClass.getInstance());
        try {
            new BoolBlock((x) -> {
                return TrueClass.getInstance();
            }).whileTrue((x) -> {
                self.update((Num nbr) -> nbr.decrement());
                test.set(FalseClass.getInstance());
                other.update((Num nbr) -> nbr.decrement());
                test.set(TrueClass.getInstance());
                return Unit.getInstance();
            });
        } catch (UnsupportedOperationException exp) {}

        return test.value.not();
    }

    /**
     * Teste de superieur ou egal
     */
    public Bool supEq(Num bis) {
        return this.sup(bis).or(this.equals(bis));
    }

    /**
     * Teste d'inferieurite
     */
    public Bool inf(Num bis) {
        return this.supEq(bis).not();
    }

    /**
     * Teste d'inferieur ou egal
     */
    public Bool infEq(Num bis) {
        return this.sup(bis).not();
    }

    /**
     * Test si vaux zero
     */
    public Bool is_zero() {
        return value.is_zero();
    }

    /**
     * Incremente
     */
    public Num increment() {
        return new Num(value.increment());
    }

    /**
     * Decremente
     */
    public Num decrement() {
        return new Num(value.decrement());
    }

    /**
     * Incremente en place
     */
    public Num incrementInPlace() {
        value = value.increment();
        return this;
    }

    /**
     * Decremente en place
     */
    public Num decrementInPlace()
    {
        value = value.decrement();
        return this;
    }

    /**
     * Addition
     * x + 0 = x
     * x + Succ(y) = Succ(x + y)
     */
    public Num add(Num other)
    {
        return other.is_zero().ifTrueIfFalse(
            (_u) -> this,
            (_u) -> this.add(other.decrement()).increment()
        );
    }

    /**
     * Multiplication
     */
    public Num mult(Num other)
    {
        return other.is_zero().ifTrueIfFalse(
            (_u) -> new Num(),
            (_u) -> this.mult(other.decrement()).add(this)
        );
    }
    
    /**
     * Repete une action x fois
     */
    public Unit times(AtomLam<Integer, Unit> body)
    {
        try{
            var nex = this.decrementInPlace();
            body.call(value.value());
            return nex.times(body);
        }
        catch(UnsupportedOperationException err){
            return Unit.getInstance();
        }
    }
    
    /**
     * Pour calculer la valeur
     */
    public int value()
    {
        return value.value();
    }
    
    /**
     * Pour afficher la valeur
     */
    public String toString()
    {
        return String.valueOf(this.value());
    }
}
