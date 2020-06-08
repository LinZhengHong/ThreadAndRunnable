package com.linzhenhong.threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.Date;
import java.util.LinkedList;

/**
 * 生产者和消费者模式
 */
public class ProducerCustomerModel {
    public static void main(String[] args) {
        EventStorage storage=new EventStorage();
        Customer customer=new Customer(storage);
        Producer producer=new Producer(storage);

        new Thread(producer).start();
        new Thread(customer).start();


    }
}

/**
 * 生产者
 */
class Producer implements Runnable{

    private EventStorage storage;
    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            storage.put();
        }
    }
}

/**
 * 消费者
 */
class Customer implements Runnable{

    private EventStorage storage;
    public Customer(EventStorage storage) {
        this.storage = storage;
    }


    @Override
    public void run() {
        for (int i=0;i<100;i++){
            storage.take();
        }
    }
}


/**
 * 仓库
 */
class EventStorage {

    private int maxSize;
    //用链表来存储数据
    private LinkedList<Date> storage;

    public EventStorage() {
        maxSize = 10;
        storage = new LinkedList<>();
    }

    public synchronized void put() {
        //如果仓库满的话，就wait
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("仓库里有了" + storage.size() + "个产品");
        //通知消费者可以来消费了
        notify();
    }


    public synchronized void take() {
        //如果仓库为空，就wait
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("从仓库拿到了" + storage.poll() + ",现在仓库还剩下" + storage.size());
        //通知生产者要生产了
        notify();
    }
}

