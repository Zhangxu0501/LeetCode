package problem146_lru_cache;


import java.util.*;
class LRUCache {
    private int capacity;
    private HashMap<Integer,ListNode> map=new HashMap(16);
    private ListNode head;
    private ListNode tail;
    class ListNode{
        public ListNode(int key,int value){
            this.value=value;
            this.key=key;
        }
        public int key;
        public int value;
        public ListNode next;
        public ListNode pre;
    }
    private void delete(ListNode node){
        map.remove(node.key);
        if(node==head&&node==tail){
            head=null;
            tail=null;
        }
        else if(node==head){
            ListNode next=head.next;
            next.pre=null;
            head.next=null;
            head=next;
        }
        else if (node==tail){
            ListNode pre=node.pre;
            pre.next=null;
            node.pre=null;
            tail=pre;
        }
        else {
            ListNode pre=node.pre;
            ListNode next=node.next;
            pre.next=next;
            next.pre=pre;
        }
        capacity+=1;
    }
    private void add(ListNode node){
        map.put(node.key,node);
        if(head==null){
            head=node;
            tail=node;
        }
        else{
            node.next=head;
            head.pre=node;
            head=node;
        }
        capacity-=1;
    }
    private void update(ListNode node){
        delete(node);
        add(node);
    }
    public LRUCache(int capacity) {
        this.capacity=capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            update(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode node=map.get(key);
            node.value=value;
            update(node);
        }
        else{
            ListNode node=new ListNode(key,value);
            add(node);
        }
        if(capacity<0){
            delete(tail);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(1000);
        for(int x=0;x<10000;x++){
            lruCache.put(x,x);
        }
        System.out.println(lruCache);

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */