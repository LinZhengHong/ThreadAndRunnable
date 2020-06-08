package com.linzhenhong.threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * join期间被中断
 */
public class JoinInterrupt {
    public static void main(String[] args) {
        Thread mainThread=Thread.currentThread();
        Thread thread1=new Thread(() -> {
            try {
                mainThread.interrupt();
                Thread.sleep(5000);
                System.out.println("Thread1 finish");
            } catch (InterruptedException e) {
                System.out.println("子线程被中断");
            }
        });
        thread1.start();
        System.out.println("等待子线程运行完毕");
        try {
            thread1.join();
        } catch (InterruptedException e) {
            //主线程抛出异常
            System.out.println(Thread.currentThread().getName()+"主线程中断了");
            e.printStackTrace();
            thread1.interrupt();
        }
        System.out.println("子线程已执行完毕");
    }
}
