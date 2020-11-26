package com;

import com.classes.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        var person = (Person) context.getBean("person");

        person.getName();
        System.out.println();

        person.getAge();
        System.out.println();

        try {
            person.printThrowException();
        } catch (Exception ignored) {
        }
    }
}
