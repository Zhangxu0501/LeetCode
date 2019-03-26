package problem33_search_in_rotated_sorted_array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
class Solution {
    public int search(int[] nums, int target) {
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[mid]<nums[end]){
                if(nums[mid]<target&&nums[end]>=target){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
            }
            else{
                if(target<nums[mid]&&target>=nums[start]){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
        }
        return -1;
    }
}
