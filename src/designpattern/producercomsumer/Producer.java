package designpattern.producercomsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangxu create on 2019/4/26
 * version 1.0
 */
public class Producer implements Runnable{
    private static AtomicInteger integer=new AtomicInteger();
    private BlockingQueue data;
    private String name;

    public Producer(BlockingQueue data, String name) {
        this.data = data;
        this.name = name;
    }

    @Override
    public void run() {
        while (integer.get()<=500){
            int i=integer.incrementAndGet();
            data.add(name+i);
            System.out.println("生产者"+name+"生产了第"+i+"个商品");
        }
    }
}
