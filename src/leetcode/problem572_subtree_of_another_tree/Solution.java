package leetcode.problem572_subtree_of_another_tree;


import leetcode.problem236_LCA.TreeNode;

/**
 * @author zhangxu create on 2019/1/15
 * version 1.0
 */
public class Solution {
    public boolean isSubtree(TreeNode a, TreeNode b) {
        if(a==null||b==null){
            return false;
        }
        if(a.val==b.val&&isCommon(a,b)){
            return true;
        }
        return isSubtree(a.left,b)||isSubtree(a.right,b);
    }
    public boolean isCommon(TreeNode a,TreeNode b){
        if(a==null&&b==null){
            return true;
        }
        if(a==null||b==null){
            return false;
        }
        if(a.val==b.val){
            return isCommon(a.left,b.left)&&isCommon(a.right,b.right);
        }
        else {
            return false;
        }
    }
}
