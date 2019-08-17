package kr.co.practice.polymorphism.downcasting;

import kr.co.practice.polymorphism.Animal;
import kr.co.practice.polymorphism.Cat;

public class Demo {
    public static void main(String[] args) {
        Cat c = (Cat)new Animal();
    }
}
