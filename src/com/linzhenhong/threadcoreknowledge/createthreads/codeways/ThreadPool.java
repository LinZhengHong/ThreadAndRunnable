package com.linzhenhong.threadcoreknowledge.createthreads.codeways;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 用线程池创建线程
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService executorService=Executors.newCachedThreadPool();
        for(int i=0;i<1000;i++){
            executorService.submit(new TaskRunable(){
            });
        }
    }

    static class TaskRunable implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
}
