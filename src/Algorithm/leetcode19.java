package Algorithm;

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
