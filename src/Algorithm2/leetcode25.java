package Algorithm2;

import Algorithm.ListNode;

/**
 * 给出一个链表，每 k 个节点一组进行翻转，并返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么将最后剩余节点保持原有顺序。
 * 示例 :
 * 给定这个链表：1->2->3->4->5
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 * 说明 :
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class leetcode25 {
    // 1 2 3 4 5// 2 1 3 5
    public ListNode reverseKGroup (ListNode head, int k) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            ++length;
            temp = temp.next;
        }
        int count = length / k;
        ListNode current = head, pre = head, post = head, preTail = null, currentTail = head;
        for (int i = 0; i < count; ++i) {
            for (int j = 0; j < k; ++j) {
                if (j == 0) {
                    post = current.next;
                    pre = current;
                    currentTail = current;
                    current = post;
                } else {
                    post = current.next;
                    current.next = pre;
                    pre = current;
                    current = post;
                }
            }
            if (preTail == null) {
                preTail = currentTail;
            } else {
                preTail.next = pre;
                preTail = currentTail;
            }
            if (i == 0)
                head = pre;
        }
        if (preTail != null)
            preTail.next = current;
        return head;
    }

    public static void main (String[] args) {
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        new leetcode25().reverseKGroup(null, 2);
    }
}
