package com.linzhenhong.threadcoreknowledge.createthreads;

/**
 * 实现Runnable的接口来创建线程
 * 用Runnable的方式实现线程
 */
public class RunnableStyle implements Runnable {

    public static void main(String[] args) {
        new Thread(new RunnableStyle()).start();
    }

    @Override
    public void run() {
        System.out.println("用Runnable的方法实现线程");
    }
}
