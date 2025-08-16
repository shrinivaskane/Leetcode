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
class LC199RightSideBinaryTree {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
          /* using iterative BFS
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            for(int i = queue.size(); i> 0; i--) {
                TreeNode node = queue.poll();
                    if(i == 1) res.add(node.val);
                    if(node.left != null) queue.offer(node.left);
                    if(node.right != null) queue.offer(node.right);
            }
        }
        return res;
        */
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int depth) {
        if(node == null) return;

        if(depth == res.size()) {
            res.add(node.val);
        }

        dfs(node.right, depth + 1);
        dfs(node.left, depth + 1);
    }
}
