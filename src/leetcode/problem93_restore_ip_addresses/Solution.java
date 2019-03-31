package leetcode.problem93_restore_ip_addresses;


import java.util.*;
class Solution {
    public static List<String> restoreIpAddresses(String s) {
        List<String> result=new ArrayList();
        if(s.length()<4||s.length()>12){
            return result;
        }
        for(int x=0;x<3&&x<s.length();x++){
            String p1=s.substring(0,x+1);
            if(isVaild(p1)){
                for(int y=x+1;y<x+1+3&&y<s.length();y++){
                    String p2=s.substring(x+1,y+1);
                    if(isVaild(p2)){
                        for(int i=y+1;i<y+1+3&&i<s.length();i++){
                            String p3=s.substring(y+1,i+1);
                            if(isVaild(p3)){
                                for(int j=i+1;j<i+1+3&&j<s.length();j++){
                                    String p4=s.substring(i+1,j+1);
                                    if(isVaild(p4)&&(p1.length()+p2.length()+p3.length()+p4.length())==s.length()){
                                        result.add(p1+"."+p2+"."+p3+"."+p4);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    static boolean isVaild(String s){
        if(s.startsWith("0")&&s.length()>1){
            return false;
        }
        if(Integer.parseInt(s)>255){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(restoreIpAddresses("1111"));
    }
}