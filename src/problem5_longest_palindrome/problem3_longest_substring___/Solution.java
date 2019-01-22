package problem5_longest_palindrome.problem3_longest_substring___;


/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
public class Solution {
    public static String longestPalindrome(String s) {
        if(s==null||s.equals("")){
            return s;
        }
        int max=1;
        int start=0;
        boolean [] [] array=new boolean[s.length()][s.length()];
        for(int x=0;x<s.length();x++){
            for(int y=0;y<=x;y++){
                if((x-y)<2){
                    array[y][x]=(s.charAt(x)==s.charAt(y));
                }
                else{
                    array[y][x]=(s.charAt(x)==s.charAt(y))&&array[y+1][x-1];
                }
                if(array[y][x]&&(x-y+1)>=max){
                    start=y;
                    max=x-y+1;
                }
            }
        }
        return s.substring(start,start+max);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
}
