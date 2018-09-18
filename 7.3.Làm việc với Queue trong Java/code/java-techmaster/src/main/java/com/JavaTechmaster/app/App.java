/*
* Khoá học Java căn bản + nâng cao, Techmaster Vietnam
* https://techmaster.vn
* Author: Mr Nguyen Duc Hoang
* */
package com.JavaTechmaster.app;

import java.util.LinkedList;
import java.util.Queue;

public class App {
    public static void main( String[] args ) {
        System.out.println("Ví dụ về Queue");
        //Queue => First In First Out = FIFO
        Product product1 = new Product("iphone X", 5, 2500);
        Product product2 = new Product("iphone 6", 6, 2600);
        Product product3 = new Product("iphone 7", 9, 2900);
        Product product4 = new Product("iphone 8", 10, 3200);
        Queue<Product> waitingProducts = new LinkedList<>();
        waitingProducts.add(product1);
        waitingProducts.add(product2);
        waitingProducts.add(product3);
        waitingProducts.add(product4);
        //Xoá một object
        //waitingProducts.remove();
        //Xoá tại vị trí "đầu" hoặc "cuối"
        //((LinkedList<Product>) waitingProducts).removeFirst();
        //((LinkedList<Product>) waitingProducts).removeLast();
        //Xoá object tại vị trí bất kỳ
        //((LinkedList<Product>) waitingProducts).remove(2);
        //Lấy ra object đã xoá
        Product deletedProduct = waitingProducts.poll();
        if(deletedProduct != null) {
          System.out.println("Deleted product:");
          deletedProduct.printDetail();
        }
        waitingProducts.forEach(product ->{
            product.printDetail();
        });

    }
}
