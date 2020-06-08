package com.linzhenhong.threadcoreknowledge.createthreads;


/**
 *使用Thread来实现线程
 * 通过继承Thread来重写run方法
 */
public class ThreadStyle extends Thread {
    @Override
    public void run() {
        System.out.println("用Thread实现线程");
    }

    public static void main(String[] args) {
        new ThreadStyle().start();
    }
}
