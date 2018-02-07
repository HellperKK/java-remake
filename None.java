/**
 * Pseudo equivalent du None de Ocaml
 *
 * @author Hellper (Adrien Baudet)
 * @version 13/11/2017
 */
public class None<A> extends Option<A>
{
    /**
     * Constructeur d'objets de classe None
     */
    public None()
    {
        
    }

    /**
     * Pour recuperer la potenitelle valeur encapsulee
     */
    public A may_get(A replacement)
    {
        return replacement;
    }
    
    /**
     * Pour recuperer de force la potenitelle valeur encapsulee
     */
    public A force_get()
    {
        throw new UnsupportedOperationException();
    }
    
    /**
     * Definit le statut
     */
    public Bool is_some()
    {
        return Constantes.faux;
    }
}
