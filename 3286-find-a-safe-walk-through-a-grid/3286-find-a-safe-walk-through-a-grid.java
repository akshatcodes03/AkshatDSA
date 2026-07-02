class Solution {

    private final int[][] dir = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };

    class Node {
        int row;
        int col;
        int damage;

        Node(int row, int col, int damage) {
            this.row = row;
            this.col = col;
            this.damage = damage;
        }
    }

    private boolean isValid(int r, int c, int m, int n) {
        return r >= 0 && c >= 0 && r < m && c < n;
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {

        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> a.damage - b.damage
        );

        dist[0][0] = grid.get(0).get(0);

        pq.offer(new Node(0, 0, dist[0][0]));

        while (!pq.isEmpty()) {

            Node curr = pq.poll();

            if (curr.damage > dist[curr.row][curr.col])
                continue;

            if (curr.row == m - 1 && curr.col == n - 1) {
                return curr.damage < health;
            }

            for (int[] d : dir) {

                int nr = curr.row + d[0];
                int nc = curr.col + d[1];

                if (!isValid(nr, nc, m, n))
                    continue;

                int newDamage = curr.damage + grid.get(nr).get(nc);

                if (newDamage < dist[nr][nc]) {
                    dist[nr][nc] = newDamage;
                    pq.offer(new Node(nr, nc, newDamage));
                }
            }
        }

        return false;
    }
}