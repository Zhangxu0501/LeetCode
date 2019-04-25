package designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anzhi
 * @date 2019/3/30 5:10 PM
 */
public class WechatGroup implements Subject {
    private List<Observer> observerList;
    private String message;
    public WechatGroup(){
        observerList=new ArrayList();
    }

    public void register(Observer observer) {
        observerList.add(observer);
    }

    public void remote(Observer observer) {
        observerList.remove(observer);
    }

    public void notifyObserver() {
        for(Observer observer:observerList){
            observer.update(message);
        }
    }
    public void senMessage(String message){
        this.message=message;
        notifyObserver();
    }
}
