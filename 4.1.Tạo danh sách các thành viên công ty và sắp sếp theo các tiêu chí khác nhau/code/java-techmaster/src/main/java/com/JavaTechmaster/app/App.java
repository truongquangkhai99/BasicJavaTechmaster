package com.JavaTechmaster.app;

import java.util.Collections;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        //1.Tạo một danh sách(List) các object
        List<Person> persons = Person.generateListOfPersons();
        /*
        Collections.sort(persons, (Person person1, Person person2) -> {
            return person2.getName().compareTo(person1.getName());
        });
        */
        //Sắp xếp theo tuổi
        Collections.sort(persons, (Person person1, Person person2) -> person2.getAge().compareTo(person1.getAge()));
        System.out.println("List after sorted");
        for(Person person: persons) {
            person.showDetails();
        }
    }
}
