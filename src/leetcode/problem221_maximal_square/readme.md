在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。

示例:

输入: 

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

输出: 4
在真实的面试中遇到过这道题？



dp
递推公式


dp[i][j]表示以第i行第j列为右下角所能构成的最大正方形边长, 则递推式为: 
dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);