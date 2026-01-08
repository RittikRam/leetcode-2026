/*
1339. Maximum Product of Splitted Binary Tree
Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.

Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.

Note that you need to maximize the answer before taking the mod and not after taking it.
*/

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
public class day07 {
    long maxProduct = 0;
    long totalSum = 0;
    public int maxProduct(TreeNode root) {
        int MOD = 1_000_000_007;
         totalSum = sum(root);
        solve(root);
        int result = (int)(maxProduct%MOD);
        return result;
    }
    public long sum(TreeNode root){
        if(root == null){
            return 0l;
        }
        return sum(root.left)+sum(root.right)+root.val;
    }
    public long solve(TreeNode root){
        if(root == null){
            return 0l;
        }
        long left = solve(root.left);
        long right = solve(root.right);
        long val = left+right+root.val;
        maxProduct = Math.max(maxProduct,(val*(Math.abs(totalSum-val))));
        return val;
    }
}