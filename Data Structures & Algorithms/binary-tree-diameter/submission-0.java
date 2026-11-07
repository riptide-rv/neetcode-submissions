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
    public record Data(int depth, int diameter) {};

    public int diameterOfBinaryTree(TreeNode root) {
        return diameterAndDepthOfBinaryTree(root).diameter;
    }

    public Data diameterAndDepthOfBinaryTree(TreeNode node) {
        if (node == null) {
            return new Data(0, 0);
        }
        Data left = this.diameterAndDepthOfBinaryTree(node.left);
        Data right = this.diameterAndDepthOfBinaryTree(node.right);

        int diameterCurr = left.depth + right.depth;

        int diameter = Math.max(left.diameter, Math.max(right.diameter, diameterCurr));
        int depth = Math.max(left.depth, right.depth) + 1;

        return new Data(depth, diameter);
    }
}
