/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
Một số biểu thức và hàm toán học pow(hàm mũ), sin, cos
 */
package com.company;

public class Main {
    public static void main(String[] args) {
        //Tính một số ngẫu nhiên từ 0 đến 1
        //System.out.println("Random number = "+Math.random());
        //Số ngẫu nhiên từ 0 đến 10, làm thế nào ?
        //System.out.println("Random number = "+(int)(Math.random() * 10));
        //Tìm giá trị lớn nhất trong 2 số
        System.out.println("Max = "+Math.max(10.3, 12.5));
        //Tìm giá trị nhỏ nhất trong 2 số
        System.out.println("Min = "+Math.min(10.3, 12.5));
        //Lấy giá trị tuyệt đối = lấy giá trị dương = absolute = abs
        System.out.println("abs = "+ Math.abs(-123.45f));
        //Biểu thức nhiều số hạng
        double x = (3 * 2 + 10.2 * 4) / Math.sqrt(2.2 * 3.5 + 120);//sqrt = square root = căn bậc hai
        System.out.printf("Result = %3.2f\n", x);
        //Hàm mũ. VD: 2 * 2 * 2
        System.out.printf("pow = %3.2f\n", Math.pow(2, 4));//pow = power
        //Hàm mũ dưới dạng biểu thức
        double z = 1.2;
        double y = Math.pow(z, 3) + Math.pow(z, 2) + Math.pow(z, 1);
        System.out.println("y = "+y);
        //Hàm sin, cos. VD: sin(90 độ) = sin(PI / 2) = 1
        //System.out.printf("Result = %3.2f", Math.sin(Math.PI / 2));
        double angle = Math.PI / 4;//PI / 4 = 45độ
        System.out.printf("Result = %3.2f", Math.pow(Math.sin(angle), 2) + Math.pow(Math.cos(angle), 2));
    }

}
