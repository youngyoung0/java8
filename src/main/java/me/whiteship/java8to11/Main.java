package me.whiteship.java8to11;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;

public class Main {
    public static void main(String[] args){
        // 인터페이스 기본 메서드와 스태틱 메서드 2
        List<String> name = new ArrayList<>();
        name.add("taylor");
        name.add("whiteShip");
        name.add("camel");
        name.add("john");
        name.forEach(System.out::println); // foreach

        Spliterator<String> spliterator = name.spliterator();// spliterator
        Spliterator<String> spliterator1 = spliterator.trySplit(); // 2개로 쪼개짐
        while(spliterator.tryAdvance(System.out::println));
        System.out.println("=======");
        while(spliterator1.tryAdvance(System.out::println));

        // stream
        long k = name.stream().map(String::toUpperCase)
                .filter(s -> s.startsWith("T"))
                .count();
        System.out.println(k);

        // removeIf((Predicate)
        name.removeIf(s -> s.startsWith("t"));
        name.forEach(System.out::println);

        // comparing
        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        name.sort(compareToIgnoreCase.reversed());// 역순으로 정렬 한번더 다른 조건으로 정렬 -> thenComparing
    }
}
