package problem146_lru_cache;

import java.util.*;
class LRUCache {
    private int capacity;
    private HashMap<Integer,ListNode> map=new HashMap(16);
    private ListNode head;
    private ListNode tail;
    class ListNode{
        public ListNode(int value){
            this.value=value;
        }
        private int value;
        private ListNode next;
        private ListNode pre;
    }
    private void delete(ListNode node){
        ListNode pre=node.pre;
        ListNode next=node.next;
        pre.next=next;
        next.pre=pre;
        capacity+=1;
    }
    private void add(ListNode node){
        if(head==null){
            head=node;
            tail=node;
        }
        else{
            node.next=head;
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
            ListNode node=new ListNode(value);
            map.put(key,node);
            add(node);
        }
        if(capacity<0){
            delete(tail);
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(10);
        lruCache.put(1,1);
        lruCache.put(2,2);
        System.out.println(lruCache.get(1));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */