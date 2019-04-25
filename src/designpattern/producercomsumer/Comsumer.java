package designpattern.producercomsumer;

import java.util.concurrent.BlockingQueue;

/**
 * @author zhangxu create on 2019/4/26
 * version 1.0
 */
public class Comsumer implements Runnable{
    private BlockingQueue data;
    private String name;

    public Comsumer(BlockingQueue data, String name) {
        this.data = data;
        this.name = name;
    }

    @Override
    public void run() {
        while (true){
            try {
                String a=(String) data.take();
                System.out.println("消费者"+name+"消费了"+a);
            }
            catch (Exception exc){
                System.out.println("获取商品失败");
            }
        }
    }
}
