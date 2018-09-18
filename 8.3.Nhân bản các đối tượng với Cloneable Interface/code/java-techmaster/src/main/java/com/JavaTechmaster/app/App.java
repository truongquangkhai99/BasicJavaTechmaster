/*
* Khoá học Java căn bản + nâng cao, Techmaster Vietnam
* https://techmaster.vn
* Author: Mr Nguyen Duc Hoang
* */
package com.JavaTechmaster.app;
public class App {
    public static void main( String[] args ) {
        System.out.println("Cloneable Interface in Java");
        Employee employee1 = new Employee("Ketty", 26,1200.0, 985471236);
        Employee employee2 = (Employee) employee1.clone();
        System.out.println("employee1 = "+employee1.toString());
        System.out.println("employee2 = "+employee2.toString());
        //Do employee1 và employee2 nằm ở 2 vùng nhớ khác nhau
        //=> thay đổi object này => object kia ko bị ảnh hưởng
        employee1.setName("Hoang");
        System.out.println("After changing employee1");
        System.out.println("employee1 = "+employee1.toString());
        System.out.println("employee2 = "+employee2.toString());
        //Kiểm tra 2 đối tượng employee1 và employee2 có thuộc cùng 1 class ko ?
        if(employee1.getClass() == employee2.getClass()) {
            System.out.println(employee1.getName() + " "+ employee2.getName()+
                    " are from the same class : "+employee1.getClass().toString());
        }
    }
}
