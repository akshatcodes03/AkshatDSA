class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] Left_se_max = new int[n];

        Left_se_max[0]=nums[0];

        for(int i = 1 ; i < n ; i++){
            Left_se_max[i]=Math.max(Left_se_max[i-1],nums[i]);
        }
        int ans = -1;
        int Right_se_Min = Integer.MAX_VALUE;

        for(int i = n-1 ; i>=0 ; i--){
            Right_se_Min = Math.min(Right_se_Min, nums[i]);

            if(Left_se_max[i]-Right_se_Min <= k){
                ans = i;
            }
        }
        return ans;
    }
}