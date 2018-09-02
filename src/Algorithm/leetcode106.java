package Algorithm;

public class leetcode106 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    //根据后序和中序构建树
    public TreeNode buildTree (int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private TreeNode helper (int[] inorder, int inS, int inE, int[] postorder, int postS, int postE) {
        if (inS > inE || postS > postE) {
            return null;
        }
        TreeNode res = new TreeNode(postorder[postE]);
        int pos = inS;
        for (int i = inS; i <= inE; i++) {
            if (inorder[i] == postorder[postE]) {
                pos = i;
                break;
            }
        }
        res.left = helper(inorder, inS, pos - 1, postorder, postS, postS + pos - inS-1);
        res.right = helper(inorder, pos + 1, inE, postorder, postS + pos - inS , postE - 1);
        return res;
    }
}
