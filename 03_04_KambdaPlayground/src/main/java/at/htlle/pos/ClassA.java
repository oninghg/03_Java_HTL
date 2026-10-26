package at.htlle.pos;

import java.util.Comparator;

public class ClassA implements Comparator<String> {

    @Override
    public int compare(String o1, String o2){
        return 0;
    }

    @Override
    public String toString() {
        return String.format("Hello from toString()-methode of ClassA");
    }

    public String myOwnToString() {
        return "Hello from myOwnToString()-method of ClassA";
    }

    static void main() {
        System.out.println("What type is my class?");
        ClassA myInstanceOfClassA = new ClassA();

        //myClass: typ ClassA
        //myClass: Comparator<String>
        //???

        System.out.println("myInstanceOfClassA instanceof ClassA: " + (myInstanceOfClassA instanceof ClassA));
        System.out.println("myInstanceOfClassA instanceof Comparator: " + (myInstanceOfClassA instanceof Comparator));
        System.out.println("myInstanceOfClassA instanceof Object: " + (myInstanceOfClassA instanceof Object));
        System.out.println("myInstanceOfClassA instanceof Runnable: " + (myInstanceOfClassA instanceof Runnable));

        System.out.println("myInstanceOfClassA.myOwnToString(): " + myInstanceOfClassA.myOwnToString());
        System.out.println("myInstanceOfClassA.compare(): " + myInstanceOfClassA.compare("A","B"));

        Comparator<String> myComparator = myInstanceOfClassA;
//        System.out.println("myComparator.myOwnToString() - does NOT work - not visible "
//        + myComparator);

    }
}
