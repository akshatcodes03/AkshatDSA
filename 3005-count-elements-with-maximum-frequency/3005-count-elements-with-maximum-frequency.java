class Solution {
    public int maxFrequencyElements(int[] nums) {

        int[] freq = new int[101];

        int i = 0;

        
        while (i < nums.length) {
            freq[nums[i]]++;
            i++;
        }

        
        int max = 0;
        i = 0;

        while (i < 101) {
            max = Math.max(max, freq[i]);
            i++;
        }

        
        int ans = 0;
        i = 0;

        while (i < 101) {
            if (freq[i] == max) {
                ans += freq[i];
            }
            i++;
        }

        return ans;
    }
}