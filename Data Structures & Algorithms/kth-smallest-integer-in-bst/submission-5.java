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

    public int kthSmallest(TreeNode root, int k) {
      
        Deque<TreeNode> stack = new ArrayDeque<>();
        return dfs(root, k, stack);
    }

    public int dfs(TreeNode root, int k, Deque<TreeNode> stack) {
        if (root.left != null) {
            int left = dfs(root.left, k, stack);
            if (left > -1)
                return left;
        }

        stack.push(root);
        if (stack.size() == k)
            return stack.pop().val;

        if (root.right != null) {
            int right = dfs(root.right, k, stack);
            if (right > -1)
                return right;
        }

        return -1;
    }
}
