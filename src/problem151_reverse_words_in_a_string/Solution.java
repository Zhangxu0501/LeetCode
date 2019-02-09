package problem151_reverse_words_in_a_string;



/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */

public class Solution {
    public static String reverseWords(String s) {
        if(s==null||s==""){
            return "";
        }
        String [] words=s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int x=words.length-1;x>=0;x--){
            if(words[x].equals("")){
                continue;
            }
            sb.append(words[x]);
            sb.append(" ");
        }
        if(sb.lastIndexOf(" ")!=-1){
            sb.deleteCharAt(sb.lastIndexOf(" "));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String a=reverseWords("1");
        System.out.println(a);
    }
}