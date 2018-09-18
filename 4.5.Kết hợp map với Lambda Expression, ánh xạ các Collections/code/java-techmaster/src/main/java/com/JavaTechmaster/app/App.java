package com.JavaTechmaster.app;

import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {
    public static void main( String[] args ) {
        //1.Tạo một danh sách(List) các object
        List<Person> persons = Person.generateListOfPersons();
        SearchManager searchManager = SearchManager.getInstance();
        //Predicate predicate = searchManager.getPredicate("predicateAgeOver30");
        Predicate predicate = searchManager.getPredicate("predicateAgeBetween30And40");
        //Predicate predicate = searchManager.getPredicate("predicateNameIsHoang");

        System.out.println("List after filtered");
        persons.stream().filter(predicate).forEach(person -> {
            ((Person) person).showDetails();
        });
        System.out.println("Clone Result to another List");
        List<Person> filteredList = (List<Person>)persons.stream()
                                    .filter(predicate)
                                    .collect(Collectors.toList());
        filteredList.forEach(person -> person.showDetails());
        System.out.println("Map from Person's list => name's list");
        List<String> names = filteredList.stream()
                              .map(person -> person.getName())
                              .collect(Collectors.toList());
        names.forEach(name -> System.out.println(name));
        System.out.println("Map from Person's list => age's list");
        List<Integer> ages = filteredList.stream()
                              .mapToInt(person -> person.getAge())
                              .boxed()
                              .collect(Collectors.toList());
        ages.forEach(age -> {
            System.out.println(age);
        });
        System.out.println("Average of all ages:");
        System.out.println(filteredList.stream().mapToInt(person->person.getAge()).average());
        System.out.println("Sum of all ages : ");
        System.out.println(filteredList.stream().mapToInt(person->person.getAge()).sum());
    }
}
