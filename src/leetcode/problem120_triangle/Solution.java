package leetcode.problem120_triangle;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
class Solution {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size()==0){
            return 0;
        }
        for(int i=1;i<triangle.size();i++){
            for(int j=0;j<triangle.get(i).size();j++){
                if(j==0){
                    triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j));
                }
                else if(j==triangle.get(i).size()-1){
                    triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j-1));
                }
                else{
                    triangle.get(i).set(j,triangle.get(i).get(j)+Math.min(triangle.get(i-1).get(j-1),triangle.get(i-1).get(j)));
                }
            }
        }
        int min=triangle.get(triangle.size()-1).get(0);
        for(int x=0;x<triangle.get(triangle.size()-1).size();x++){
            if(triangle.get(triangle.size()-1).get(x)<min){
                min=triangle.get(triangle.size()-1).get(x);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle= Arrays.asList(Arrays.asList(-1),Arrays.asList(-2,-3));
        minimumTotal(triangle);
    }
}