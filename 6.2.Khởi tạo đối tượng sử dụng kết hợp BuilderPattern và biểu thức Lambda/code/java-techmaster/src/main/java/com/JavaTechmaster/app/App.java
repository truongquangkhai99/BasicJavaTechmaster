package com.JavaTechmaster.app;

public class App {
    public static void main( String[] args ) {
        System.out.println("Builder pattern example");
        Person person = Person.Builder()
                        .with($ -> {
                            $.salutation("Mr. ");
                            $.firstName("Nguyen");
                            $.middleName("Duc");
                            $.lastName("Hoang");
                            $.address("Số nhà 45 ngõ Mai Hương, Bạch Mai, Hà Nội");
                            $.isFemale(false);
                            $.isEmployed(true);
                            $.isHomewOwner(false);
                        })
                        .build();
        person.printDetails();

    }
}
