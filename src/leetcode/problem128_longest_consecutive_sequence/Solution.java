package leetcode.problem128_longest_consecutive_sequence;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
import java.util.*;
class Solution {

    public int longestConsecutive(int[] nums) {
        int max=0;
        HashMap<Integer,Integer> map=new HashMap();
        for(int x:nums){
            if(map.containsKey(x)){
                continue;
            }

            int up=map.getOrDefault(x+1,0);
            int down=map.getOrDefault(x-1,0);
            int len=up+down+1;
            map.put(x,len);
            map.put(up+x,len);
            map.put(x-down,len);
            if(len>max){
                max=len;
            }

        }
        return max;
    }
}