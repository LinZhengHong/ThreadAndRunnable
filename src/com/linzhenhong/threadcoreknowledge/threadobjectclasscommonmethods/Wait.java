package com.linzhenhong.threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * wait的普通使用方法
 */
public class Wait {

    public static final Object object=new Object();



    static class Thread0 extends Thread{

        @Override
        public void run() {
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"开始执行");
                try {
                    //object线程处于暂停状态，同时释放了锁
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //获得锁后被唤醒，执行下面命令
                System.out.println(Thread.currentThread().getName()+"获得了锁");
            }

        }
    }


    static class Thread1 extends Thread{

        //而Thread1这里object获得了锁
        @Override
        public void run() {
            synchronized (object){
                //唤醒线程，使得Thread0重新获得了锁，要执行了下面语句才能跳到唤醒后的Threa0线程
                object.notify();
                System.out.println(Thread.currentThread().getName()+"调用了notify");
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Thread0 thread0=new Thread0();
        Thread1 thread1=new Thread1();
        thread0.start();
        //休眠一下
        Thread.sleep(200);
        thread1.start();
    }


}
