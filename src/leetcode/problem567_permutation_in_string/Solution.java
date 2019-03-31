package leetcode.problem567_permutation_in_string;


import java.util.*;

/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
class Solution {
    public static boolean checkInclusion(String s1, String s2) {
        if(s1==null||s2==null||s2.length()<s1.length()){
            return false;
        }
        int len=s1.length();
        for(int x=0;x<s2.length()-len+1;x++){
            String subString=s2.substring(x,x+len);
            if(check(s1,subString)){
                return true;
            }
        }
        return false;
    }
    public static boolean check(String s1,String s2){
        Map<Character,Integer> map1=new HashMap();
        Map<Character,Integer> map2=new HashMap();
        for(int x=0;x<s1.length();x++){
            if(map1.containsKey(s1.charAt(x))){
                map1.put(s1.charAt(x),(map1.get(s1.charAt(x))+1));
            }
            else{
                map1.put(s1.charAt(x),1);
            }
            if(map2.containsKey(s2.charAt(x))){
                map2.put(s2.charAt(x),(map2.get(s2.charAt(x))+1));
            }
            else{
                map2.put(s2.charAt(x),1);
            }
        }
        for(char x:map1.keySet()){
            if(map2.get(x)!=map1.get(x)){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("adcc","oooadfccppp"));
    }
}