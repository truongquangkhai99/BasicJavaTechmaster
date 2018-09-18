package com.JavaTechmaster.app;

public class Person {
    private final String salutation;//VD: Mr, Ms,
    private final String firstName;
    private final String middleName;
    private final String lastName;
    private final String suffix;
    private final String address;
    private final boolean isFemale;
    private final boolean isEmployed;
    private final boolean isHomewOwner;
    //Giả sử có nhiều thuộc tính => nhiều hàm constructor => phức tạp
    public Person(String salutation, String firstName,
                  String middleName, String lastName,
                  String suffix, String address,
                  boolean isFemale,
                  boolean isEmployed, boolean isHomewOwner) {
        this.salutation = salutation;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.address = address;
        this.isFemale = isFemale;
        this.isEmployed = isEmployed;
        this.isHomewOwner = isHomewOwner;
    }
    public void printDetails(){
        System.out.println("salutation : "+salutation);
        System.out.println("firstName : "+firstName);
        System.out.println("middleName : "+middleName);
        System.out.println("lastName : "+lastName);
        System.out.println("suffix : "+suffix);
        System.out.println("address : "+address);
        System.out.println("isFemale : "+isFemale);
        System.out.println("isEmployed : "+isEmployed);
        System.out.println("isHomewOwner : "+isHomewOwner);
    }
    public static PersonBuilder Builder() {
        return new PersonBuilder();
    }
}
