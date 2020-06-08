package com.linzhenhong.threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.concurrent.ThreadFactory;

/**
 * wait-NofityAll
 */
public class WaitNotifyAll implements Runnable{

    public static final Object resourceA=new Object();


    public static void main(String[] args) throws InterruptedException {
        WaitNotifyAll waitNotifyAll=new WaitNotifyAll();
        Thread threadA=new Thread(waitNotifyAll);
        Thread threadB=new Thread(waitNotifyAll);
        Thread threadC=new Thread(() -> {
            synchronized (resourceA){
                resourceA.notifyAll();
                System.out.println("ThreadC notifyAll");
            }
        });

        threadA.start();
        threadB.start();
        Thread.sleep(200);
        threadC.start();
    }

    @Override
    public void run() {
        synchronized (resourceA){
            System.out.println(Thread.currentThread().getName()+"got resourceA lock");
            try {
                System.out.println(Thread.currentThread().getName()+" wait to start");
                resourceA.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"wait to end");
        }
    }
}
