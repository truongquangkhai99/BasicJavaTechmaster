/*
 * Khoá học Java căn bản + nâng cao, Techmaster Vietnam
 * https://techmaster.vn
 * Author: Mr Nguyen Duc Hoang
 * */

package com.JavaTechmaster.app;

public class Calculation {
    public Integer divide2Number(Integer x, Integer y) {
        try {
            Integer result = x / y;
            return result;
        } catch (ArithmeticException e) {
            System.err.println("Arithmetic Exception : " + e.getMessage());
            return Integer.MAX_VALUE;//Có thể trả về giá trị khác, tuỳ bài toán
        } finally {
            System.out.println("This is finally...");
        }
    }
}
