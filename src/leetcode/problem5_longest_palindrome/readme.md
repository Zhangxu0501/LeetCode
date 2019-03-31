给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

###
动态规划，将已经是回文的子串存储，而不是每次遍历检测。

状态转移方程及边界条件


![avatar](https://github.com/Zhangxu0501/LeetCode/blob/master/src/image/5C581660-A6CB-4429-B78E-DDC9CFA3B021.png?raw=true)