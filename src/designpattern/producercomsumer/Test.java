package designpattern.producercomsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangxu create on 2019/4/26
 * version 1.0
 */
public class Test {
    public static void main(String[] args) {
        BlockingQueue blockingQueue=new LinkedBlockingQueue();
        Comsumer comsumer1=new Comsumer(blockingQueue,"张三");
        Comsumer comsumer2=new Comsumer(blockingQueue,"李四");
        Producer producer1=new Producer(blockingQueue,"王五");
        Producer producer2=new Producer(blockingQueue,"宋麻");
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(10,10,60L, TimeUnit.SECONDS,new LinkedBlockingQueue<>());
        threadPoolExecutor.execute(comsumer1);
        threadPoolExecutor.execute(comsumer2);
        threadPoolExecutor.execute(producer1);
        threadPoolExecutor.execute(producer2);
    }

}
