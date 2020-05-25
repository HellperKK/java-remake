import src.functionnal.*;
import src.miscelanous.*;
import src.numbers.*;
import src.singletons.*;
import src.utils.*;

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
        hello(new None<String>());
        hello(new Some<String>("John"));
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
    
    public static void timesTest(){
        Num test = new Num();
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
                return Unit.getInstance();
            }
        );
    }
    
    public static void recExtTest(){    
        RecExtend<Integer> rec = new RecExtend<Integer>((Integer entier) -> entier + 1);
        // System.out.println(rec.execute(new Mint(20), new Container<Integer>(new Integer(0))).value);
    }
    
    public static void NumEqTest(){    
       Num test = new Num();
       test.increment_()
           .increment_()
           .increment_();
       Num testb = new Num();
       testb.increment_()
           .increment_()
           .increment_();
       System.out.println(test.equals(testb));
       System.out.println(test.equals(testb.increment().increment()));
       System.out.println(test.equals(testb.decrement().decrement()));
    }
    
    public static void NumSupTest(){    
       Num test = new Num();
       test.increment_()
           .increment_()
           .increment_();
       Num testb = new Num();
       testb.increment_()
           .increment_()
           .increment_();
       System.out.println(test.sup(testb));
       System.out.println(test.sup(testb.increment()));
       System.out.println(test.sup(testb.decrement()));
    }
}
