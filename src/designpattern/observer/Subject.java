package designpattern.observer;

/**
 * @author zhangxu create on 2019/4/1
 * version 1.0
 */
public interface Subject {
    public void register(Observer observer);
    public void remote(Observer observer);
    public void notifyObserver();
}
