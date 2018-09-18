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
        //Gọi phương thức trong SingletonExample
        SingletonExample.getInstance().method1();
        SingletonExample.getInstance().method2();

    }
}
