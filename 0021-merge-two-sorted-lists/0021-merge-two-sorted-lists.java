class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        // dummy node banate hain
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        
        // jab tak dono list me elements hain
        while (list1 != null && list2 != null) {
            
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            
            temp = temp.next;
        }
        
        // agar koi list bachi ho
        if (list1 != null) {
            temp.next = list1;
        } else {
            temp.next = list2;
        }
        
        return dummy.next;
    }
}