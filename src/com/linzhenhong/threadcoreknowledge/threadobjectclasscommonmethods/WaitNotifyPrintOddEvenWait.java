package com.linzhenhong.threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 两个线程交替打印奇偶数
 */
public class WaitNotifyPrintOddEvenWait{
    public static void main(String[] args) {
        OddEven oddEven=new OddEven();
        Odd odd=new Odd(oddEven);
        Even even=new Even(oddEven);
        new Thread(odd).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(even).start();
    }
}


/**
 * 奇数
 */
class Odd implements Runnable{

    private OddEven oddEven;
    public Odd(OddEven oddEven) {
        this.oddEven = oddEven;
    }

    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            oddEven.odd(i);
        }
    }
}

/**
 * 偶数
 */
class Even implements Runnable{

    private OddEven oddEven;
    public Even(OddEven oddEven) {
        this.oddEven = oddEven;
    }

    @Override
    public void run() {
        for(int i=0;i<=100;i++){
            oddEven.even(i);
        }
    }
}




/**
 * 奇偶数
 */
class OddEven{

    //打印奇数
    public synchronized void odd(int number){
        if(number%2!=1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("奇数"+number);
            notify();
        }
    }

    //打印偶数
    public synchronized void even(int number){
        if (number%2!=0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("偶数"+number);
            notify();
        }
    }
}
