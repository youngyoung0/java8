package me.whiteship.java8to11;

public interface GreetingInterface {
    void printName();

    /*
     *   @implSpec 이 구현체는 getName()으로
     *   가져온 문자열을 대문자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }
    // Default method "toString" override a member of "java.lang.Object"

    static void printAnything(){
        System.out.println("FOO");
    }

    String getName();
}
