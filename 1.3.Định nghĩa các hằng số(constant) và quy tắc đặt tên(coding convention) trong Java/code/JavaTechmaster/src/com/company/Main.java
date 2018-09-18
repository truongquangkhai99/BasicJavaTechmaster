/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
Định nghĩa các biến,hằng số(constant) và quy tắc đặt tên(coding convention) trong Java
 */
package com.company;

public class Main {
    public static void main(String[] args) {
        int x = 10;//Khai báo một biến kiểu số nguyên - integer
        x = 11; //Có thể gán giá trị một biến cho giá trị mới
        long creditCardNumber = 1234_5678_9101_1213L;//Một biến kiểu số nguyên dài(Long)
        int i, j, k; //Khai báo đồng thời nhiều biến(3 biến integer)
        float a = 1.0f, b = 2.0f; //Khai báo và khởi tạo nhiều biến đồng thời
        i = j = k = 10;//Gán nhiều giá trị đồng thời
        System.out.printf("i = %d, j = %d, k = %d \n", i, j, k);//printf = print format
        final double PI = 3.1416;//final = constant = Không thay đổi được giá trị sau lệnh này
        //PI = 3.15;
        double radius = 2.3;//Biến luôn viết thường ký tự đầu tiên(lowerCamelCase)
        double areaOfACircle = radius * radius * PI;//area of a circle = areaOfACircle
        //In ra màn hình kèm "xuống dòng"
//        System.out.println("area of a circle = "+areaOfACircle);
        System.out.printf("area of a circle = %3.2f", areaOfACircle);
    }
    //Tên hàm cũng viết thường ký tự đầu, tên hàm là "động từ", tên biến là "danh từ"
    int addTwoNumbers(int x, int y) { //addTwoNumbers = add two numbers
        return x + y;
    }
}
