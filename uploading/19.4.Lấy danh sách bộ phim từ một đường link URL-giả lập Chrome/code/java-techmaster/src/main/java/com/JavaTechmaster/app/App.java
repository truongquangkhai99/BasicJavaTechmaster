/*
* Khoá học Java căn bản + nâng cao, Techmaster Vietnam
* https://techmaster.vn
* Biểu thức chính quy trong Java
* Author: Mr Nguyen Duc Hoang
* */
package com.JavaTechmaster.app;

import java.util.List;

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
        //Tìm các string có dạng địa chỉ email: [A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,6}
        //Lấy ra tên các bộ phim: <span class="movie-title-1">(.*?)</span>
        /*
        RegexExample regexExample = new RegexExample(
                "/Users/hoangnd/Documents/inputData.txt");
        List<String> emails = regexExample.findEmails();
        emails.forEach(email -> {
            System.out.println("Email: "+email);
        });
        */
        RegexExample regexExample = new RegexExample(
                "/Users/hoangnd/Documents/films.txt",
                "http://www.phimmoi.net/phim-chieu-rap/page-3.html");
        //List<String> films = regexExample.findFilmNames();
        List<String> films = regexExample.findFilmNamesFromURL();
        films.forEach(film -> {
            System.out.println("film : "+film);
        });
    }

}
