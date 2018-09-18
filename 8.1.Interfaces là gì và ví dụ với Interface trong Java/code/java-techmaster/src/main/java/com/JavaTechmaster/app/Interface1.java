package com.JavaTechmaster.app;

public interface Interface1 {
    //Interfaces chỉ chứa các method
    void method1();//Instance method ko chứa phần thực
    //Default method => Có chứa phần thực thi
    default void methodX() {
        System.out.println("Default methodX of Interface1");
    }
    //Có thể định nghĩa static method trong Interface
    public static void sayHello(String str) {
        System.out.println("Hello"+str);
    }
}
