package leetcode.problem243_friend_circles;

/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
class Solution {
    public int findCircleNum(int[][] M) {
        int result=0;
        int [] pre=new int[M.length];

        //初始化
        for(int x=0;x<pre.length;x++){
            pre[x]=x;
        }
        for(int x=0;x<M.length;x++){
            for(int y=0;y<=x;y++){
                if(M[x][y]==1){
                    int xParent=getParent(pre,x);
                    int yParent=getParent(pre,y);
                    pre[xParent]=yParent;
                }
            }
        }
        for(int x=0;x<pre.length;x++){
            if(pre[x]==x){
                result++;
            }
        }
        return result;
    }
    public int getParent(int [] pre,int node){
        while (node!=pre[node]){
            node=pre[node];
        }
        return node;
    }
}