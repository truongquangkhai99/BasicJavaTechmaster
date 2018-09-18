/*
* Khoá học Java căn bản + nâng cao, Techmaster Vietnam
* https://techmaster.vn
* Biểu thức chính quy trong Java
* Author: Mr Nguyen Duc Hoang
* */
package com.JavaTechmaster.app;

public class App  {
    public static void main( String[] args ) {
        System.out.println("Regular expression");
        //Tìm những dòng kết thúc bằng games: game$
        //Tìm những nơi có chứa ký tự hoặc a, hoặc b, hoặc c: [abc]
        //Những nơi ko chứa a, hoặc b, hoặc c : [^abc]
        //Những chỗ có ký tự số từ 1-5: [1-5]
        //Chứa chữ game hoặc board: game|board
        //Dòng bắt đầu bằng số và dấu chấm: ^[\d]\.
        //Dòng bắt đầu bằng số và ký tự bất kỳ(0-9, a-z, A-Z): ^[\d].
        //Chữ đầu dòng là số, chữ sau ko phải số: ^[\d][\D]
        //Dấu cách ở cuối dòng: [\s]$
        //Một ký tự bất kỳ, hoa/thường, số : \w
        //Tìm những chỗ có dấu cách xen giữa 2 ký tự: (\w)(\s+)([\w])
    }

}
