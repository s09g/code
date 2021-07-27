/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode middle = findMiddle(head);
        ListNode right = middle.next;
        middle.next = null;

        right = reverse(right);

        head = merge(head, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (right != null) {
            tail.next = left;
            left = left.next;
            tail = tail.next;

            tail.next = right;
            right = right.next;
            tail = tail.next;
        }
        tail.next = left;

        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode curt = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = curt;
            curt = head;
            head = next;
        }
        return curt;
    }

    private ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}