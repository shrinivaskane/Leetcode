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
class LC144_CountGoodNodesBinaryTree {
    public int goodNodes(TreeNode root) {
        /* Recursive solution 
        return dfs(root, root.val);
        */

        /* Iterative solution */
        int res = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, root.val));
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int maxVal = pair.getValue();
            if(node.val >= maxVal) res++;
            if(node.left != null) {
                queue.offer(new Pair<>(node.left, Math.max(maxVal, node.val)));
            }
            if(node.right != null) {
                queue.offer(new Pair<>(node.right, Math.max(maxVal, node.val)));
            }
        }
        return res;
    }

    private int dfs(TreeNode node, int maxVal) {
        if(node == null) return 0;
        int res = node.val >= maxVal? 1: 0;
        maxVal = Math.max(node.val, maxVal);
        res = res + dfs(node.left, maxVal);
        res = res + dfs(node.right, maxVal);
        return res;
    }
}
