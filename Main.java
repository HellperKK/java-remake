
/**
 * Classe principale
 *
 * @author Hellper (Adrien Baudet)
 * @version 13/11/2017
 */
public class Main
{
    public static void main(String[] args){
        Container<AtomLam<Integer, Integer>> test = new Container<AtomLam<Integer, Integer>>((Integer x) -> {return x + 1;});
        test.set((Integer x) -> {
            if(x == 0){
                return 1;
            }
            else{
                return x * test.value.call(x - 1);
            }            
        });
        System.out.println(test.value.call(3));
    }
    
    public static void optionTest(){
        hello(new None());
        hello(new Some("John"));
    }
    
    public static void hello(Option<String> nom){
        String new_nom = nom.may_get("World");
        System.out.println("Hello " + new_nom + " !");
    }
    
    public static void curryTest(){
        AtomLam<Integer, AtomLam<Integer, Integer>> lambda = (x) -> {return (y) -> {return x + y;};};
        AtomLam<Integer, Integer> lambda2 = lambda.call(1);
        System.out.println(lambda.call(5).call(7));
        System.out.println(lambda2.call(2));
    }
    
    public static void blockTest(){
        Mint entier = new Mint(0);
        new BoolBlock((x) -> {return entier.inf(new Mint(20));})
            .whileTrue((x) -> {
                    //System.out.println(entier._value()); 
                    entier.add_(1); 
                    return Constantes.unit;
                }
            );
    }
    
    public static void timesTest(){
        Nombre test = new Nombre();
        test.increment()
            .increment()
            .increment()
            .increment()
            .increment()
            .increment()
            .increment()
            .increment()
            .increment()
            .increment()
            .times(
            (Mint x) -> {
                System.out.println(x._value());
                return Constantes.unit;
            }
        );
    }
    
    public static void timesTestBis(){
        Nombre test = new Nombre(new Mint(10));
        test.times(
            (Mint x) -> {
                System.out.println(x._value());
                return Constantes.unit;
            }
        );
    }
    
    public static void recExtTest(){    
        RecExtend<Container<Integer>> rec = new RecExtend<Container<Integer>>((Container<Integer> entier) -> {
            return entier.set(entier.value + 1);});
        // System.out.println(rec.execute(new Mint(20), new Container<Integer>(new Integer(0))).value);
    }
    
    public static void nombreEqTest(){    
       Nombre test = new Nombre();
       test.increment_()
           .increment_()
           .increment_();
       Nombre testb = new Nombre();
       testb.increment_()
           .increment_()
           .increment_();
       System.out.println(test.equals(testb));
       System.out.println(test.equals(testb.increment().increment()));
       System.out.println(test.equals(testb.decrement().decrement()));
    }
    
    public static void nombreSupTest(){    
       Nombre test = new Nombre();
       test.increment_()
           .increment_()
           .increment_();
       Nombre testb = new Nombre();
       testb.increment_()
           .increment_()
           .increment_();
       System.out.println(test.sup(testb));
       System.out.println(test.sup(testb.increment()));
       System.out.println(test.sup(testb.decrement()));
    }
}
