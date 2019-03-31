package leetcode.problem7_reverse_integer;


/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
public class Solution {
    public static int reverse(int x) {
        long y=(long)x;
        if(y>0){
            return reverseInteger(y);
        }
        else {
            return -reverseInteger(-y);
        }
    }
    public static int reverseInteger(long x){
        String sb=Long.toString(x);
        StringBuilder result=new StringBuilder();
        for(int y=sb.length()-1;y>=0;y--){
            result.append(sb.charAt(y));
        }
        long a= Long.parseLong(result.toString());
        if(a>Integer.MAX_VALUE){
            return 0;
        }
        return (int) a;
    }

    public static void main(String[] args) {

//        System.out.println(reverse(-2147483648));
    }
}
