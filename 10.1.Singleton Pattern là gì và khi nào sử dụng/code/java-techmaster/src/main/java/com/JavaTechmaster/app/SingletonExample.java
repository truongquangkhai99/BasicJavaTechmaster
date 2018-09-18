package com.JavaTechmaster.app;

public class SingletonExample {
    //private static final SingletonExample instance = new SingletonExample();//Kiểu eager
    //Đối tượng instance chứa nhiều thuộc tính, chiếm nhiều memory thì sao ?
    private static SingletonExample instance;//Ban đầu là null, khi nào gọi mới khởi tạo

    //Lấy ra đối tượng Singleton ?
    public static SingletonExample getInstance() {
        //return instance;
        //synchronized: tại 1 thời điểm chỉ có 1 thread
        synchronized (SingletonExample.class) {
            if(instance == null) {
                System.out.println("instance now is null");
                instance = new SingletonExample();
            }
        }
        return instance;
    }
    //Instance methods
    public void method1() {
        System.out.println("method1 of SingletonExample");
    }
    public void method2() {
        System.out.println("method2 of SingletonExample");
    }
}
