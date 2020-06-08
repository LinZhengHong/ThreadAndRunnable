package com.linzhenhong.threadcoreknowledge.startthread;

/**
 * 不能同时调用两次start method
 * 线程执行完毕就为中止状态，不可能返回回去
 */
public class cannotstarttwice {
    public static void main(String[] args) {
        Thread thread=new Thread();
        thread.start();
        thread.start();
    }
}
