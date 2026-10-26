package at.htlle.pos;

import java.lang.classfile.constantpool.IntegerEntry;
import java.sql.SQLOutput;
import java.util.*;
import java.util.function.*;

public class LambdaDemo {
    static void main() throws InterruptedException {
        Comparator<String> myComparator;
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("inside the run-method");
            }
        };

        new Thread(myRunnable).start();
        System.out.println("myRunnable started via a Thread");

        // using lambda for the runnable implementation

        myRunnable = () -> System.out.println("inside the run-method2");
        new Thread(myRunnable).start();
        Runnable myRunnable2 = () -> System.out.println("second lambda runnable implementation");

        new Thread(myRunnable2).start();

        System.out.println("started 2 Threads with lambda Runnable implementation; ending main()");

        Thread.sleep(500);

        List<String> friends = new ArrayList<>(List.of("Fabian", "Massong", "Wettzi", "Matthi"));

        System.out.println("original list of friends: " + friends.toString());

        Collections.sort(friends);
        System.out.println("sorted list of friends: " + friends);

        Comparator<String> myReverseComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };

          Collections.sort(friends, myReverseComparator);
          System.out.println("reverse sorted list of friends: " + friends);

          Collections.shuffle(friends);
        System.out.println("unsorted friends list: " + friends);

        Collections.sort(friends, (o1, o2) -> o2.compareTo(o1));
        System.out.println("reverse sorted (lambda) friends list: " + friends);

        Collections.shuffle(friends);
        System.out.println("unsorted friends list" + friends);
//        friends.forEach(s -> System.out.println(s));

        Consumer<String> myConsumer = strListElement -> System.out.println(strListElement);
        Consumer<Integer> myIntConsumer = element -> System.out.println(element);

        friends.forEach(myConsumer);

        System.out.println("---");

        //consumer = data sink
        //accepts a single input
        //return nothing

        List<Integer> numbers = Arrays.asList(5, 4, 3, 2, 1);
        System.out.println("original list contents: %s" + numbers);

        Consumer<List<Integer>> multiplyNumbersByThree = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) * 3);
            }
        };

        multiplyNumbersByThree.accept(numbers);
        System.out.printf("each element multiplied by 3; %s\n", numbers);

        Consumer<List<Integer>> multiplyElementByFive = new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) {
                for (int i = 0; i < integers.size(); i++) {
                    integers.set(i, integers.get(i) * 5);
                }

            }

        };
        multiplyElementByFive.accept(numbers);
        System.out.printf("each element multiplied by 5: %s\n", numbers);

        System.out.println("---");
        //BiConsumer = data sink
        //accepts TWO input arguments
        //returns no result

        BiConsumer<String, Integer> printMultiplyByFour = (text, number) -> {
            System.out.println(text + number*4);
        };

        printMultiplyByFour.accept("4 multiplied by 4 yields the result:", 4);

        BiConsumer<List<Integer>, Integer> multiplyListElementsByX = (list, factor) -> {
          list.replaceAll(x -> x * factor); //using lambda within lambda
        };

        multiplyListElementsByX.accept(numbers, 7);
        System.out.printf("list elements multiplied by 7: %s\n", numbers);

        System.out.println("---");

        //function represents a function which accepts a single argument, and returns a result
        //accepts single argument
        //returns no result

        Function<String, String> countACharsInText = text -> {
            int countCapitalA = 0;
            int countA = 0;

            for(char character : text.toCharArray()){
                if(character == 'A') countCapitalA++;
                if(character == 'a') countA++;
            }

            return "'A'=" + countCapitalA + "'a'=" + countA;
        };

        String text = "There are so many 'A' and 'a' characters in this String";
        System.out.println(text+countACharsInText.apply(text));

        System.out.println("---");
        //BiFunction
        //accepts two arguments
        //returns single result


        BiFunction<Integer, Integer, Double> detPow = (base, power) -> Math.pow(base,power);

        System.out.printf("determine the power of (5,2) = %f\n", detPow.apply(5, 2) );

        System.out.println("---");

        BiFunction<Integer, Integer, List<Integer>> genList = (size, factor) -> {
            List<Integer> resultList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                resultList.add(i*factor);
            }
            return resultList;
        };

        System.out.printf("generate list with 5 elements and factor 3: %s\n", genList.apply(5, 3).toString());
        System.out.printf("generate list with 9 elements and factor 6: %s\n", genList.apply(9, 6).toString());

        System.out.println("---");

        // Bifunction: multiplyList.apply(list, factor): List<Integer> as a result

        BiFunction<List<Integer>, Integer, List<Integer>> multiplyList = (list, factor) -> {
            List<Integer> resultsList = new ArrayList<>();
            for (Integer i : list) {
                resultsList.add(i*factor);
            }
            return resultsList;
        };

        System.out.println("original numbers list: " + numbers);
        List<Integer> resultList = multiplyList.apply(numbers, 3);
        System.out.println("mulitpliedList.apply(numbers, 3): " + resultList);
        System.out.println("resultList is a unique new object: " + !(resultList == numbers));

        System.out.println("---");

        //Predicate
        //accepts an argument
        //returns a boolean value

        //predicate to determina if a string is longer than 5 chars

        Predicate<String> longerThanFiveChars = stringToCheck -> stringToCheck.length()>5;

        String testString = "Hello, I am Franz Strohsack";
        System.out.println("test if String is longer than five chars: " + longerThanFiveChars.test(testString));

        text="HI!";
        System.out.println("test if text " +
                "'"+text+"'" +
                " is shorter than five characters: "
                + longerThanFiveChars.negate().test(text));





        }
    }

