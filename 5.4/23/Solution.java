import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((l1, l2) -> l1.val - l2.val);
        for (ListNode list: lists) {
            if (list != null)   heap.offer(list);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode curt = heap.poll();
            if (curt.next != null) {
                heap.add(curt.next);
            }
            tail.next = curt;
            tail = curt;
        }
        return dummy.next;
    }
}