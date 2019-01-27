package problem11_max_area.problem7_reverse_integer;


/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
import java.util.*;
class Solution {
    public int maxArea(int[] height) {
        if(height==null||height.length<2){
            return 0;
        }
        int maxArea=0;
        int start=0;int end = height.length-1;
        while(start<end){
            maxArea=Math.max(maxArea,(end-start)*Math.min(height[start],height[end]));
            if(height[start]>height[end]){
                end--;
            }
            else{
                start++;
            }
        }
        return maxArea;
    }
}
