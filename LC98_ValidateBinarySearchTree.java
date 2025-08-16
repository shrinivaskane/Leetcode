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
class LC98_ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        /* recursive dfs 
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        */

        /* Iterative BFS */
        if(root == null) return true;
        Queue<Object[]> queue = new LinkedList<>();
        queue.offer(new Object[]{root, Long.MIN_VALUE, Long.MAX_VALUE});

        while(!queue.isEmpty()) {
            Object[] object = queue.poll();
            TreeNode node = (TreeNode) object[0];
            long left = (long) object[1];
            long right = (long) object[2];

            if(node.val <= left || node.val >= right) return false;
            if(node.left!=null) {
            queue.offer(new Object[]{node.left, left, (long) node.val});
            }
            if(node.right != null) {
                queue.offer(new Object[]{node.right, (long) node.val, right});
            }
        }
        return true;
    }

    private boolean dfs(TreeNode node, long minVal, long maxVal) {
        if(node == null) return true;
        
        if(node.val <= minVal || node.val >= maxVal) return false;

        return dfs(node.left, minVal, node.val) && dfs(node.right, node.val, maxVal);
    }
}
