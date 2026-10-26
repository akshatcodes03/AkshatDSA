class Solution {
    public ListNode reverseList(ListNode head) {
        // ListNode prev = null;
        
        // while (head != null) {
        //     ListNode next = head.next;
        //     head.next = prev;
        //     prev = head;
        //     head = next;
        // }
        
        // return prev;

        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        int[] array = new int[count];
        int p = count - 1;

       
        temp = head;

        while (temp != null) {
            array[p] = temp.val;
            p--;
            temp = temp.next;
        }

       
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        for (int i = 0; i < count; i++) {
            curr.next = new ListNode(array[i]);
            curr = curr.next;
        }

        return dummy.next;
    }
}