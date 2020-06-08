package com.linzhenhong.threadcoreknowledge.startthread;

/**
 * 启动新建线程 start
 */
public class StartAndRunMethod {
    public static void main(String[] args) {
        Runnable runnable= ()->{
            System.out.println(Thread.currentThread().getName());
        };
        //启动使用主线程执行的
        runnable.run();
        //启动创建子线程,通知JVM来启动新线程，但不一定就可以运行，要有准备工作，由线程调度器来决定是否具备可以运行
        new Thread(runnable).start();
    }
}
