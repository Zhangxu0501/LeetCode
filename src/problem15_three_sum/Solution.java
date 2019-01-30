package problem15_three_sum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */

class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums==null||nums.length<3){
            return new ArrayList();
        }
        List<List<Integer>> result=new ArrayList();
        Arrays.sort(nums);
        int pre=1;
        for(int x=0;x<nums.length-2;x++){
            int target=-nums[x];
            int i=x+1;
            int j=nums.length-1;
            if(pre==nums[x]){
                continue;
            }
            if(nums[x]>0){
                break;
            }
            while(i<j){
                if(target==(nums[i]+nums[j])){
                    List list=Arrays.asList(nums[x],nums[i],nums[j]);
                    result.add(list);
                    pre=nums[x];
                    while (i < j && nums[i] == nums[i + 1]) ++i;
                    while (i < j && nums[j] == nums[j - 1]) --j;
                    ++i; --j;

                }
                else if(target>(nums[i]+nums[j])){
                    i++;
                }
                else{
                    j--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int [] a ={-1,0,1,2,-1,-4};
        System.out.println(threeSum(a));
    }
}