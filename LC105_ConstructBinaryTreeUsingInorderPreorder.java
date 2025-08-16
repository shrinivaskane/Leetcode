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
class LC105_ConstructBinaryTreeUsingInorderPreorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;

        TreeNode node = new TreeNode(preorder[0]);
        int mid = -1;
        for(int i = 0; i< inorder.length; i++) {
            if(inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }
        int[] leftpreorder = Arrays.copyOfRange(preorder, 1, mid+1);
        int[] leftinorder = Arrays.copyOfRange(inorder, 0, mid);
        node.left = buildTree(leftpreorder, leftinorder);
        int[] rightpreorder = Arrays.copyOfRange(preorder, mid+1, preorder.length);
        int[] rightinorder = Arrays.copyOfRange(inorder, mid + 1, inorder.length);
        node.right = buildTree(rightpreorder, rightinorder);
        return node;
    }
}
