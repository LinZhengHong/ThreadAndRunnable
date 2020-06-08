package com.linzhenhong.threadcoreknowledge.stopthread;

/**
 * 如果执行过程中，每次循环调用sleep或者wait时,那么不需要每次迭代检查是否已中断
 */
public class StopThreadWithSleepEveryLoop {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <= 10000) {
                    if (num % 100 == 0)
                        System.out.println(num + "是100的倍数");
                    num++;
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
