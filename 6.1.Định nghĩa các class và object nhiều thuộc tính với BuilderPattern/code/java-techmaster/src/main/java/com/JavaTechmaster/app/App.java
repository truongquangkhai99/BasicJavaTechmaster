package com.JavaTechmaster.app;

public class App {
    public static void main( String[] args ) {
        System.out.println("Builder pattern example");
        Person person = Person.Builder()
                        .salutation("Mr. ")
                        .firstName("Nguyen")
                        .middleName("Duc")
                        .lastName("Hoang")
                        .suffix("AA")
                        //.address("Số nhà 45 ngõ Mai Hương, Bạch Mai, Hà ")
                        .isFemale(false)
                        .isEmployed(true)
                        .isHomewOwner(false)
                        .build();
        person.printDetails();

    }
}
