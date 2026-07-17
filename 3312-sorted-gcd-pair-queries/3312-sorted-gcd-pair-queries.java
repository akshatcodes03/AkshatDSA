import java.util.*;

class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {

        int mx = 0;
        for (int x : nums) mx = Math.max(mx, x);

        int[] f = new int[mx + 1];
        for (int x : nums) f[x]++;

        long[] cnt = new long[mx + 1];

        for (int i = mx; i >= 1; i--) {
            long c = 0;
            for (int j = i; j <= mx; j += i)
                c += f[j];

            cnt[i] = c * (c - 1) / 2;

            for (int j = i + i; j <= mx; j += i)
                cnt[i] -= cnt[j];
        }

        for (int i = 1; i <= mx; i++)
            cnt[i] += cnt[i - 1];

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            long k = queries[i] + 1;

            int l = 1, r = mx;

            while (l < r) {
                int m = (l + r) >>> 1;
                if (cnt[m] >= k)
                    r = m;
                else
                    l = m + 1;
            }

            ans[i] = l;
        }

        return ans;
    }
}