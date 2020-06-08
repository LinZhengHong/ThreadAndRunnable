package com.linzhenhong.threadcoreknowledge.stopthread;

/**
 * 携带sleep中断线程，不要执行检查是否已中断
 */
public class StopThreadWithSleep {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable=()->{
            int num=0;
            while (num<=300){
                if(num%100==0)
                    System.out.println(num+"是100的倍数");
                num++;
            }
            try {
                //线程执行休眠，中断线程时以catch捕获异常来实现
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread=new Thread(runnable);
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
