package src.numbers;

import src.singletons.Bool;

abstract public class AbstractNum {
    abstract public Bool is_zero();

    /**
     * Donne sa valeur
     */
    abstract public int value();

    /**
     * Incremente
     */
    public AbstractNum increment()
    {
        return new Succ(this);
    }

    /**
     * Decremente
     */
    abstract public AbstractNum decrement();
}
