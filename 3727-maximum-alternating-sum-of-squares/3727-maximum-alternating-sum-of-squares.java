import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] squares = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            squares[i] = 1L * nums[i] * nums[i];
        }

        Arrays.sort(squares);

        return solve(squares, 0, nums.length / 2);
    }

    private long solve(long[] squares, int index, int mid) {
        if (index == squares.length) {
            return 0;
        }

        if (index < mid) {
            return -squares[index] + solve(squares, index + 1, mid);
        }

        return squares[index] + solve(squares, index + 1, mid);
    }
}