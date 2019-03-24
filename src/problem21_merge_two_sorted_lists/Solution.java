package problem21_merge_two_sorted_lists;

import problem2_add_two.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode current=head;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                ListNode temp=l1;
                l1=l1.next;
                temp.next=null;
                current.next=temp;
                current=current.next;
            }
            else{
                ListNode temp=l2;
                l2=l2.next;
                temp.next=null;
                current.next=temp;
                current=current.next;
            }
        }
        while(l1!=null){
            ListNode temp=l1;
            l1=l1.next;
            temp.next=null;
            current.next=temp;
            current=current.next;
        }
        while(l2!=null){
            ListNode temp=l2;
            l2=l2.next;
            temp.next=null;
            current.next=temp;
            current=current.next;
        }
        return head.next;
    }
}