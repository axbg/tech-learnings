package com.classes;

import com.annotations.Logged;

public class Person {
    private Integer age;
    private String name;

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    @Logged
    public Integer getAge() {
        System.out.println("Age: " + age);
        return age;
    }

    @Logged
    public String getName() {
        System.out.println("Name: " + name);
        return name;
    }

    @Logged
    public void printThrowException() {
        System.out.println("Exception raised");
        throw new IllegalArgumentException();
    }
}
