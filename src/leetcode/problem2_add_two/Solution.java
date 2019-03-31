package leetcode.problem2_add_two;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null&&l2==null){
            return null;
        }
        Stack stack1=new Stack();
        Stack stack2=new Stack();
        while (l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        while (!stack1.isEmpty()){
            sb1.append(stack1.pop());
        }
        while (!stack2.isEmpty()){
            sb2.append(stack2.pop());
        }
        BigDecimal value1=new BigDecimal(sb1.toString());
        BigDecimal value2=new BigDecimal(sb2.toString());
        StringBuilder resultSb=new StringBuilder();
        BigDecimal result=value1.add(value2);
        resultSb.append(result.toString());
        ListNode head=null;
        ListNode now=head;
        for(char c:resultSb.reverse().toString().toCharArray()){
            ListNode  current=new ListNode(Integer.parseInt(new StringBuilder().append(c).toString()));
            if(head==null){
                head=current;
                now=current;
            }
            else {
                now.next=current;
                now=now.next;
            }
        }
        return head;

    }

    public static void main(String[] args) {

    }
}
