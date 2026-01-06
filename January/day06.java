/*
1161. Maximum Level Sum of a Binary Tree
Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.

Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
*/
import java.util.ArrayDeque;
import java.util.Deque;


// Definition for a binary tree node.
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class day06 {
    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level =1;
        int answer=1;
        int max=Integer.MIN_VALUE;
        while(!queue.isEmpty()){
            int n = queue.size();
            int levelSum=0;
            for(int i=0; i<n; i++){
                TreeNode node = queue.poll();
                levelSum +=node.val;
                if(node.left != null)queue.offer(node.left);
                if(node.right != null)queue.offer(node.right);
            }
            if(levelSum > max){
                 max = levelSum;
                answer=level;
            }
            level++;
        }
        return answer;
    }
}