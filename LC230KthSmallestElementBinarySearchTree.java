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
class LC230KthSmallestElementBinarySearchTree {
    public int kthSmallest(TreeNode root, int k) {
        /* Recursive DFS  
       List<Integer> list = new ArrayList<>();
       dfs(root, list);
       return list.get(k-1); 
       */

       /* Iterative DFS */
       Stack<TreeNode> stack = new Stack<>(); 
       TreeNode curr = root; 
       while (!stack.isEmpty() || curr != null) 
       { 
        while (curr != null) 
        { stack.push(curr); 
        curr = curr.left; 
        } 
        curr = stack.pop(); 
        k--; 
        if (k == 0) { return curr.val; } 
        curr = curr.right; 
        } 
        return -1;
    }

    private void dfs(TreeNode node, List<Integer> list) {
        if(node == null) return;

        dfs(node.left, list);
        list.add(node.val);
        dfs(node.right, list);
    }
}
