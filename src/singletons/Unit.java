package src.singletons;

/**
 * Definit la valeur Unit
 *
 * @author Hellper (Adrien Baudet)
 * @version 19/11/2017
 */
public class Unit {
    static private Unit INSTANCE = null;

    static public Unit getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Unit();
        }
        return INSTANCE;
    }
    /**
     * Constructeur d'objets de classe Unit
     */
    private Unit() {}
}
