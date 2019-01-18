package problem3_longest_substring;


import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null){
            return 0;
        }
        int result=0;
        int i=0,j=0;
        int n=s.length();
        Set set=new HashSet();
        while (i<n&&j<n){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                result=Math.max(result,j-i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
