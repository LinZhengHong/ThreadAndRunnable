package com.linzhenhong.threadcoreknowledge.stopthread;

/**
 * 线程在普通的情况下停止线程
 */
public class StopThreadWithoutSleep implements Runnable{

    @Override
    public void run() {
        int num=0;
        //本身程序配合通知interrupt
        while (!Thread.currentThread().isInterrupted()&& num <= Integer.MAX_VALUE/2){
            if(num%10000==0){
                System.out.println(num+"是10000的倍数");
            }
            num++;
        }
        System.out.println("任务完成");
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread=new Thread(new StopThreadWithoutSleep());
        thread.start();
        //让正在运行的线程休眠（或者暂停休眠）
        Thread.sleep(2000);
        //interrupt通知线程中断
        thread.interrupt();
    }
}
