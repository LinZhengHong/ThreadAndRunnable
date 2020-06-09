package com.linzhenhong.threadcoreknowledge.uncaughtexception;

/**
 * 设置全局异常
 * @author LinZhenHong
 */
public class UseOwnUncaughtExceptionHandler implements Runnable{

    public static void main(String[] args) throws InterruptedException {

        /*
         * 设置自定义的捕获器，也就是设置全局异常，来捕获子线程的异常
         */
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("捕获器One"));

        new Thread(new UseOwnUncaughtExceptionHandler(),"MyThread-1").start();
        Thread.sleep(200);
        new Thread(new UseOwnUncaughtExceptionHandler(),"MyThread-2").start();
        Thread.sleep(200);
        new Thread(new UseOwnUncaughtExceptionHandler(),"MyThread-3").start();
        Thread.sleep(200);
        new Thread(new UseOwnUncaughtExceptionHandler(),"MyThread-4").start();
    }
    @Override
    public void run() {
        throw new RuntimeException();
    }
}
