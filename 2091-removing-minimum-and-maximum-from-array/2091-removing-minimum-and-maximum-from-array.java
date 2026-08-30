class Solution {
    public int minimumDeletions(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxIndex = 0;
        int minIndex = 0;
        int n = nums.length;

        for(int i = 0; i < nums.length; i++){
            if(max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }

            if(min > nums[i]) {
                min = nums[i];
                minIndex = i;
            }
        }

        int left = Math.min(maxIndex, minIndex);
        int right = Math.max(maxIndex, minIndex);

        int a = right + 1;
        int b = n - left;
        int c = left + 1 + n - right ;

        return Math.min(a, Math.min(b, c));
    }
}