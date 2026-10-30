
class Solution {
    public int trap(int[] arr) {

        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        int max = 0;
        
        for (int i = 0; i < n; i++) {
            max = Math.max(arr[i], max);
            left[i] = max;
        }

        max = 0;

        
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(arr[i], max);
            right[i] = max;
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            int min = Math.min(left[i], right[i]);
            count += min - arr[i];
        }

        return count;
    }
}
