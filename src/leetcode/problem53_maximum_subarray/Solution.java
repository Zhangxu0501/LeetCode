package leetcode.problem53_maximum_subarray;


/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        int max=Integer.MIN_VALUE;

        int now=0;
        int i=0;
        while(i<nums.length){
            now=Math.max(now+nums[i],nums[i]);
            if(now>max){
                max=now;
            }
            i++;
        }
        return max;
    }
}