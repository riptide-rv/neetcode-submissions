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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        this.levelOrder(root, result, 0);
        return result;
    }

    public void levelOrder(TreeNode root, List<List<Integer>> list,  int level ) {
        if (root == null) {
            return;
        }

        if (level >= list.size()) {
            list.add(level, new ArrayList<>());
        }

        list.get(level).add(root.val);

        levelOrder(root.left, list, level + 1);
        levelOrder(root.right, list, level + 1);

    }
}
