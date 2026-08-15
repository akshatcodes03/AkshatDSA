class Solution {
    public int search(int[] nums, int target) {
        int i = 0;
        for(int x : nums){
            if(target == x){
                return i;
            }
            i++;
        }
        return -1;
    }
}