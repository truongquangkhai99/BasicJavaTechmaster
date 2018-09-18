/*
* Khoá học Java căn bản + nâng cao, Techmaster Vietnam
* https://techmaster.vn
* Author: Mr Nguyen Duc Hoang
* */
package com.JavaTechmaster.app;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class App {
    public static void main( String[] args ) {
        System.out.println("Tạo danh sách các đối tượng Products quản lý sản phẩm");
        List<Product> products = new ArrayList<Product>();
        Product product1 = new Product("iphone X", 5, 2500);
        Product product2 = new Product("iphone 6", 6, 2600);
        Product product3 = new Product("iphone 7", 9, 2900);
        Product product4 = new Product("iphone 8", 10, 3200);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        //Cho phép nhiều đối tượng trùng nhau trong 1 list
        //products.add(product2);
        //Xoá hết các phần tử trong List ?
        //products.clear();
        //Lấy object tại vị trí bất kỳ
        products.get(2).printDetail();
        //Duyệt danh sách trong List
        products.forEach(product -> {
            product.printDetail();
        });
        System.out.println(products);
        System.out.println("Duyệt bằng Iterator");
        ListIterator<Product> iterator = products.listIterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            product.printDetail();
        }
        System.out.println("Duyệt theo thứ tự ngược lại");
        while (iterator.hasPrevious()) {
            Product product = iterator.previous();
            product.printDetail();
        }
    }
}
