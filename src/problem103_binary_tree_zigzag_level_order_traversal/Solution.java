package problem103_binary_tree_zigzag_level_order_traversal;

import problem236_LCA.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList();
        dfs(root,res,0);
        return res;
    }
    public void dfs(TreeNode root,List<List<Integer>> res,int level){
        if(root==null){
            return;
        }
        if(res.size()==level){
            res.add(new ArrayList());
        }
        if((level&1)==1){
            res.get(level).add(0,root.val);
        }
        else{
            res.get(level).add(root.val);
        }
        dfs(root.left,res,level+1);
        dfs(root.right,res,level+1);
    }
}