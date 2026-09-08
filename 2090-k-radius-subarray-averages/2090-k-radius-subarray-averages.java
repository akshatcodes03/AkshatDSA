class Solution {
    public int[] getAverages(int[] nums, int k) {

        int n = nums.length;
        int w = 2 * k + 1;

        int[] result = new int[n];

        // Sabko -1 se fill kar do
        java.util.Arrays.fill(result, -1);

        // Agar poori window hi array se badi hai
        if (w > n) {
            return result;
        }

        long sum = 0;

        int f = 0;
        int s = 0;

        // First window ka sum
        while (f < w) {
            sum += nums[f];
            f++;
        }

        // First valid average index k par hoga
        int i = k;
        result[i] = (int) (sum / w);

        // Sliding Window
        while (f < n) {

            // Naya element add
            sum = sum + nums[f];

            // Purana element remove
            sum = sum - nums[s];

            // Average store
            result[++i] = (int) (sum / w);

            // Pointers move
            s++;
            f++;
        }

        return result;
    }
}