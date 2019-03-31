package leetcode.problem1_two_sum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
public class Solution {
        public static int[] twoSum(int[] nums, int target) {
            Map<Integer,Integer> map=new HashMap();
            for(int x=0;x<nums.length;x++){
                map.put(nums[x],x);
            }
            for(int x=0;x<nums.length;x++){
                Integer index=map.get(target-nums[x]);
                if(index!=null&&index!=x){
                    int [] result={x,index};
                    return result;
                }
            }
            return new int[0];
        }

    public static void main(String[] args) {
        int [] nums={2,7,11,15};
        int [] result=twoSum(nums,9);
        for(int x=0;x<result.length;x++){
            System.out.println(result[x]);
        }
    }
}
