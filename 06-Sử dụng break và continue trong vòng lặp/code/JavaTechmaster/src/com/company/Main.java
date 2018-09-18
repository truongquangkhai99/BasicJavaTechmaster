/*
Khoá học Java căn bản - Techmaster
Trainer: Nguyễn Đức Hoàng
 */
package com.company;

public class Main {
    public static void main(String[] args) {
        //break = Thoát hẳn khỏi vòng lặp
        for (int i = 0; i < 100; i++) {
            /*
            if (i == 11) {
                break;
            }
            */
            if(i % 2 != 0) {
                continue; //continue: bỏ qua bước này, chuyển sang dòng 10
            }
            System.out.println("i = "+i);//Chỉ in ra các số chẵn
        }
        //Sau lệnh break; sẽ nhảy xuống đây
        //System.out.println("End of program");
        //Kiểm tra 1 string là xâu đối xứng - Palindrome
        String exampleString = "moon";//noon,
        int startIndex = 0;
        int endIndex = exampleString.length() - 1;
        boolean isPalindrome = true;
        while (startIndex < endIndex) {
            if (exampleString.charAt(startIndex) != exampleString.charAt(endIndex)) {
                isPalindrome = false;
                break;
            }
            startIndex++;
            endIndex--;
        }
        if (isPalindrome) {
            System.out.println(exampleString + " is a palindrome");
        } else {
            System.out.println(exampleString + " is not a palindrome");
        }
    }
}
