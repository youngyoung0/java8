package me.whiteship.java8to11;

import java.util.function.*;

public class Foo {
    public static void main(String[] args){
        // Function<T, R>
        Function<Integer, Integer> plus10 = (i) -> i+ 10;
        Function<Integer, Integer> multiply2 = (i) -> i*2;
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2); // 14
        System.out.println(multiply2AndPlus10.apply(2));

        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2); // 24
        System.out.println(plus10AndMultiply2.apply(2));

        // consumer<T>
        Consumer<Integer> print = System.out::println;
        print.accept(10);

        // Supplier
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());

        // Predicate
        Predicate<String> starsWithKeesun = (s) -> s.startsWith("keesun");
        Predicate<Integer> isEven = (i) -> i%2 == 0;

        // UnaryOperator
        UnaryOperator<Integer> plus11 = (i) -> i+11;
        UnaryOperator<Integer> multiply3 = (i) -> i*3;
        System.out.println(plus11.compose(multiply3).apply(2)); //17

        // BinaryOperator
        
    }
}
