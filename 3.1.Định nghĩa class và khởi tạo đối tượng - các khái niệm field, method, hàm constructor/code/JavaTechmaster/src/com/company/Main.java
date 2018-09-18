/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
Định nghĩa class và khởi tạo đối tượng - các khái niệm field, method, hàm constructor
 */
package com.company;

public class Main {
    public static void main(String[] args) {
        //Làm thế nào để khởi tạo đối tượng ?
        Television tv = new Television(2, 3, true);
        //Gọi phương thức bằng cách nào ?
        tv.showDetail();
        Television tv2 = tv;//Hai đối tượng tv2 và tv cùng trỏ đến 1 vùng nhớ
        //tv thay đổi, => tv2 thay đổi theo
        tv.channel = 200;
        tv2.showDetail();
        System.out.println("End program");
    }

}
