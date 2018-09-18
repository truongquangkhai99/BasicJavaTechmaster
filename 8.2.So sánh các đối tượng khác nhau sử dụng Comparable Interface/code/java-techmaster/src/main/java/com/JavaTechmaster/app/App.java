/*
* Khoá học Java căn bản + nâng cao, Techmaster Vietnam
* https://techmaster.vn
* Author: Mr Nguyen Duc Hoang
* */
package com.JavaTechmaster.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        System.out.println("Comparable interface in Java");
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(new Employee("Ketty", 26,1200.0, 985471236));
        employees.add(new Employee("John", 36,1200.0, 956874547));
        employees.add(new Employee("Katherin", 25,1200.0, 943565887));
        employees.add(new Employee("Hoang", 30,1200.0, 929688655));
        employees.add(new Employee("Anna", 33,1200.0, 936588869));
        System.out.println(employees.get(1).compareTo(employees.get(0)));
        employees.sort((e1,e2)->{
            return e2.compareTo(e1);
        });
        //Sử dụng static method của interface => "comparing"
        Comparator<Employee> nameComparator = Comparator.comparing(Employee::getName,
                (name1, name2) -> {
                    return name2.compareTo(name1);
                });
        //Employee::getAge là "method reference"
        Comparator<Employee> ageComparator = Comparator.comparing(Employee::getAge, (age1, age2) ->{
            return age2.compareTo(age1);
        });
        //Collections.sort(employees, nameComparator);
        Collections.sort(employees, ageComparator);
        System.out.println("Employees are : ");
        employees.forEach(employee -> {
            System.out.println(employee.toString());
        });
    }
}
