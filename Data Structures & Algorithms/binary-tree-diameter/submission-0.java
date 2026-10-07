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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        res[0] = 0;
        dfs(root, res);
        return res[0];
    }

    public int dfs(TreeNode curr, int[] res) {
        // returns height
        if (curr == null) {
            return 0;
        }

        else {
            int left = dfs(curr.left, res);
            int right = dfs(curr.right, res);
            res[0] = Math.max(res[0], left + right);

            return 1 + Math.max(left, right);
        }
    }
}
