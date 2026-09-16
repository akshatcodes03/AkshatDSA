class Solution {
    public int[][] cyclicShift(int n, int[][] G, int[] RS, int[] CS) {
        int[][] res = new int[n][n];
        int sr;
        for (int r = 0; r < n; r++)
            for (int c = 0; c < n; c++)
                res[r][c] = G[sr = (r + CS[c]) % n][(c + RS[sr]) % n];
        return res;
    }
}