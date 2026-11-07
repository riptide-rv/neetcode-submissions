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
    public record Data(int depth, boolean balanced) {}

    public boolean isBalanced(TreeNode root) {
        return findDepthAndBalance(root).balanced;
    }

    public Data findDepthAndBalance(TreeNode node) {
        if (node == null) {
            return new Data(0, true);
        }

        Data left = findDepthAndBalance(node.left);
        Data right = findDepthAndBalance(node.right);

        Data curr = new Data(Math.max(left.depth, right.depth) + 1, false);

        if (left.balanced && right.balanced && -1 <= left.depth - right.depth
            && left.depth - right.depth <= 1) {
            curr = new Data(curr.depth, true);
        }

        return curr;
    }
}
