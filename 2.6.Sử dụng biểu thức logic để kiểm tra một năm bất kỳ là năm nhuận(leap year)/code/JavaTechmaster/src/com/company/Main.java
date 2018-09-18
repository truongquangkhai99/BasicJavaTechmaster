/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
Sử dụng biểu thức logic để kiểm tra một năm bất kỳ là năm nhuận(leap year)
 */
package com.company;

public class Main {
    public static void main(String[] args) {
        //Leap year = năm nhuận
        //Năm nhuận là: năm chia hết cho 4 VÀ không chia hết cho 100
        //HOẶC: năm chia hết cho 400
        int year = 2008;
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        if (isLeapYear) {
            System.out.printf("Year %d is a leap year", year);
        } else {
            System.out.printf("Year %d is NOT a leap year", year);
        }
    }

}
