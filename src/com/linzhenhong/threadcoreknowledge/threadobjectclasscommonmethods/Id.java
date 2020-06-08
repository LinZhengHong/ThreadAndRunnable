package com.linzhenhong.threadcoreknowledge.threadobjectclasscommonmethods;


/**
 *描述:线程Id, ID从1开始，JVM运行起来后，我们自己创建的线程的ID早已不是1
 * @author LinZhenHong
 */
public class Id {



    public static void main(String[] args) {
        Thread thread=new Thread();
        System.out.println("主线程ID"+Thread.currentThread().getId());

        /*private static synchronized int nextThreadNum() {
            return ++threadInitNumber;
            线程启动时从源码可以看出threadInitNumber先自增的，
            而且线程还帮我们创建了其他线程,
            例如Signal Dispatcher（把操作系统的信号发给适当的程序）,Reference Handle（JC引用相关线程）,Finalizer（执行对象的Finalizer方法）等
        }*/
        System.out.println("子线程ID"+thread.getId());
    }
}
