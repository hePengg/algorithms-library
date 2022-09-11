package com.base.dispatch;

public class DynamicDispatchTest {

    public static void main(String[] args) {
        Human human = new Human();
        Human woman = new Woman();
        Human man = new Man();

        human.say();
        woman.say();
        man.say();
    }

    static class Human {
        void say() {
            System.out.println("human");
        }
    }

    static class Woman extends Human {
        void say() {
            System.out.println("woman");
        }
    }

    static class Man extends Human {
        void say() {
            System.out.println("man");
        }
    }

}
