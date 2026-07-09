class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        
        
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] <= maxDiff) {
                
                int root1 = find(parent, i);
                int root2 = find(parent, i + 1);

                if (root1 != root2) {
                    parent[root1] = root2; 
                }
            }
        }

        
        int q = queries.length;
        boolean[] answer = new boolean[q];

        for (int i = 0; i < q; i++) {
            int u = queries[i][0];
            int v = queries[i][1];

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            if (rootU == rootV) {
                answer[i] = true;
            } else {
                answer[i] = false;
            }
        }

        return answer;
    }

    
    private int find(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]]; 
            x = parent[x];
        }
        return x;
    }
}