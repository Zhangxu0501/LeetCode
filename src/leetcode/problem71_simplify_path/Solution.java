package leetcode.problem71_simplify_path;

import java.util.*;
class Solution {
    public static String simplifyPath(String path) {
        String [] dirs=path.split("/");
        Stack s=new Stack();
        for(int x=0;x<dirs.length;x++){
            if(dirs[x].equals(".")||dirs[x].equals("")){
                continue;
            }
            else if(dirs[x].equals("..")){
                if(!s.isEmpty()){
                    s.pop();
                }
            }
            else{
                s.push(dirs[x]);
            }
        }
        StringBuilder sb=new StringBuilder();
        if(s.isEmpty()){
            return "/";
        }
        Object [] objects= s.toArray();
        for(int x=0;x<objects.length;x++){
            sb.append("/");
            sb.append(objects[x]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        simplifyPath("/home//foo/");
    }
}