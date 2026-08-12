class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        int start = 0;
        int end = 0;
        int maxlen = 0;
        int n = nums.length;

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        while (end < n) {

            
            freqMap.put(nums[end], freqMap.getOrDefault(nums[end], 0) + 1);

            
            while (freqMap.get(nums[end]) > k) {

                freqMap.put(nums[start], freqMap.get(nums[start]) - 1);

                start++;
            }

            
            maxlen = Math.max(maxlen, end - start + 1);

            end++;
        }

        return maxlen;
    }
}