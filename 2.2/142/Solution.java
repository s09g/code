public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = floyd(head);

        if (fast == null) {
            return null;
        }

        ListNode slow = head;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    private ListNode floyd(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return fast;
            }

        }
        return null;
    }
}