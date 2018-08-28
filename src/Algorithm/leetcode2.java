package Algorithm;

public class leetcode2 {
    public static ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0);
        ListNode temp = res;
        int flag = 0;
        int dight = 0;
        while (l1 != null && l2 != null) {
            dight = l1.val + l2.val;
            res.next = new ListNode((flag + dight) % 10);
            flag = (flag+dight) / 10;
            res = res.next;
            if (l1.next == null && l2.next == null)
                break;
            if (l1.next == null)
                l1.next = new ListNode(0);
            if (l2.next == null)
                l2.next = new ListNode(0);
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1.next == null && l2.next == null && flag != 0)
            res.next = new ListNode(flag);
        return temp.next;
    }

    public static void main (String[] args) {
        ListNode p1 = new ListNode(9);
        ListNode p2 = new ListNode(9);
        p1.next = p2;
        ListNode q1 = new ListNode(1);


        leetcode2.addTwoNumbers(q1, p1);

    }
}
