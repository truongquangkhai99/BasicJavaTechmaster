package com.JavaTechmaster.app;

public class Employee implements Comparable, Cloneable {
    String name;
    int age;
    double salary;
    long mobile;
    Employee(String name, int age, double salary, long mobile) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public long getMobile() {
        return mobile;
    }

    @Override
    public int compareTo(Object o) {
        Employee employee = (Employee)o;
        if(this.age > employee.getAge()) {
            return 1;
        } else if (this.age < employee.getAge()) {
            return -1;
        } else {
            return 0;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: "+name+".Age = "+age+".Salary = "+salary;
    }
    //Cloneable interface

    @Override
    public Object clone() {
        try {
            return (Employee)super.clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException comes out : "+e.getMessage());
            return null;
        }
    }
}
