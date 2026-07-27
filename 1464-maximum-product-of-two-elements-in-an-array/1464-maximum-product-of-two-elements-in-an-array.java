class Solution {
    public int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n1 = nums[nums.length-1];
        int n2 = nums[nums.length-2];
        int result = (n1-1)*(n2-1);
        return result;
    }
}