package Algorithm;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 层次遍历，输出每一行末尾节点
 */
public class leetcode199 {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    public static List<Integer> rightSideView (TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<>();
        int size = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            res.add((((LinkedList<TreeNode>) queue).peekLast().val));
            for (int i = 0; i < size; i++) {
                TreeNode r = queue.poll();
                if (r.left != null)
                    queue.offer(r.left);
                if (r.right != null)
                    queue.offer(r.right);
            }
            size = queue.size();
        }
        return res;
    }

    public static void main(String []args){
        TreeNode t = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t.left=t2;
        t.right=t3;
        t2.right = new TreeNode(5);
        t3.right = new TreeNode(4);
        leetcode199.rightSideView(t);
    }
}
