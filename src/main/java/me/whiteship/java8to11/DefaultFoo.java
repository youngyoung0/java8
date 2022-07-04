package me.whiteship.java8to11;

public class DefaultFoo implements GreetingInterface{
    String name;

    public DefaultFoo(String name){
        this.name = name;
    }

    // 재정의도 가능하다.
    @Override
    public void printNameUpperCase() {
        System.out.println(this.name.toUpperCase());
    }

    @Override
    public void printName() {
        System.out.println(name);
    }

    @Override
    public String getName() {
        return name;
    }
}
