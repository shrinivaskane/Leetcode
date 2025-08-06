/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class LC235_LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /* recursion 
        if(root == null || p == null || q == null) return null;

        if(Math.max(p.val, q.val) < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if(Math.min(p.val, q.val) > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
        */

        /* Iteration */
        if(root == null || p == null || q == null) return null;

        TreeNode curr = root;
        while(curr!= null) {
        if(Math.max(p.val, q.val) < curr.val) {
            curr = curr.left;
        } else if(Math.min(p.val, q.val) > curr.val) {
            curr = curr.right;
        } else {
            return curr;
        }
        }
        return null;
    }
}
