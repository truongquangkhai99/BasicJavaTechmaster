/*
* Khoá học Java căn bản + nâng cao, Techmaster Vietnam
* https://techmaster.vn
* Author: Mr Nguyen Duc Hoang
* */
package com.JavaTechmaster.app;

public class App {
    public static void main( String[] args ) {
        System.out.println("Bắt Exception thông qua try...catch");
        Integer a = 100;
        Integer b = 50;//Ko có exception
        //Integer b = 0; //Có exception
        Calculation calculation = new Calculation();
        Integer result = calculation.divide2Number(a, b);
        System.out.println("Result = "+result);

        try {
            //calculation.readPortConfig(2000);//Ko có exception
            calculation.readPortConfig(1234);//Có exception
            System.out.println("Get port successfully");
        } catch (MyException e) {
            System.out.println("Error sms is: "+e.getMessage()+" Code: "+e.getCode());
        }
    }
}
