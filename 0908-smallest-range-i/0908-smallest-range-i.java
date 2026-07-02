class Solution {
    public int smallestRangeI(int[] nums, int k) {
        Arrays.sort(nums);
        int diff = 0;
        diff = Math.abs(nums[0]-nums[nums.length-1]);
        if(diff<=2*k){
            return 0;
        }
        return diff - 2*k;

    }
}