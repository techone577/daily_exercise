package Algorithm;

import java.util.ArrayList;
import java.util.List;
//给出节点寻找在树中的路径
public class findPathInTree {
    private static boolean flag = false;

    public static List<Integer> find (int des, TreeNode root) {
        if (root == null)
            return null;
        List<Integer> res = new ArrayList<>();
        helper(res,des,root );
        return res;
    }

    private static void helper (List<Integer> res, int des, TreeNode root) {
        if (root == null) return;
        if (root.val == des) {
            res.add(root.val);
            flag = true;
            return;
        }
        helper(res, des, root.left);
        if (flag) {
            res.add(root.val);
            return;
        }
        helper(res, des, root.right);
        if (flag) {
            res.add(root.val);
        }
    }

    public static void main (String []args) {
        TreeNode t = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        t.left=t2;
        t.right=t3;
        t2.right = new TreeNode(5);
        t3.right = new TreeNode(4);
        findPathInTree.find(5,t);
    }


}
