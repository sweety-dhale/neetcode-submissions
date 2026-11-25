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
    private int maxDia;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        this.maxDia = 0;
        int dia = getMaxDia(root.left, 0) + getMaxDia(root.right, 0);
        return Math.max(this.maxDia, dia);
    }

    private int getMaxDia(TreeNode node, int d) {
        if(node == null)
            return d;
        int ld = getMaxDia(node.left, d);
        int rd = getMaxDia(node.right, d);

        this.maxDia = Math.max(this.maxDia, ld + rd);
        return Math.max(ld, rd) + 1;
    }
}
