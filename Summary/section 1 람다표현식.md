# section.1

## 함수형 인터페이스와 람다 표현식 소개

함수형 인터페이스 (Functional Interface)

- 추상 메서드를 딱 하나만 가지고 있는 인터페이스
- SAM(single Abstract Method) 인터페이스
- @FuncationInterface 애노테이션을 가지고 잇는 인터페이스

```java
@FunctionalInterface
public interface RunSomething {
    void doIt(); // 함수형 인터페이스 -> 여러 개의 디폴트 메서드가 있더라도 추상 메서드가 오직 하나면 함수형 인터페이스입니다.
}
```

람다 표현식(Lambda Expressions)

- 함수형 인터페이스의 인스턴스를 만드는 방법으로 쓰일 수 있다.
- 코드를 줄일 수 있다.
- 메서드 매개변수, 리턴타입, 변수로 만들어 사용할 수도 있다.

자바에서 함수형 프로그래밍

- 함수를 First class object로 사용할 수 있다.
- 순수 함수(Pure function)
    - 사이드 이팩트 만들 수 없다. (함수 밖에 있는 값을 변경하지 못한다.)
    - 상태가 없다. (함수 밖에 정의되어 있는)
- 고차함수(Higher-Order Function)
    - 함수가 함수를 매개변수로 받을 수 있고 함수를 리턴할 수도 있다.
- 불변성

## 함수형 인터페이스와 람다 표현식 - 2

java가 기본으로 제공하는 함수형 인터페이스

- Java.lang.funcation 패키지
- 자바에 미리 정의해둔 자주 사용할만한 함수 인터페이스
- Function<T, R>

```java
Function<Integer, Integer> plus10 = (i) -> i+ 10;
        Function<Integer, Integer> multiply2 = (i) -> i*2;
        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply2); // 14
        System.out.println(multiply2AndPlus10.apply(2));

        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply2); // 24
        System.out.println(plus10AndMultiply2.apply(2));
```

- BIFunction<T, U, R>
- Consumer<T>
    
    ```java
    Consumer<Integer> print = System.out::println;
            print.accept(10); // 10
    ```
    
- Supplier<T>
    
    ```java
    Supplier<Integer> get10 = () -> 10;
            System.out.println(get10.get()); // 10
    ```
    
- Predicate<T>
    
    ```java
    Predicate<String> starsWithKeesun = (s) -> s.startsWith("keesun");
    Predicate<Integer> isEven = (i) -> i%2 == 0; // boolean
    ```
    
- UnanyOperator<T>
    
    입력, 결과값이 하나인경우
    
    Function를 상속 받고 있음
    
    ```java
    UnaryOperator<Integer> plus11 = (i) -> i+11;
    UnaryOperator<Integer> multiply3 = (i) -> i*3;
    System.out.println(plus11.compose(multiply3).apply(2)); //17
    ```
    
- BinaryOperator<T>

Function<T, R>

- T 타입을 받아서 R 타입으로 리턴하는 함수 인터페이스
    - R apply(T t)
- 함수 조합용 메서드
    - andThen
    - compose

BIFunction<T, U, R>

- 두 개의 값(T, U)를 받아서 R타입을 리턴하는 함수 인터페이스
    - R apply(T t, U u)

Consumer<T>

- T 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
    - void Accept(T t)
- 함수 조합용 메서드
    - andThen

Supplier<T>

- T 타입의 값을 제공하는 함수 인터페이스
    - T get()

Predicate<T>

- T 타입을 받아서 boolean을 리턴하는 함수 인터페이스
    - boolean test(T t)
- 함수 조합용 메서드
    - And
    - Or
    - Negate