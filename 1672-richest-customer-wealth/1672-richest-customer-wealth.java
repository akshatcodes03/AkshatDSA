class Solution {

    public int maximumWealth(int[][] accounts) {

        int max = 0;

        for (int[] x : accounts) {

            int sum = 0;

            for (int a : x) {
                sum += a;
            }

            max = Math.max(max, sum);
        }

        return max;
    }
}