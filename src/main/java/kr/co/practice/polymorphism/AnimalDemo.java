package kr.co.practice.polymorphism;

public class AnimalDemo {
    public static void main(String[] args) {
        Cat c = new Cat();
        System.out.println(c.health);
        Dog d = new Dog();
        System.out.println(d.health);
    }
}
