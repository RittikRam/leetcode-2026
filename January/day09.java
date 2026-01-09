/*865. Smallest Subtree with all the Deepest Nodes
Given the root of a binary tree, the depth of each node is the shortest distance to the root.
Return the smallest subtree such that it contains all the deepest nodes in the original tree.
A node is called the deepest if it has the largest depth possible among any node in the entire tree.
The subtree of a node is a tree consisting of that node, plus the set of all descendants of that node.

 
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
public class day09 {

    class Node{
        TreeNode node;
        int depth;
        Node(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    public Node dfs(TreeNode root){
        if(root == null){
            return new Node(null,0);
        }
        Node left = dfs(root.left);
        Node right = dfs(root.right);
        if(left.depth == right.depth){
            return new Node(root,left.depth+1);
        }else if(left.depth > right.depth){
            return new Node(left.node,left.depth+1);
        }else
            return new Node(right.node,right.depth+1);
    }
}