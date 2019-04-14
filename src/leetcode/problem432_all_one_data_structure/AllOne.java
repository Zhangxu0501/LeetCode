package leetcode.problem432_all_one_data_structure;

import java.util.*;

/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
public class AllOne {
    private Map<String,Node> map=new HashMap();
    private Node tail;
    private Node head;
    class Node{
        public Node(String key,int value){
            this.value=value;
            this.keys=new ArrayList();
            keys.add(key);
        }
        public List<String> keys;
        public int value;
        public Node pre;
        public Node next;
    }
    /** Initialize your data structure here. */
    public AllOne() {

    }

    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            map.remove(key);
            node.keys.remove(key);
            int newValue=node.value+1;
            Node currentNext=node.next;

            if(currentNext==null||currentNext.value!=newValue){
                Node newNode=new Node(key,newValue);
                insert(node,newNode);
                map.put(key,newNode);
            }
            else {
                currentNext.keys.add(key);
                map.put(key,node.next);
            }
            if(node.keys.size()==0){
                delete(node);
            }
        }
        else {
            if(head!=null&&head.value==1){
                head.keys.add(key);
                map.put(key,head);
            }
            else {
                Node newNode=new Node(key,1);
                insert(head,newNode);
                head=newNode;
                map.put(key,newNode);
            }

        }
    }

    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.keys.remove(key);
            map.remove(key);
            if(node.value!=1){
                int newValue=node.value-1;
                if(node.pre!=null&&node.pre.value==newValue){
                    node.pre.keys.add(key);
                    map.put(key,node.pre);
                }
                else{
                    Node newNode=new Node(key,newValue);
                    insert(node.pre,newNode);
                    map.put(key,newNode);
                }
            }
            if(node.keys.size()==0){
                delete(node);
            }
        }
    }

    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(head==null){
            return "";
        }
        return head.keys.get(0);
    }

    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(tail==null){
            return "";
        }
        return tail.keys.get(0);
    }
    public void insert(Node pre,Node now){
        if(head==null&&tail==null){
            head=now;
            tail=now;
        }
        else if(pre==head&&pre==tail){
            head.next=now;
            now.pre=head;
            tail=now;
        }
        else if(pre==head){
            Node headNext=pre.next;
            pre.next=now;
            now.pre=head;
            now.next=headNext;
            headNext.pre=now;
        }
        else if(pre==tail){
            tail.next=now;
            now.pre=tail;
            tail=now;
        }
        else {
            Node next=pre.next;
            pre.next=now;
            now.pre=pre;
            now.next=next;
            next.pre=now;
        }
    }
    public void delete(Node now){
        if(head==now&&tail==now){
            tail=null;
            head=null;
        }
        else if(head==now){
            head=head.next;
            head.pre=null;
        }
        else if(tail==null){
            tail=tail.pre;
            tail.next=null;
        }
        else {
            Node pre=now.pre;
            Node next=now.next;
            pre.next=next;
            next.pre=pre;
        }
    }

    public static void main(String[] args) {
        AllOne allOne=new AllOne();
        allOne.inc("hello");
        allOne.inc("hello");

        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
        allOne.inc("aaa");
        allOne.inc("aaa");
        allOne.dec("aaa");
        System.out.println(allOne.getMaxKey());
        System.out.println(allOne.getMinKey());
    }
}
