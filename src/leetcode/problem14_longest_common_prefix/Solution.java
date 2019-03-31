package leetcode.problem14_longest_common_prefix;


/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null||strs.length==0){
            return "";
        }
        if(strs.length<=1){
            return strs[strs.length-1];
        }
        StringBuilder sb =new StringBuilder();
        String test=strs[0];
        for(int x=0;x<test.length();x++){
            boolean flag=false;
            for(int y=0;y<strs.length;y++){
                String current=strs[y];
                if(current.length()>x&&test.charAt(x)==current.charAt(x)){
                    flag=true;
                }
                else{
                    flag=false;
                    break;
                }
            }
            if(flag){
                sb.append(test.charAt(x));
            }
            else{
                break;
            }
        }
        return sb.toString();
    }
}