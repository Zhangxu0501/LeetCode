package designpattern.observer;

/**
 * @author zhangxu create on 2019/4/1
 * version 1.0
 */
public class Persion implements Observer {
    private  String name;
    public Persion(String name){
        this.name=name;
    }
    public void update(String msg) {
        System.out.println(name+":"+msg);
    }
}
