class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = dummy;
        
        for (int i = 0; i < left - 1; ++i) {
            temp = temp.next;
        }
        
        ListNode current = temp.next;
        
        for (int i = 0; i < right - left; ++i) {
            ListNode nextNode = current.next;
            current.next = nextNode.next;
            nextNode.next = temp.next;
            temp.next = nextNode;
        }
        
        return dummy.next;
    }
}