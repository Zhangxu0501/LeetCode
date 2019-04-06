package leetcode.problem42_trapping_rain_water;


/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */



class Solution {
    public static int trap(int[] height) {
        int heightValue=0;
        int heightIndex=0;
        if(height.length==0){
            return 0;
        }
        for(int x=0;x<height.length;x++){
            if(height[x]>heightValue){
                heightValue=height[x];
                heightIndex=x;
            }
        }
        int area=0;
        int temp=height[0];
        for (int i=0;i<heightIndex;i++){
            if(temp>=height[i]){
                area+=(temp-height[i]);
            }
            else{
                temp=height[i];
            }
        }
        temp=height[height.length-1];
        for (int i=height.length-1;i>heightIndex;i--){
            if(temp>=height[i]){
                area+=(temp-height[i]);
            }
            else{
                temp=height[i];
            }
        }
        return area;
    }

    public static void main(String[] args) {
        int [] test={0,1,0,2,1,0,1,3,2,1,2,1};
        trap(test);
    }
}