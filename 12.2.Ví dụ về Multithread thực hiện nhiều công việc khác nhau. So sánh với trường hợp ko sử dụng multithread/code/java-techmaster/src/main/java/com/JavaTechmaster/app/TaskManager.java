package com.JavaTechmaster.app;

public class TaskManager implements Runnable {
    private Thread thread;
    private String taskName;
    TaskManager(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i < 10; i++) {
                System.out.println(taskName+" is running step " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            System.out.println(taskName+" is interrupted because of Error : "+e.getMessage());
        }
    }
    public void start() {
        System.out.println("Starting "+taskName);
        if (thread == null) {
            thread = new Thread(this, taskName);
            thread.start();
        }
    }
}
