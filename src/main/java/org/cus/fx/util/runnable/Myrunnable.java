package org.cus.fx.util.runnable;

/**
 * @author ld
 * @name
 * @table
 * @remarks
 */
public class Myrunnable implements Runnable {
//    /        线程
//    Myrunnable myrunnable = new Myrunnable();
//    Thread thread = new Thread(myrunnable);
//        thread.start();
//        thread.wait(5000);

    @Override
    public void run() {
        System.out.println("执行");
    }
}
