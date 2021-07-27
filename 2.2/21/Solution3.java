class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        helper(l1, l2, dummy);
        return dummy.next;
    }

    private void helper(ListNode l1, ListNode l2, ListNode tail) {
        if (l1 == null || l2 == null)   {
            tail.next = l1 != null ? l1 : l2;
            return;
        }

        if (l1.val < l2.val) {
            tail.next = l1;
            helper(l1.next, l2, tail.next);
        } else {
            tail.next = l2;
            helper(l1, l2.next, tail.next);
        }
    }
}