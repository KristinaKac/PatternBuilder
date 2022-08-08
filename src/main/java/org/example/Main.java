package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            Person mom = new Person.Builder("Анна", "Вольф")
                    .age(31)
                    .address("Сидней")
                    .build();
            System.out.println(mom);
            Person son = mom.newChildBuilder("Антон")
                    .age(7)
                    .build();
            System.out.println(son);

            System.out.println(mom.hasAge());
            System.out.println(mom.hasAddress());
            System.out.println(son.hasAge());
            System.out.println(son.hasAddress());
            System.out.println(son.happyBirthday());
            System.out.println(mom.setAddress("Нью-Йорк"));
            System.out.println(mom.happyBirthday());
        } catch (IllegalArgumentException | IllegalStateException e) {
            e.printStackTrace();
        }
    }
}