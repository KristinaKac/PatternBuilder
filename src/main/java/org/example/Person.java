package org.example;

import java.util.Objects;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String address;

    private Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public Builder newChildBuilder(String name) {
        return new Person.Builder(name, surname)
                .address(getAddress());
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person { " +
                "имя: '" + name + '\'' +
                ", фамилия: '" + surname + '\'' +
                ", возраст: " + age +
                ", адрес: '" + address + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    public boolean hasAge() {
        return age != 0;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public Person setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person happyBirthday() {
        if (!hasAge()) {
            System.out.println("Возраст неизвестен");
        } else
            this.age = age + 1;
        return this;
    }

    public static class Builder {
        private String name;
        private String surname;
        private int age;
        private String address;

        public Builder(String name, String surname) {
            if (surname == null || name == null) {
                throw new IllegalStateException("Пожалуйста, заполните обязательные поля (имя, фамилия)");
            }
            this.surname = surname;
            this.name = name;
        }

        public Builder age(int age) {
            if (age < 1 || age > 100) {
                throw new IllegalArgumentException("Такого возраста не существуе. Пожалуйста, введите реальный возраст");
            }
            this.age = age;
            return this;

        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(name, surname, age, address);
        }
    }
}