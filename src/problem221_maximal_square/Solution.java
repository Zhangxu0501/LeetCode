package problem221_maximal_square;

/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
class Solution {
    public int maximalSquare(char[][] matrix) {

        if(matrix.length==0){
            return 0;
        }
        int [] [] dp=new int[matrix.length][matrix[0].length];
        int max=0;
        for(int x=0;x<matrix.length;x++){
            dp[x][0]=matrix[x][0]=='1'?1:0;
            max=Math.max(max, dp[x][0]);
        }
        for(int x=0;x<matrix[0].length;x++){
            dp[0][x]=matrix[0][x]=='1'?1:0;
            max=Math.max(max, dp[0][x]);
        }
        for(int x=1;x<matrix.length;x++){
            for(int y=1;y<matrix[0].length;y++){
                if(matrix[x][y]=='1'){
                    dp[x][y]=1+Math.min(dp[x-1][y-1],Math.min(dp[x][y-1],dp[x-1][y]));
                    max=Math.max(max, dp[x][y]);
                }
                else{
                    dp[x][y]=0;
                }

            }
        }
        return max*max;
    }
}