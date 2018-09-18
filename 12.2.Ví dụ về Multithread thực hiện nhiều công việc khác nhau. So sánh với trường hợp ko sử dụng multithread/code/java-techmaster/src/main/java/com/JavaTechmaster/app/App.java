/*
* Khoá học Java căn bản + nâng cao, Techmaster Vietnam
* https://techmaster.vn
* Author: Mr Nguyen Duc Hoang
* */
package com.JavaTechmaster.app;

public class App {
    public static void main( String[] args ) {
        System.out.println("Multi-thread in Java");
        //Giả sử muốn thực hiện song song 2 việc: "nấu cơm"(ThreadA), "luộc rau"(ThreadB)
        Runnable r1 = new Runnable() {//Tạo một object từ class có implement
            private Thread thread;
            public void start() {
                System.out.println("Starting ThreadA");
                if(thread == null) {
                    thread = new Thread(this, "ThreadA");
                }
            }
            @Override
            public void run() {
                try {
                    for(int i = 0; i < 5; i++) {
                        System.out.println("ThreadA is running step "+i);
                        Thread.sleep(50);
                    }
                } catch (InterruptedException e) {
                    System.out.println("ThreadA is interrupted because of Error : "+e.getMessage());
                }
                System.out.println("ThreadA is ended");
            }
        };
        Thread thread1 = new Thread(r1, "ThreadA");
        Runnable r2 = new Runnable() {
            private Thread thread;
            public void start() {
                System.out.println("Starting ThreadB");
                if (thread == null) {
                    thread = new Thread (this, "ThreadB");
                    thread.start();
                }
            }
            //Create an object that implement Runable interface
            @Override
            public void run() {
                try {
                    for(int i = 0; i < 10; i++) {
                        System.out.println("ThreadB is running step " + i);
                        Thread.sleep(50);
                    }
                } catch (InterruptedException e) {
                    System.out.println("ThreadB is interrupted because of Error : "+e.getMessage());
                }
                System.out.println("ThreadB is ended");
            }
        };
        Thread thread2 = new Thread(r2, "ThreadB");
        //thread1.start();
        //thread2.start();
        //Nếu ko có multi-thread, thì sao ?
        //thread1.run();
        //thread2.run();
        //Làm song song những công việc có "tính chất giống nhau" ?
        TaskManager t1 = new TaskManager("TaskA");
        TaskManager t2 = new TaskManager("TaskB");
        TaskManager t3 = new TaskManager("TaskC");
        //Multi-thread, có thể tạo ra nhiều thread tuỳ ý
        t1.start();
        t2.start();
        t3.start();
    }
}
