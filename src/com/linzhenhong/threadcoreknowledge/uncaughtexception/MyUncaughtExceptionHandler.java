package com.linzhenhong.threadcoreknowledge.uncaughtexception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 自定义的UncaughtExceptionHandler异常捕获器
 * @author LinZhenHong
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private String name;

    /**
     * 自定义捕获器名字
     * @param name
     */
    public MyUncaughtExceptionHandler(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable e) {
        Logger logger=Logger.getAnonymousLogger();
        logger.log(Level.WARNING,"线程异常,终止啦",thread.getName());
        System.out.println(name+"捕获了异常"+thread.getName()+" 异常"+e);
    }
}
