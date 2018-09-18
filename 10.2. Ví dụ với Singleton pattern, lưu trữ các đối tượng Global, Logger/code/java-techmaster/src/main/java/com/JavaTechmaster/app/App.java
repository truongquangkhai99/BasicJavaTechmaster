/*
* Khoá học Java căn bản + nâng cao, Techmaster Vietnam
* https://techmaster.vn
* Author: Mr Nguyen Duc Hoang
* */
package com.JavaTechmaster.app;

public class App {
    public static void main( String[] args ) {
        System.out.println("Singleton pattern in Java");
        //"Singleton pattern" = object tồn tại duy nhất trong app, và "Global"
        Logger.getInstance().show("This is Singleton pattern", Logger.INFO);
        Person person = new Person("Hoang");
        person.talkToMe(120);
    }
}
