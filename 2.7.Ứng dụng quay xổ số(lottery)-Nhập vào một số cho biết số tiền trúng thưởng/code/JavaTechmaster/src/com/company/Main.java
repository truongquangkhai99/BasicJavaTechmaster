/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
Ứng dụng quay xổ số(lottery)-Nhập vào một số cho biết số tiền trúng thưởng
 */
package com.company;

public class Main {
    public static void main(String[] args) {
        //Quay số trúng thưởng: 1 số nguyên ngẫu nhiên từ 0 đến 100
        //int lotteryNumber = (int)(Math.random() * 100);//Số trúng thưởng
        int lotteryNumber = 21;
        //Số hàng chục và số hàng đơn vị của số trúng thưởng ?
        int digit1 = lotteryNumber / 10; //Giá trị hàng chục
        int digit2 = lotteryNumber % 10; //Giá trị hàng đơn vị
        System.out.printf("lottery number: %d, digit1: %d, digit2: %d \n",
                            lotteryNumber, digit1, digit2);
        //Phía người chơi
        int playerNumber = 55;
        //Số hàng chục và số hàng đơn vị của số người chơi đánh
        int playerDigit1 = playerNumber / 10; //Giá trị hàng chục
        int playerDigit2 = playerNumber % 10; //Giá trị hàng đơn vị
        if (lotteryNumber == playerNumber) {
            //Trúng giải
            System.out.println("You won $10.000");
        } else if(playerDigit1 == digit1 || playerDigit2 == digit2) {
            //Giải khuyến khích - chỉ trúng 1 trong 2 số hàng chục / đơn vị
            System.out.println("You won $1000");
        } else {
            //Không trúng giải nào
            System.out.println("Not match, good luck");
        }
    }

}
