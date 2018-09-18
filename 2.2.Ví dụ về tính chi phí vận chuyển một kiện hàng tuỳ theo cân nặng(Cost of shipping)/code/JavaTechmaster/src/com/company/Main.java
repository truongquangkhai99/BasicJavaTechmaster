/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
Ví dụ về tính chi phí vận chuyển một kiện hàng tuỳ theo cân nặng(Cost of shipping)
 */
package com.company;

public class Main {
    static float getCostOfShipping(float weight) {
        if (weight > 0 && weight <=1) {
            //0 < weight <= 1
            return 3.5f;
        } else if (weight > 1 && weight <= 3) {
            //Thêm các trường hợp khác
            return 5.5f;
        } else if (weight > 3 && weight <= 10) {
            return 8.5f;
        } else if (weight > 10 && weight <= 20) {
            return 10.5f;
        } else {
            return -1;//Các trường hợp còn lại
        }
    }
    public static void main(String[] args) {
        //getCostOfShipping phải là phương thức static
        float costOfShipping = getCostOfShipping(21.0f);
        if (costOfShipping > 0) {
            System.out.println("costOfShipping = "+costOfShipping);
        } else {
            System.out.println("Cannot ship this package");
        }

    }

}
