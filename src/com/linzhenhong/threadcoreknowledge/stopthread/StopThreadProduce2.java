package com.linzhenhong.threadcoreknowledge.stopthread;

/**不想或无法传递：恢复中断
 * 在catch子语句中调用Thread.currentThread().interrupt()来恢复设置中断状态
 *
 */
public class StopThreadProduce2 implements Runnable {
    @Override
    public void run() {
        while (true){
            if (Thread.currentThread().isInterrupted()){
                System.out.println("Interrupt,程序运行结束");
                break;
            }
            reInterrupt();
            System.out.println("保存日志");
        }
    }
    //异常向上抛
    private void reInterrupt(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            //在这里加上中断
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new StopThreadProduce2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
