package leetcode.problem56_merge_intervals;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */



class Solution {
    public static List<Interval> merge(List<Interval> intervals) {
        intervals.sort(Comparator.comparing(interval -> interval.start));
        int i=0;
        while (i<intervals.size()-1){
            Interval pre=intervals.get(i);
            Interval now=intervals.get(i+1);
            if(canMerge(pre,now)){
                Interval newInterval=merge(pre,now);
                intervals.remove(i);
                intervals.remove(i);
                intervals.add(i,newInterval);
            }
            else {
                i++;
            }
        }
        return intervals;
    }
    public static boolean canMerge(Interval pre,Interval now){
        return pre.start<=now.start&&pre.end>=now.start;
    }
    public static Interval merge(Interval pre,Interval now){
        return new Interval(Math.min(pre.start,now.start),Math.max(pre.end,now.end));
    }

    public static void main(String[] args) {
        List<Interval> intervals= new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(8,10));
        intervals.add(new Interval(15,18));
        System.out.println(merge(intervals));
    }
}