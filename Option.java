/**
 * Pseudo equivalent du type option de Ocaml
 *
 * @author Hellper (Adrien Baudet)
 * @version 13/11/2017
 */
public abstract class Option<A>
{
    public abstract A may_get(A replacement);
    public abstract A force_get();
    public abstract Bool is_some();
}
