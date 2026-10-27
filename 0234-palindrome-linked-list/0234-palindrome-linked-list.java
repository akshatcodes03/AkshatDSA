class Solution {

    public ListNode FindMiddle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode ReverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode mid = FindMiddle(head);
        ListNode reversedHead = ReverseLinkedList(mid);

        ListNode curr = head;
        ListNode reverseCurr = reversedHead;

        while (reverseCurr != null) {
            if (curr.val != reverseCurr.val) {
                return false;
            }

            curr = curr.next;
            reverseCurr = reverseCurr.next;
        }

        return true;
    }
}
