package problem93_restore_ip_addresses;


/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */

class Solution {
    public static int findLengthOfLCIS(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        int i=0,j=0;
        int max=1;
        while(j<nums.length-1){
            if(nums[j]<nums[j+1]){
                j++;
                max=Math.max(max,max=j-i+1);
            }
            else{
                i=j+1;
                j=i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int [] a={1,3,5,4,7};
        System.out.println(findLengthOfLCIS(a));
    }
}