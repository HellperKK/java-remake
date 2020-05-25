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
    public Zero value;

    /**
     * Constructeur d'objets de classe Num
     */
    public Num() {
        // initialisation des variables d'instance
        value = new Zero();
    }

    public Num(Zero zero) {
        // initialisation des variables d'instance
        value = zero;
    }

    public Num(Mint x) {
        // initialisation des variables d'instance
        Container<Zero> cont = new Container<Zero>(new Zero());
        x.times((Mint elm) -> {
            cont.value = cont.value.increment();
            return Unit.getInstance();
        });
        value = cont.value;
    }

    /**
     * Teste l'egalite
     */
    public Bool equals(Num bis) {
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
        } catch (UnsupportedOperationException exp) {

        }
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
        } catch (UnsupportedOperationException exp) {

        }
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
    public Num increment_() {
        value = value.increment();
        return this;
    }

    /**
     * Decremente en place
     */
    public Num decrement_()
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
            return Unit.getInstance();
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
