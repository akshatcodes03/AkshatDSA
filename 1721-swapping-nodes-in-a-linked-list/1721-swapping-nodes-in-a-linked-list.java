class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode left = head;
        ListNode right = head;
        int count = 1;
        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            count++;
            if(count==k){
                left = temp;
            }
        }
        int target = count-k;
        temp = head;
        count = 1;
        while(temp!=null){
            if(count == target){
                right = temp;
                break;
            }
            temp = temp.next;
            count++;
        }
        int tem = left.val;
        left.val = right.val;
        right.val = tem;
        return head;
    }
}