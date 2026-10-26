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
            temp = temp.next;
            p--;
        }

        
        temp = head;
        p = 0;

        while (temp != null) {
            temp.val = array[p];
            temp = temp.next;
            p++;
        }

        return head;
    }
}