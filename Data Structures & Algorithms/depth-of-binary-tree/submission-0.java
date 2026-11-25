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
    public int maxDepth(TreeNode root) {
        int depth = 0;
        return getMaxDepth(root, depth);
    }

    private int getMaxDepth(TreeNode node, int depth) {
        if(node == null) {
            return depth;
        }
        return Math.max(getMaxDepth(node.left, depth), getMaxDepth(node.right, depth)) + 1;
    }
}
