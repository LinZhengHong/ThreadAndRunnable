package com.linzhenhong.threadcoreknowledge.stopthread;

/**传递中断
 * 最佳实践：catch了InterruptedExcetion之后的优先选择：在方法签名中抛出异常
 * 那么在runp()就会强制try/catch
 */
public class StopThreadProduce implements Runnable {
    @Override
    public void run() {
        while (true){
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                System.out.println("日志");
                e.printStackTrace();
            }
        }
    }
    //异常向上抛
    private void throwInMethod() throws InterruptedException {
        Thread.sleep(3000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(new StopThreadProduce());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
