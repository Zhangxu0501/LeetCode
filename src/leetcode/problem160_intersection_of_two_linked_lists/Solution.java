package leetcode.problem160_intersection_of_two_linked_lists;

import leetcode.problem2_add_two.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode l1=headA;
        ListNode l2=headB;
        while(l1!=null&&l2!=null){
            l1=l1.next;
            l2=l2.next;
        }
        if(l1==null){
            while(l2!=null){
                l2=l2.next;
                headB=headB.next;
            }
        }
        else{
            while(l1!=null){
                l1=l1.next;
                headA=headA.next;
            }
        }
        while(headA!=null&&headB!=null){
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;
        }
        return null;
    }
}