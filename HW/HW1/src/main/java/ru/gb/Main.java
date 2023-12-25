package ru.gb;

public class Main {

    public static void main(String[] args) {

        Person person1 = new Person("Василий", "Пупкин", 21);
        Person person2 = new Person("Василий", "Пупкин", 21);
        Person person3 = new Person("Иван", "Пупкин", 23);

        //toString
        System.out.println(person1);

        //hashCode
        System.out.println(person1.hashCode());

        //equals
        System.out.println(person1.equals(person2));
        System.out.println(person1.equals(person3));

        //Сериализация
        String toJson = Person.toJson(person1);
        System.out.println(toJson);

        //Десериализация
        Person person4 = Person.fromJson(toJson);
        System.out.println(person4);
    }
}