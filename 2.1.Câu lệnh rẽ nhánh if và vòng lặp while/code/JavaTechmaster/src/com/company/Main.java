/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
 */
package com.company;

import static java.lang.Math.PI;

public class Main {
    public static void main(String[] args) {
        //Câu lệnh điều kiện if
        double radius = -10.12;
        if (radius >= 0) {
            double area = radius * radius * PI;
            System.out.println("circle's area with R = " +
                                radius + " is: " + Math.round(area*100.00)/100.00);
        } else {
            System.out.println("Radius must be > 0");
        }
        //Câu lệnh if nhiều điều kiện
        float score = 55.0f;
        if (score >= 90.0) System.out.println("A");//Có 1 dòng lệnh thì ko cần { }
        else if(score >= 80.0) System.out.println("B");
        else if (score >= 70.0) System.out.println("C");//Từ 70.0 đến 80.0
        else if (score >= 60.0) System.out.println("D");//Từ 60.0 đến 70.0
        else System.out.print("F");//Dưới 60.0
        //Vòng lặp while.
        int count = 0;
        while (count < 1000) {
            //count = count + 1;
            //Chỉ in ra số chẵn
            if (count %2 == 0) {
                System.out.println("count = "+count);
            }
            count++;
        }
        //Vòng for
        for (int i = 0; i <= 9; i++)
            System.out.printf(" %2d",i);//Dành khoảng rộng 2 ký tự để hiển thị i
        System.out.println("\n------------------------------");
        for(int i = 1; i <= 9; i++) {
            System.out.print(i + " | ");
            //Thêm vòng lặp nữa
            for(int j = 1; j <= 9; j++) {
                //printf = print formatted, %d =  decimal integer.
                System.out.printf("%2d ", i * j);
            }
            System.out.println();
        }

    }
}
