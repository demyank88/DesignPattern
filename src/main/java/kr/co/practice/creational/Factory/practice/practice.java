package kr.co.practice.creational.Factory.practice;

class Person
{
    public int id;
    public String name;

    public Person(int id, String name)
    {
        this.id = id;
        this.name = name;
    }
}

class PersonFactory
{
    static int num = 0;
    public Person createPerson(String name)
    {
        // todo
        return new Person(num++, name);
    }
}

public class practice {
    public static void main(String[] args) {
        new PersonFactory().createPerson("test");
    }
}
