package com.linzhenhong.threadcoreknowledge.threadobjectclasscommonmethods;

/**
 *join的用法
 * 作用：因为新的线程加入了我们，要等子线程执行完在出发
 * MAIN主线程等待Child Thread执行完毕，注意谁等谁
 */
public class Join {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1=new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"执行完毕");
        });

        Thread thread2=new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"执行完毕");
        });

        thread1.start();
        thread2.start();
        System.out.println("开始等待子线程执行完毕");
        thread1.join();
        thread2.join();
        System.out.println("所有子线程执行完毕");
    }
}
