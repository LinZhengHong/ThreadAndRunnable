package com.linzhenhong.threadcoreknowledge.threadobjectclasscommonmethods;

import java.lang.management.ThreadMXBean;

/**
 * 验证wait只释放当前的锁
 */
public class WaitNotifyReleasemMonitor {


    private static final Object resourceA=new Object();
    private static final Object resourceB=new Object();


    public static void main(String[] args) {

        Thread threadA=new Thread(() -> {
            //获得resourceA的锁
            synchronized (resourceA){
                System.out.println("ThreadA got resourceA lock");

                //获得resourceB的锁
                synchronized (resourceB){
                    System.out.println("ThreadA got resourceB lock");
                }

                try {
                    //释放了resourceA的锁
                    System.out.println("ThreadA releases resourceA lock");
                    resourceA.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        Thread threadB=new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (resourceA){
                System.out.println("ThreadB got resourceA lock");

                System.out.println("ThreadB tries to resourceB lock");
                synchronized (resourceB){
                    System.out.println("ThreadB got resourceB lock");
                }
            }
        });


        threadA.start();
        threadB.start();
    }

}
