package com.linzhenhong.threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * sleep不会释放所持有的锁，主要 synchronized 和 lock
 * sleep不会释放synchronized的monitor
 */
public class SleepDontReleaseMonitor implements Runnable{


    public static void main(String[] args) {
        SleepDontReleaseMonitor sleepDontReleaseMonitor=new SleepDontReleaseMonitor();

        new Thread(sleepDontReleaseMonitor).start();
        new Thread(sleepDontReleaseMonitor).start();
    }

    @Override
    public void run() {
        sync();
    }


    private synchronized void sync(){
        System.out.println("线程"+Thread.currentThread().getName()+"获得monitor");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程"+Thread.currentThread().getName()+"退出同步代码块");
    }
}
