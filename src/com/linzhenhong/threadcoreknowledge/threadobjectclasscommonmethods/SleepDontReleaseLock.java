package com.linzhenhong.threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * sleep不会释放所持有的锁，主要 synchronized 和 lock
 * sleep不会释放synchronized的lock（需要手动解锁）
 */
public class SleepDontReleaseLock implements Runnable{

    private static final Lock lock=new ReentrantLock();

    public static void main(String[] args) {
        SleepDontReleaseLock sleepDontReleaseLock=new SleepDontReleaseLock();
        new Thread(sleepDontReleaseLock).start();
        new Thread(sleepDontReleaseLock).start();
    }

    @Override
    public void run() {
        sync();
    }


    private synchronized void sync(){
        lock.lock();
        System.out.println("线程"+Thread.currentThread().getName()+"获得锁");
        try {
            Thread.sleep(5000);
            System.out.println("线程"+Thread.currentThread().getName()+"已经苏醒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
