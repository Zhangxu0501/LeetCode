package problem142_linked_list_cycle_ii.problem93_restore_ip_addresses;

import problem2_add_two.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode p1=head;
        ListNode p2=head;
        boolean flag=false;
        while(p2!=null&&p2.next!=null){
            p1=p1.next;
            p2=p2.next.next;
            if(p1==p2){
                flag=true;
                break;
            }
        }
        if(flag){

            while(p1.next!=null){
                if(p1==head){
                    return p1;
                }
                p1=p1.next;
                head=head.next;
            }
        }
        return null;
    }
}