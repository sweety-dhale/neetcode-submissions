/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private Boolean isBalanced = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root);
        return isBalanced;
    }

    private int dfs(TreeNode node) {
        if(node == null || !isBalanced) {
            return 0;
        }
        
        int lh = dfs(node.left);
        int rh = dfs(node.right);

        if((Math.max(lh, rh) - Math.min(lh, rh)) > 1) {
            isBalanced = false;
        }
        return Math.max(lh, rh) + 1;
    }
}
