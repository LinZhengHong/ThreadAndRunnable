package com.linzhenhong.threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 *sleep响应中断
 */
public class SleepInterrupt implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new SleepInterrupt());
        thread.start();
        TimeUnit.SECONDS.sleep(6);
        thread.interrupt();
    }

    @Override
    public void run() {
        for (int i=0;i<10;i++){
            System.out.println(new Date());
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("我被打断了");
                e.printStackTrace();
            }
        }
    }
}
