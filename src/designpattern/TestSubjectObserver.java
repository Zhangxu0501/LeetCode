package designpattern;

/**
 * @author anzhi
 * @date 2019/3/30 5:16 PM
 */
public class TestSubjectObserver {
    public static void main(String[] args) {
        WechatGroup subject=new WechatGroup();
        Observer observer=new Persion("zhangxu");
        Observer observer1=new Persion("siqin");
        Observer observer2=new Persion("syq");
        subject.register(observer);
        subject.register(observer1);
        subject.register(observer2);
        subject.senMessage("111");
        subject.remote(observer1);
        subject.senMessage("888");
    }
}
