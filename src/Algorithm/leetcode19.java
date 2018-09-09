package Algorithm;

/**
 *
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 一趟扫描
 * 两个指针，一个先走n步，然后两个指针同时走，第一个指针到末尾，第二个指针的位置就是倒数第n个节点
 *
 */

public class leetcode19 {

    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode i = head, j = head;
        for (int k = 0; k < n; k++) {
            j = j.next;
        }
        ListNode temp = i;
        while (j != null) {
            j = j.next;
            temp = i;
            i = i.next;
        }
        if (temp == i) {
            head = head.next;
            return head;
        } else {
            temp.next = i.next;
            i.next = null;
        }
        return head;
    }
}
