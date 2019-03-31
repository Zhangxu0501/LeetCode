package leetcode.problem9_is_palindrome;

import java.util.*;
/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
public class Solution {
    public static boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        Stack<Character> stack=new Stack();
        String str=Integer.toString(x);
        for(int y=0;y<str.length();y++){
            stack.push(str.charAt(y));
        }
        for(int y=0;y<str.length();y++){
            Character c=stack.pop();
            if(!c.equals(str.charAt(y))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println(isPalindrome(11211));
    }
}
