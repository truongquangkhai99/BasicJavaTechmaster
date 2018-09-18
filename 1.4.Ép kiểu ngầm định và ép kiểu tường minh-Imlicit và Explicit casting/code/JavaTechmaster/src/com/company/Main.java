/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
 */
package com.company;

public class Main {
    public static void main(String[] args) {
	    int x = 10;
	    float y = x;//Implicit casting: Ép kiểu "ngầm định", từ kiểu nhỏ => kiểu to.VD: int sang float
        System.out.println("y = "+y);
        double floatVar = 123.345;
        int intVar = (int)floatVar;//Explicit casting: Ép kiểu "tường minh", từ to => nhỏ. VD: float sang int
        System.out.println("intVar = "+intVar);
        boolean a = false;
//        int b = (boolean)a;//Kiểu dữ liệu boolean ko cho ép kiểu
        //Kiểu ký tự - char = character
        char char1 = (char)65;//Tham khảo bảng mã ASCII
        System.out.println("char1 = "+char1);
        //Kiểu byte ngược lại của char
        byte byte1 = (byte)'A';
        System.out.println("byte1 = "+byte1);
    }
}
