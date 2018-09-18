package com.JavaTechmaster.app;
//Một class có thể thực thi nhiều interface
public class Person implements Interface1,Interface2 {
    private String name;
    Person(String name) {
        this.name = name;
    }
    @Override
    public void method1() {
        System.out.println("This is method1");
    }

    @Override
    public void method2() {
        System.out.println("This is method2");
    }
    //methodXKo cần thiết thực thi
}
