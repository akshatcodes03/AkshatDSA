class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int [][] ans = new int[m][n];

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                int index = (i*n+j+k)%(m*n);

                int newRow = index / n;
        int newCol = index % n;

        ans[newRow][newCol] = grid[i][j];
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(ans[i][j]);
                }
                result.add(row);
                }
                
                return result;
    }
}
