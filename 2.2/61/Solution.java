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
    public ListNode rotateRight(ListNode head, int k) {
        int size = getSize(head);
        if (size <= 1)  return head;

        k = k % size;
        if (k == 0) return head;

        ListNode cuttingPoint = findCuttingPoint(head, size - k - 1);
        ListNode right = cuttingPoint.next;
        cuttingPoint.next = null;

        ListNode rightTail = findTail(right);
        rightTail.next = head;
        return right;
    }

    private int getSize(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    private ListNode findCuttingPoint(ListNode head, int k) {
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        return head;
    }

    private ListNode findTail(ListNode head) {
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
}