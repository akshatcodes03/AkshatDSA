class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        if (m > n) {
            return new int[0];
        }

        int[] suffix = new int[n + 1];
        int right = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1];

            if (right >= 0 && word1.charAt(i) == word2.charAt(right)) {
                suffix[i]++;
                right--;
            }
        }

        int[] ans = new int[m];
        int p = 0;
        int q = 0;
        boolean mismatch = false;

        while (q < m) {
            if (p >= n) {
                break;
            }

            if (word1.charAt(p) == word2.charAt(q)) {
                ans[q] = p;
                p++;
                q++;
            } 
            else if (!mismatch && suffix[p + 1] >= m - q - 1) {
                ans[q] = p;
                mismatch = true;
                p++;
                q++;
            } 
            else {
                p++;
            }
        }

        if (q == m) {
            return ans;
        }

        return new int[0];
    }
}