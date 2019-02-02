package problem148_sort_list;


import problem2_add_two.ListNode;

/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */

class Solution {
    public static ListNode sortList(ListNode head) {
        return head==null?null:mergeSort(head);
    }

    public static ListNode mergeSort(ListNode head){
        if(head.next==null){
            return head;
        }
        ListNode p=head,q=head,pre=null;
        while(q!=null&&q.next!=null){
            pre=p;
            p=p.next;
            q=q.next.next;
        }
        pre.next=null;
        ListNode l=mergeSort(head);
        ListNode r=mergeSort(p);

        return merge(l,r);

    }
    public static ListNode merge(ListNode l,ListNode r){
        ListNode temp=new ListNode(0);
        ListNode cur=temp;
        while (l!=null&&r!=null){
            if(l.val<r.val){
                cur.next=l;
                cur=cur.next;
                l=l.next;
            }
            else {
                cur.next=r;
                cur=cur.next;
                r=r.next;
            }
        }
        if(l!=null){
            cur.next=l;
        }
        if(r!=null){
            cur.next=r;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(4);
        head.next=new ListNode(2);
        head.next.next=new ListNode(1);
        head.next.next.next=new ListNode(3);
        System.out.println(sortList(head));
    }
}