class Solution {
    public int[] getAverages(int[] nums, int k) {

        int n = nums.length;
        int[] avgs = new int[n];

        
        for (int i = 0; i < n; i++) {
            avgs[i] = -1;
        }

        for (int i = k; i < n - k; i++) {

            long sum = 0;
  
            for (int j = i - k; j <= i + k; j++) {
                sum += nums[j];
            }
           
            avgs[i] = (int)(sum / (2 * k + 1));
        }

        return avgs;
    }
}