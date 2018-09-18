/*
* Khoá học Java căn bản + nâng cao, Techmaster Vietnam
* https://techmaster.vn
* Author: Mr Nguyen Duc Hoang
* */
package com.JavaTechmaster.app;

import java.util.AbstractMap;
import java.util.HashMap;

public class App {
    public static void main( String[] args ) {
        System.out.println("AbstractMap để lưu dữ liệu dạng Key-Value");
        //AbstractMap là 1 abstract class
        //HashMap kế thừa từ AbstractMap, sẽ override các phương thức abstract trong AbstractMap
        AbstractMap<String, Object> mapEmployee = new HashMap<String, Object>();
        if(mapEmployee.isEmpty()) {
            System.out.println("HashMap is empty");
        }
        mapEmployee.put("name", "Hoang");
        mapEmployee.put("age", 30);
        System.out.println("Detail employee: ");
        System.out.println("Name: "+mapEmployee.get("name")+".Age:"+mapEmployee.get("age"));
        System.out.println("Size: "+mapEmployee.size());
        //Map thích hợp với trường hợp số lượng các key nhiều, VD: các điểm trên đồ thị
        AbstractMap<Double, Double> mapPoints = new HashMap<Double, Double>();
        mapPoints.put(1.0, 5.0); //x = 1.0 thì y = 5.0
        mapPoints.put(2.0, 7.0); //x = 2.0 thì y = 7.0
        mapPoints.put(3.5, 6.0); //x = 3.5 thì y = 6.0
        //Có thể thêm / bớt tuỳ ý các key-value
        mapPoints.remove(3.5);
        mapPoints.forEach((key, value)->{
            System.out.println("Key ="+key+".Value = "+value);
        });
        System.out.println("Hashcode: "+mapPoints.hashCode());
        //Phương thức equals
        AbstractMap<String, Object> mapEmployee2 = new HashMap<String, Object>();
        mapEmployee2.put("name", "Hoang");
        mapEmployee2.put("age", 30);
        System.out.println(mapEmployee.equals(mapEmployee2));
    }
}
