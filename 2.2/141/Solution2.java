public class Solution {
    public boolean hasCycle(ListNode head) {
        return floyd(head) != null;
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