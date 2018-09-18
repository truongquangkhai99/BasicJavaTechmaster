/*
* Khoá học Java căn bản + nâng cao, Techmaster Vietnam
* https://techmaster.vn
* Author: Mr Nguyen Duc Hoang
* */
package com.JavaTechmaster.app;

public class App {
    public static void main( String[] args ) {
        System.out.println("Interfaces in Java");
        /*
        Person person = new Person("Hoang");
        person.methodX();
        person.method1();
        person.method2();
        */
        //Có thể tạo object Person thực thi một trong 2 interface
        Interface1 person1 = new Person("Hoang1");
        person1.method1();
        //person1.method2();//Ko được vì method2 thuộc Interface2
        //Muốn gọi được phải ép kiểu
        ((Person) person1).method2();
        Interface1.sayHello("Hoang3");
    }
}
