package me.whiteship.java8to11;

import java.util.function.*;

public class Foo2 {
    public static void main(String[] args){
        // T 타입의 값을 제공하는 함수 인터페이스
        Supplier<Integer> get10 = () -> 10;

        BinaryOperator<Integer> sum = (Integer a, Integer b) -> a + b;

        Foo2 foo = new Foo2();
        foo.run();
    }

    private void run(){
        int baseNumber = 10;

        // 로컬 클래스
        class LocalClass{
            void printBaseNumber(){
                int baseNumber = 11;
                System.out.println(baseNumber); // 11
            }
        }

        // 익명 클래스
        Consumer<Integer> integerConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(baseNumber);
            }
        };

        // 람다 -> 다른 클래스와 다른점 : 쉐도잉
        // 쉐도잉 : 이름이 같은 변수는 가려짐
        // 같은 변수명을 사용할수 없다.
        // 람다 : 람다가 속한 메소드와 같은 범위로 인식된다.
        // 로컬/익명 클래스 : 로컬/익명 클래스와 속한 메소드의 범위가 다르다.
        IntConsumer printInt = (i) -> {
            System.out.println(i + baseNumber);
        };

        printInt.accept(10);
    }
}
