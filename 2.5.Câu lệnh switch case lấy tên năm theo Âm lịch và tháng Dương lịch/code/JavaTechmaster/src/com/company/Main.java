/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
Bài: Câu lệnh switch..case. Ví dụ tính toán tên tháng theo Dương lich và Âm lịch
 */
package com.company;

public class Main {
    public static void main(String[] args) {
        int month = 15;
        String monthString;
        switch (month) {
            case 1:
                monthString = "January";
                break;
            case 2:
                monthString = "February";
                break;
            case 3:  monthString = "March";break;
            case 4:  monthString = "April";break;
            case 5:  monthString = "May";break;
            case 6:  monthString = "June";break;
            case 7:  monthString = "July";break;
            case 8:  monthString = "August";break;
            case 9:  monthString = "September";break;
            case 10: monthString = "October";break;
            case 11: monthString = "November";break;
            case 12: monthString = "December";break;
            //Các giá trị ngoài khoảng 1..12 => làm thế nào ?
            default: monthString = "Invalid month";break;
        }
        System.out.println("monthString = "+monthString);
        //VD2: Tính năm âm lịch. VD: year = 2018 => "Dog - "Tuất
        int year = 1990;
        switch (year % 12) { //Năm chia 12, lấy phần dư => 0 là Thân, 1 là Dậu, 2 là Tuất...
            case 0: System.out.println("monkey - Thân"); break;
            case 1: System.out.println("rooster - Dậu"); break;
            case 2: System.out.println("dog - Tuất"); break;
            case 3: System.out.println("pig - Hợi"); break;
            case 4: System.out.println("rat - Tí"); break;
            case 5: System.out.println("ox- Sửu"); break;
            case 6: System.out.println("tiger - Dần"); break;
            case 7: System.out.println("rabbit - Mão"); break;
            case 8: System.out.println("dragon - Thìn"); break;
            case 9: System.out.println("snake - Tỵ"); break;
            case 10: System.out.println("horse - Ngọ"); break;
            case 11: System.out.println("sheep - Mùi");
            //Ko có default, vì số năm / 12 luôn dư 0...11
        }
    }
}
