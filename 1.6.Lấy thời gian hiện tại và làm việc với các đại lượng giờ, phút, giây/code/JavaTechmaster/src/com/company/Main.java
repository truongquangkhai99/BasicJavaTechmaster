/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
Lấy thời gian hiện tại và làm việc với các đại lượng giờ, phút, giây
 */
package com.company;

public class Main {
    public static void main(String[] args) {
        //Thời gian tính từ 1/1/1970 đến thời điểm hiện tại
        //System.out.printf("Current time(ms) = %d", System.currentTimeMillis());
        //Áp dụng để tính thời gian hoàn thành một công việc nào đó
        /*
        long startTime = System.currentTimeMillis();
        //Công việc x,y,z
        System.out.println(Math.pow(2, 100) + Math.sin(Math.PI / 3));
        System.out.println(Math.pow(2, 200) + Math.sin(Math.PI / 4));
        System.out.println(Math.pow(2, 300) + Math.sin(Math.PI / 5));
        System.out.println(Math.pow(2, 400) + Math.sin(Math.PI / 6));
        System.out.println(Math.pow(2, 500) + Math.sin(Math.PI / 7));
        System.out.println(Math.pow(2, 600) + Math.sin(Math.PI / 8));
        System.out.println(Math.pow(2, 700) + Math.sin(Math.PI / 9));
        System.out.println(Math.pow(2, 800) + Math.sin(Math.PI / 10));
        long endTime = System.currentTimeMillis();
        System.out.printf("This work takes %d miliseconds", endTime - startTime);
        */
        //Bài toán lấy giờ phút giây hiện tại
        long totalMiliseconds = System.currentTimeMillis();
        //Từ 1/1/1970 đến giờ là bao nhiêu giây ?
        long totalSeconds = totalMiliseconds / 1000;
        System.out.printf("totalSeconds = %d\n", totalSeconds);
        //Hiện tại là giây thứ bao nhiêu => chia cho 60 lấy phần dư
        long currentSeconds = totalSeconds % 60;
        System.out.printf("currentSeconds = %d\n", currentSeconds);
        //Tổng số phút tính từ 1/1/1970 đến lúc này ?
        long totalMinutes = totalSeconds / 60;
        System.out.printf("totalMinutes = %d\n", totalMinutes);
        //Hiện tại phút thứ bao nhiêu ? => chia 60 lấy phần dư
        long currentMinutes = totalMinutes % 60;
        System.out.printf("currentMinutes = %d\n", currentMinutes);
        //Tổng số giờ tính từ 1/1/1970 đến lúc này ?
        long totalHours = totalMinutes / 60;
        System.out.printf("totalHours = %d\n", totalHours);
        //Bây giờ là mấy giờ => chia cho 24 lấy phần dư
        //long currentHours = totalHours %24;//Đây là giờ GMT, giờ Hà Nội là GMT+7
        long currentHours = totalHours % 24 + 7;
        System.out.printf("currentHours = %d\n", currentHours);
        System.out.println("Current time = "+currentHours+": "+currentMinutes+": "+currentSeconds);

    }

}
