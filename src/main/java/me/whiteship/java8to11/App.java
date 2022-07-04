package me.whiteship.java8to11;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class App {

    public static void main(String[] args) {
        UnaryOperator<String> hi = Greeting::hi;

        Greeting greeting = new Greeting();
        UnaryOperator<String> hello = greeting::hello;
        System.out.println(hello.apply("taylor"));

        Supplier<Greeting> newGreeting = Greeting::new;
        newGreeting.get();

        Function<String, Greeting> taylorGreeting = Greeting::new; // 문자열을 받는 생성장를 참조
        Greeting taylor = taylorGreeting.apply("taylor");
        System.out.println(taylor.getName());

        Supplier<Greeting> theNewGreeting = Greeting::new; // 문자열을 받지 않는 생성자를 참조

        // 임의 객체의 인스턴스 메서드 참조
        String[] names = {"taylor", "chan", "john", "aaron"};
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names));

        DefaultFoo foo = new DefaultFoo("taylor");
        foo.printName();
        foo.printNameUpperCase();

        GreetingInterface.printAnything();
    }

}
