/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
 */
package com.company;

public class Main {
    public static void main(String[] args) {
        double doubleVar = 3.1416;//Ko có f, mặc định là double
        System.out.println("doubleVar = "+doubleVar);
//        Double.MIN_VALUE
        float floatVar = 20.0f;//f = float
        float result = 30.23f * 20.23f;
        System.out.println("result = "+result);
        float modulus = 5 % 2;//Chia lấy phần dư
        System.out.println("modulus = " + modulus);
//        Float.NEGATIVE_INFINITY // -1 / 0
        int intVar = -10;
        long longVar = -123456L;// L = kiểu Long = "số nguyên dài"
        System.out.println("longVar = "+longVar);
        System.out.println("Long's MAX_VALUE = "+Long.MAX_VALUE);
        System.out.println("Integer's MAX_VALUE = "+Integer.MAX_VALUE);
        boolean boolVar1 = false;
        boolean boolVar2 = false;
        System.out.println(boolVar1 && boolVar2);//&&: "phép nhân"
        System.out.println(boolVar1 || boolVar2);//||: "phép cộng"
        System.out.println(boolVar1 ^ boolVar2);//Exlusive OR = "tuyển mạnh", kiểu "phép trừ ko lấy dấu"
        //String = kiểu xâu ký tự
        String str1 = "This is my company's address";
        String str2 = "I said: \"This is my car\"";//Ký tự đặc biệt => thêm \
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str1+"\n"+str2);//\n là "enter xuống dòng"
        //String dài => cắt nhỏ ra để hiển thị
        String multiLines = "Hi everybody."+ //"" chứa string, '' chứa character(ký tự)
                            "I am a student."+
                            "I live in Hanoi";
        System.out.println(multiLines);
        char c = '2';//character(ký tự)
        System.out.println(c);
    }
}
