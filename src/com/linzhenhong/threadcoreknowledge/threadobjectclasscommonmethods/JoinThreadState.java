package com.linzhenhong.threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 描述： 先join再mainThread，验证join执行期间线程是WAITING状态
 */
public class JoinThreadState {
    public static void main(String[] args) throws InterruptedException {
        Thread mainThread=Thread.currentThread();
        Thread thread=new Thread(() -> {
            try {
                Thread.sleep(5000);
                System.out.println(mainThread.getState());
                System.out.println("thead-0运行结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
        System.out.println("等待子线程运行完毕");
        thread.join();
        System.out.println("子线程运行完毕");
    }
}
