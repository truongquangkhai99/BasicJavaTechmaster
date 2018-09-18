/*
* Khoá học Java căn bản + nâng cao, Techmaster Vietnam
* https://techmaster.vn
* Author: Mr Nguyen Duc Hoang
* */
package com.JavaTechmaster.app;

import java.util.HashSet;
import java.util.Iterator;

public class App {
    public static void main( String[] args ) {
        System.out.println("Tạo tập hợp(Set) các đối tượng Products");
        Product product1 = new Product("iphone X", 5, 2500);
        Product product2 = new Product("iphone 6", 6, 2600);
        Product product3 = new Product("iphone 7", 9, 2900);
        Product product4 = new Product("iphone 8", 10, 3200);
        HashSet<Product> products = new HashSet<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product2);//Không báo lỗi nhưng ko được thêm vào
        //Set ko theo thứ tự ban đầu
        products.forEach(product -> {
            product.printDetail();
        });
        //Số các phần tử trong Set
        System.out.println("Number of products = "+products.size());
        //Nhân bản 1 Set
        HashSet<Product> products2 = (HashSet<Product>) products.clone();
        System.out.println("products = "+products);
        System.out.println("products2 = "+products2);
        products2.forEach(product -> {
            product.printDetail();
        });
    }
}
