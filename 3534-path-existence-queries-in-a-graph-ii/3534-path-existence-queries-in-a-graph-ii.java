import java.util.*;

class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // Pair up values with their original indices to sort them
        int[][] sorted = new int[n][2];
        for (int i = 0; i < n; i++) {
            sorted[i][0] = nums[i];
            sorted[i][1] = i;
        }
        Arrays.sort(sorted, (x, y) -> Integer.compare(x[0], y[0]));

        int[] val = new int[n];
        int[] pos = new int[n]; // maps original index to sorted index
        for (int i = 0; i < n; i++) {
            val[i] = sorted[i][0];
            pos[sorted[i][1]] = i;
        }

        int LOG = 18; 
        int[][] jump = new int[LOG][n];

        // Greedy approach: find the furthest index we can jump to on the right
        int r = 0;
        for (int i = 0; i < n; i++) {
            while (r < n && val[r] - val[i] <= maxDiff) {
                r++;
            }
            jump[0][i] = r - 1; // furthest reachable element from i
        }

        // Precompute sparse table for binary lifting
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                jump[k][i] = jump[k - 1][jump[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            
            if (u == v) {
                ans[i] = 0;
                continue;
            }

            int a = pos[u];
            int b = pos[v];
            if (a > b) { // Ensure a is always the smaller value
                int temp = a;
                a = b;
                b = temp;
            }

            int cur = a;
            int steps = 0;
            
            // Lift up until cur is just before b
            for (int k = LOG - 1; k >= 0; k--) {
                if (jump[k][cur] < b) {
                    cur = jump[k][cur];
                    steps += (1 << k);
                }
            }

            // Check if one last step from cur can reach or cross b
            if (jump[0][cur] >= b) {
                ans[i] = steps + 1;
            } else {
                ans[i] = -1;
            }
        }
        
        return ans;
    }
}