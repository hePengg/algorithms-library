package com.base.dispatch;

public class StaticDispatchTest {

    public static void main(String[] args) {
        Human human = new Human();
        Human woman = new Woman();
        Human man = new Man();

        StaticDispatchTest staticDispatchTest = new StaticDispatchTest();
        staticDispatchTest.say(human);
        staticDispatchTest.say(woman);
        staticDispatchTest.say(man);
    }

    static class Human {

    }

    static class Woman extends Human {}

    static class Man extends Human {}

    void say(Human human) {
        System.out.println("human");
    }

    void say(Woman woman) {
        System.out.println("Woman");
    }

    void say(Man man) {
        System.out.println("Man");
    }
}
