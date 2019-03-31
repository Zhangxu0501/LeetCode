package leetcode.problem206_reverse_linked_list;

import leetcode.problem2_add_two.ListNode;

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
class Solution {
    public static ListNode reverseList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode newHead=new ListNode(0);
        ListNode cur=head;
        ListNode curN=head.next;
        newHead.next=cur;
        while(curN!=null){
            cur.next=curN.next;
            curN.next=newHead.next;
            newHead.next=curN;
            curN=cur.next;
        }
        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        System.out.println(reverseList(l1));
    }
}