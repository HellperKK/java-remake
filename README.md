# Jemake
Des experiences en java en terme de design objet


## Utilisation
Plusieurs tests sont disponibles dans la classe Main. A savoir :

 - optionTest : Test d'une reproduction du type option d'Ocaml
 - curryTest : Test de currification
 - blockTest : Test de réécriture de la boucle while
 - timesTest : Test de compteur jusque 10
 - timesTestBis : Même chose que timeTest en plus court

Dans la plupart des cas le concept est de tester l'implémentation de design objet inspirés de Smalltalk dans un langage 
objet statiquement typé et ainsi réécrire des composant de base comme les conditions et la boucle while.


## Comment ça marche ?

Je vais essayer d'expliquer ici les conteps exploités dans le code pour réimplémenter les différentes primitives de java
en objet :

### Unit

Dans un langage comme Java il est commun pour une fonction qui ne renvoit rien de renvoyer void. Cela marche très bien,
mais dans certains langage on préférera le typre Unit qui est très similaire. En fait là où void n'est effectivement 
rien, Unit est une sorte d'objet vide. On passe donc d'une absence de valeur à une valeur qui ne vaut rien. 

Comme il ne peut être modifié, Unit est implémenté en Singleton.

### Les booléens

L'implémentation des booléens est un usage simple de polymorphisme. Quand on explique le polymorphisme est part souvent 
sur un exemple comme ceci :

```java
abstract class Animal {
    abstract void Crier();
}

class Chien extends Animal {
     void Crier() {
         System.out.println("Ouaf !");
     }
}

class Chat extends Animal {
    void Crier() {
        System.out.println("Miaou !");
    }
}
```
Ici on a une classe abstraite qui est redéfinie deux fois par des classes concrètes et chaque enfant défini son propre 
comportement. Sur ce même principe il est tout à fait possible d'implémenter les booléens en utilisant une classe pour 
true et une pour false. Par exemple pour la méthode not, équivalente de l'opérateur `!` :

```java
public abstract class Bool {
    /**
     * Equivalent de not
     */
    abstract public Bool not();
}

public class FalseClass extends Bool {
    public Bool not() {
        return TrueClass.getInstance();
    }
}

public class TrueClass extends Bool {
    public Bool not() {
        return FalseClass.getInstance();
    }
}
```
On remarque par ailleurs que les classes `FalseClass` et `TrueClass` sont des singletons. En effet, on n'a besoin que 
d'une seule instance de chaque pour l'entièreté du programme. Pour faire un if, on peut alors passer une callback à
notre méthode qui ne sera appelée que dans le cas où le receveur est true, comme ceci :

```java
public class FalseClass extends Bool {
    public Unit ifTrue(AtomLam<Unit, Unit> lam)
    {
        return Unit.getInstance();
    }
}

public class TrueClass extends Bool {
    public Unit ifTrue(AtomLam<Unit, Unit> lam)
    {
        return lam.call(Unit.getInstance());
    }
}
```

Ici `AtomLam<I, O>` définit une lambda atomique qui prend deux génériques, un pour son type d'éntrée `I` et un pour son
type de sortie `O`.


### Boucles

Pour implémenter une boucle, par exemple la boucle while, le fonctionnement est assez différent. En effet, là où dans 
un if l'expression booléene n'est évaluée qu'une seule fois, dans un while elle l'est plusieurs fois. Pour y pallier 
j'ai donc décidé d'implémenter un nouvel objet à savoir le BoolBlock. Un BoolBlock est une surcouche à la lambda 
atomique donc je parlait plus tôt qui prend Unit en paramètre et renvoie un booléen.

Le code du while true, basé sur le if précédent est alors écrit ainsi :

```java
public class BoolBlock
{
    /**
     * Remplacement du while
     */
    public Unit whileTrue(AtomLam<Unit, Unit> otherLam)
    {
        return this.lam.call(Unit.getInstance())
            .ifTrueIfFalse(
                (_u) -> {otherLam.call(Unit.getInstance()); return this.whileTrue(otherLam);}, 
                (_u) -> {return Unit.getInstance();}
            );
    }
}
```
Le fonctionnement est assez simple :

- On appelle lam, qui est la lambda dont le boolblock est la surcouche et correspond à la condition qu'on veut évaluer 
plusieurs fois
- Avec le ifTrueIfFalse on passe en paramètres deux autre lambdas, la première qui est appelée si le booléens renvoyé 
est True, et l'autre si c'est false.
- Si True est renvoyé donc, on apelle la lambda `otherLam` qui est le corps de notre while. Puis on rappelle 
récursivement la méthode whildeTrue
- Sinon on renvois Unit et on s'arrête.

Cela fait pas mal de lambdas imbriquées du fait que je n'utilise plus les structures de base, mais rien de bien méchant je dirais :)

### Closures, final et Container

Pour aller un peu plus loin sur ce sujet, je vais parler d'un comportement assez particulier des closures dans Java.
Pour rappel, une closure est le fait de référencer une variable dans une lambda qui a été déclarée en dehors. Par exemple :

```java
int x = 0;
var lambda = (int y) -> x + y;
```

Dans cet exemple simple, la lambda capture la variable x et le retourne additionné à son paramètre y.

Quand on fait cela dans java, la variable capturée est implicitement passée en final, ce qui veut dire qu'on ne peut
plus la réassigner. C'est problématique dans le cas de mon nouveau while où on voudrait souvent pouvoir muter une 
variable qui est en closure. Pour reprendre un exemple plus clair : 

```java
int i = 0;
while (i > 10) {
    System.out.println(i);
    i++;    
}
```
Ici la variable i est utilisée deux fois, dans la condition et dans le corps. Ces deux éléments étant remplacés dans mon
while par des lambdas, on a donc même une double closure !

Pour y pallier, j'ai créer la classe `Container`. Rein de bien compliqué, il s'agit d'une classe avec un seul champ 
mutable qu'on réassignera au lieu de réassigner la variable elle-même. Malin, non ?


### Les nombres

Pour réimplémenter les nombres, je me suis inspiré des entiers de Péano. Dans cette définition, un entier peut être :
- 0
- Le successeur d'un autre entier n, S(n)

Ainsi, 1 s'écrira S(0) et 2 s'écrira S(S(0)) et ainsi de suite. J'ai renommé le 0 en la classe Zero et le S(n) en la 
classe Succ.

Pour l'implémentation, j'ai alors réalisé une sorte de liste chainée, mais donc chaque chainon ne porterais que la
référence au chainon suivant. On peut alors convertir un nombre en un int concret simplement en l'applatissant :

```java
public class Zero extends AbstractNum
{
    public int value()
    {
        return 0;
    }
}

public class Succ extends AbstractNum
{
    public int value()
    {
        return 1 + next.value();
    }
}
```

Rien de bien compliqué donc. Pour ensuite manager mon nombre j'ai crée une classe Num qui contient une seule propriété,
un AbstractNum. En faisant ainsi je rend son utilisation plus simple et je peux créer des comportement plus complexes.

Par exemple j'ai crée la méthode times pour faire une boucle qui s'execute un nombre donné de fois :

```java
public class Num {
    public Unit times(AtomLam<Integer, Unit> lam)
    {
        try{
            var nex = this.decrement_();
            lam.call(value.value());
            return nex.times(lam);
        }
        catch(UnsupportedOperationException err){
            return Unit.getInstance();
        }
    }
}
```

Le principe est simple : On appelle la lambda qui est le corps de notre boucle et on rapelle récursivement sur la
version décrémentée de notre receveur. Ainsi si on a appelle times sur un 3 on aura la stack suivante :

```
3.times(lambda)
2.times(lambda)
1.times(lambda)
0.times(lambda)
```

Au moment de vouloir décrémenter 0, on lance une exception qui stoppe la boucle réursive. En effet les entiers de Péano
sont les entier naturel donc les entiers négatifs n'existent pas !

En plus de times, j'en ai profité pour implémener plusieurs opération comme l'addition et la multiplication. Je vous 
laisse regarder le code de ces méthodes qui est je pense assez trivial une fois qu'on a géré l'incrémentation et 
la décrémentation. Je vais donc conclure en expliquant le test d'égalité, qui lui me semble plus complexe.

```java
public class Num {
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
}
```

Ce que je fais c'est que je prend les deux entiers et les décrémente jusqu'à ce que l'un d'eux lance une exception. Si
une exception est lancée c'est que l'un de deux est 0 donc je regarde si les deux sont 0 avec un test qui me permet 
vérifier si c'est bien la décrémentation numéro deux de mon while qui a bien lancé l'exception. Ainsi je m'assure qu'il 
sont bien égaux après X tour de boucle et qu'ils l'étaient au tout début de mon code, tout simplement :)