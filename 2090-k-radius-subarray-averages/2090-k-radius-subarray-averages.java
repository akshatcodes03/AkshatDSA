class Solution {
    public int[] getAverages(int[] nums, int k) {

        int n = nums.length;
        int w = 2 * k + 1;

        int[] result = new int[n];

        java.util.Arrays.fill(result, -1);

        if (w > n) {
            return result;
        }

        long sum = 0;

        int f = 0;
        int s = 0;

        while (f < w) {
            sum += nums[f];
            f++;
        }

        
        int i = k;
        result[i] = (int) (sum / w);

        
        while (f < n) {
            sum = sum + nums[f];
            sum = sum - nums[s];
            
            result[++i] = (int) (sum / w);
            s++;
            f++;
        }

        return result;
    }
}