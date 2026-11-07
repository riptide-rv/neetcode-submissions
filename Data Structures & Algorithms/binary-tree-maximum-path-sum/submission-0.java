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
    long max = Long.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        /*
        at each node check if left path max > 0, right path max > 0, self > 0 max = sum of non zero.
        return but the sum return for that node should include self always.
        */
        dfs(root);
        return (int) this.max;
    }

    public int dfs(TreeNode root) {
        if(root == null) return 0;

        int left = Math.max(dfs(root.left), 0);
        int right = Math.max(dfs(root.right), 0);
        
        int path = root.val + left + right;
        this.max = Math.max(path, this.max);

        return root.val + Math.max(left, right);
    }
}
