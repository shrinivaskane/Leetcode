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
class LC100_SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /* Iterative BFS  
        if(p == null && q == null) return true;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while(!queue1.isEmpty() && !queue2.isEmpty()) {
            for(int i = queue1.size(); i>0 ; i--) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if(node1 == null && node2 == null) continue;
            if (node1 == null || node2 == null || node1.val != node2.val) {
                return false;
            }
            queue1.offer(node1.left);
            queue1.offer(node1.right);
            queue2.offer(node2.left);
            queue2.offer(node2.right);
            }
        }
        return true;
        */

         /* Iterative DFS   
         if(p == null && q == null) return true;

        Stack<TreeNode[]> stack = new Stack();
        stack.push(new TreeNode[]{p,q});

        while(!stack.isEmpty()) {
            TreeNode[] node = stack.pop();
            if(node[0] == null && node[1] == null) continue;
            if (node[0] == null || node[1] == null || node[0].val != node[1].val) {
                return false;
            }
            stack.push(new TreeNode[]{node[0].left, node[1].left});
            stack.push(new TreeNode[]{node[0].right, node[1].right});
        }
        return true;
        */

        /* Recursive DFS */
        if(p == null && q == null) return true;

        if (p == null || q == null || p.val != q.val) {
                return false;
            }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }            
}
