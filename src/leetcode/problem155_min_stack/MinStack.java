package leetcode.problem155_min_stack;


/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
import java.util.*;
class MinStack {
    Stack<Integer> s1=new Stack();
    Stack<Integer> s2=new Stack();
    /** initialize your data structure here. */

    public MinStack() {

    }

    public void push(int x) {
        if(s1.isEmpty()){
            s1.push(x);
            s2.push(x);
        }
        else{
            s1.push(x);
            int temp=s2.peek();
            if(temp>x){
                s2.push(x);
            }
            else{
                s2.push(temp);
            }
        }
    }

    public void pop() {
        s1.pop();
        s2.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int getMin() {
        return s2.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */