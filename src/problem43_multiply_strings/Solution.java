package problem43_multiply_strings;

/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
class Solution {
    public static String multiply(String num1, String num2) {
        int len1=num1.length()-1;
        int len2=num2.length()-1;
        int [] result=new int[len1+len2+2];
        if(len1<0||len2<0){
            return "";
        }
        for(int i=len1;i>=0;i--){
            for(int j=len2;j>=0;j--){
                int temp=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                temp+=result[i+j+1];
                result[i+j+1]=temp%10;
                result[i+j]+=temp/10;
            }
        }
        int x=0;
        while (x<result.length-1&&result[x]==0){
            x++;
        }
        StringBuilder sb=new StringBuilder();
        for(;x<result.length;x++){
            sb.append(result[x]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("9133","0"));
    }
}