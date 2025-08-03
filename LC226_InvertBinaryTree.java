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
class LC226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        /* BFS Approach 
        if(root == null) {
            return root;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            TreeNode tmp = temp.right;
            temp.right = temp.left;
            temp.left = tmp;

            if(temp.left!=null) queue.offer(temp.left);
            if(temp.right != null) queue.offer(temp.right);
        }
        return root;
        */
        /* DFS Recursive */
        if(root == null) {
            return root;
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;

        if(root.left != null) invertTree(root.left);
        if(root.right != null) invertTree(root.right);
        return root;
    }
}
