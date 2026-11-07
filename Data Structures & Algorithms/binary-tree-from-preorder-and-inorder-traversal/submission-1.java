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
    int pre_ind = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inmap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }

        return this.dfs(preorder, inmap, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, Map<Integer, Integer> inmap, int l, int r) {
        if (l > r) return null;
        int root_val = preorder[this.pre_ind++];
        TreeNode node = new TreeNode(root_val);
        int mid = inmap.get(root_val);
        node.left = dfs(preorder, inmap, l, mid - 1);
        node.right = dfs(preorder, inmap, mid + 1, r);
        return node;
    }
}
