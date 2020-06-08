package com.linzhenhong.threadcoreknowledge.sixstates;

/**
 * 线程的TimedWaiting,Blocked,Waiting三种状态
 */
public class BlockedWaitingTimedWaiting implements Runnable{

    public static void main(String[] args) {
        BlockedWaitingTimedWaiting blockedWaitingTimedWaiting=new BlockedWaitingTimedWaiting();
        Thread thread1=new Thread(blockedWaitingTimedWaiting);
        thread1.start();

        Thread thread2=new Thread(blockedWaitingTimedWaiting);
        thread2.start();
        //因为不能保证线程就能start运行
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
        try {
            Thread.sleep(1600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread1.getState());
    }



    @Override
    public void run() {
        sync();
    }

    private synchronized void sync(){
        try {
            Thread.sleep(1300);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
