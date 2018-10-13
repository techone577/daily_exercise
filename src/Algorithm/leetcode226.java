package Algorithm;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * Invert a binary tree.
 */
public class leetcode226 {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.right);
        invertTree(root.left);
        return root;
    }

    public TreeNode invertTreeNonR(TreeNode root) {
        if (root == null)
            return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            TreeNode left = temp.left;
            temp.left = temp.right;
            temp.right = left;
            if (temp.left != null)
                queue.offer(temp.left);
            if (temp.right != null)
                queue.offer(temp.right);
        }
        return root;
    }
}
