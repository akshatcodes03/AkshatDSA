
class Solution {
    public int digitSum(int n) {
        if (n == 0) {
            return 0;
        }

        return n % 10 + digitSum(n / 10);
    }

    public int countLargestGroup(int n) {
        int[] count = new int[37];

        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            count[sum]++;
        }

        int max = 0;

        for (int c : count) {
            max = Math.max(max, c);
        }

        int ans = 0;

        for (int c : count) {
            if (max == c) {
                ans++;
            }
        }

        return ans;
    }
}
