package Algorithm;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 递归构建
 */

public class leetcode105 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    //根据前序和中序构件树
    public TreeNode buildTree (int[] preorder, int[] inorder) {
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper (int[] preorder, int preS, int preE, int[] inorder, int inS, int inE) {
        if (preS > preE || inS > inE)
            return null;
        TreeNode res = new TreeNode(preorder[preS]);
        int pos = inS;
        for (int i = inS; i <= inE; i++) {
            if (inorder[i] == preorder[preS]) {
                pos = i;
                break;
            }
        }
        //这个preE要算准确
        res.left = helper(preorder, preS + 1, preS + pos-inS, inorder, inS, pos - 1);
        res.right = helper(preorder, preS + pos-inS+1, preE, inorder, pos + 1, inE);
        return res;
    }

}
