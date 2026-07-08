class Solution {

    static final int MOD = 1000000007;
    static final int MAX = 100001;
    static long[] power = new long[MAX];

    static {
        power[0] = 1;
        for (int i = 1; i < MAX; i++) {
            power[i] = (power[i - 1] * 10) % MOD;
        }
    }

    class PrefixData {
        int[] sum;
        int[] count;
        long[] concat;

        PrefixData(int n) {
            sum = new int[n + 1];
            count = new int[n + 1];
            concat = new long[n + 1];
        }
    }

    private PrefixData buildPrefix(String s) {

        int n = s.length();
        PrefixData data = new PrefixData(n);

        for (int i = 1; i <= n; i++) {

            int digit = s.charAt(i - 1) - '0';

            data.sum[i] = data.sum[i - 1] + digit;

            if (digit != 0) {
                data.count[i] = data.count[i - 1] + 1;
                data.concat[i] = (data.concat[i - 1] * 10 + digit) % MOD;
            } else {
                data.count[i] = data.count[i - 1];
                data.concat[i] = data.concat[i - 1];
            }
        }

        return data;
    }

    private long getConcat(PrefixData data, int l, int r) {

        int digits = data.count[r + 1] - data.count[l];

        long ans = data.concat[r + 1]
                - (data.concat[l] * power[digits]) % MOD;

        ans = (ans + MOD) % MOD;

        return ans;
    }

    public int[] sumAndMultiply(String s, int[][] queries) {

        PrefixData data = buildPrefix(s);

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int left = queries[i][0];
            int right = queries[i][1];

            int digitSum = data.sum[right + 1] - data.sum[left];

            long number = getConcat(data, left, right);

            answer[i] = (int) ((number * digitSum) % MOD);
        }

        return answer;
    }
}