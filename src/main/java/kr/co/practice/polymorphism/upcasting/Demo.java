package kr.co.practice.polymorphism.upcasting;

import kr.co.practice.polymorphism.Cat;
import kr.co.practice.polymorphism.Mammal;

public class Demo {
    public static void main(String[] args) {
        Mammal m = new Cat();
    }
}
