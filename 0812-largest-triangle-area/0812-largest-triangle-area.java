class Solution {

    public double area(int[] A, int[] B, int[] C) {
        return Math.abs(
                A[0] * (B[1] - C[1]) +
                B[0] * (C[1] - A[1]) +
                C[0] * (A[1] - B[1])
        ) / 2.0;
    }

    public double largestTriangleArea(int[][] points) {

        double maxArea = 0;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {

                    double currentArea = area(points[i], points[j], points[k]);

                    if (currentArea > maxArea) {
                        maxArea = currentArea;
                    }
                }
            }
        }

        return maxArea;
    }
}