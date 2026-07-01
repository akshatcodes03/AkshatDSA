import java.util.*;

class Solution {

    
    public int gcd(int a, int b) {

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    
    public String getSlope(int x1, int y1, int x2, int y2) {

        int dx = x2 - x1;
        int dy = y2 - y1;

        if (dx == 0) {
            return "Vertical";
        }

        if (dy == 0) {
            return "Horizontal";
        }

        int g = gcd(Math.abs(dx), Math.abs(dy));

        dx /= g;
        dy /= g;

        
        if (dx < 0) {
            dx *= -1;
            dy *= -1;
        }

        return dy + "/" + dx;
    }

    public int maxPoints(int[][] points) {

        int n = points.length;

        if (n <= 2) {
            return n;
        }

        int answer = 0;

        for (int i = 0; i < n; i++) {

            HashMap<String, Integer> map = new HashMap<>();

            int max = 0;

            for (int j = i + 1; j < n; j++) {

                String slope = getSlope(
                        points[i][0], points[i][1],
                        points[j][0], points[j][1]);

                map.put(slope, map.getOrDefault(slope, 0) + 1);

                max = Math.max(max, map.get(slope));
            }

            answer = Math.max(answer, max + 1);
        }

        return answer;
    }
}