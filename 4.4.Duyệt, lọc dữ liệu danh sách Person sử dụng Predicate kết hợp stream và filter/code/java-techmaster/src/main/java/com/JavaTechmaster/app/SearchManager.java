package com.JavaTechmaster.app;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class SearchManager {
    private Map<String, Predicate> searchMap = new HashMap<>();
    //Constructor
    private SearchManager() {
        super();
        Predicate<Person> predicateAgeOver30 = person -> person.getAge() > 30;
        Predicate<Person> predicateAgeBetween30And40 = person -> person.getAge() >= 30 && person.getAge() <= 40;
        Predicate<Person> predicateNameIsHoang = person -> person.getName().equals("Hoang");
        searchMap.put("predicateAgeOver30", predicateAgeOver30);
        searchMap.put("predicateAgeBetween30And40", predicateAgeBetween30And40);
        searchMap.put("predicateNameIsHoang", predicateNameIsHoang);
    }
    //Singleton
    public static SearchManager getInstance() {
        return new SearchManager();
    }
    public Predicate<Person> getPredicate(String predicateName) {
        return searchMap.get(predicateName);
    }
}
