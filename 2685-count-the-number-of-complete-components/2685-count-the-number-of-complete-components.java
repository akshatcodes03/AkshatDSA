import java.util.*;

class Solution {

    ArrayList<Integer>[] graph;
    boolean[] visited;

    public int countCompleteComponents(int n, int[][] edges) {

        // Step 1: Create Graph
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }


        // Step 2: Add all edges
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].add(v);
            graph[v].add(u);
        }


        // Step 3: Visited Array
        visited = new boolean[n];

        int completeComponents = 0;


        // Step 4: Visit every node
        for (int i = 0; i < n; i++) {

            if (visited[i] == false) {

                int[] result = dfs(i);

                int totalNodes = result[0];

                int totalEdges = result[1] / 2;


                if (totalEdges == (totalNodes * (totalNodes - 1)) / 2) {
                    completeComponents++;
                }
            }
        }

        return completeComponents;
    }


    public int[] dfs(int currentNode) {

        visited[currentNode] = true;

        int nodeCount = 1;

        int edgeCount = graph[currentNode].size();


        for (int neighbour : graph[currentNode]) {

            if (visited[neighbour] == false) {

                int[] child = dfs(neighbour);

                nodeCount = nodeCount + child[0];

                edgeCount = edgeCount + child[1];
            }
        }

        return new int[]{nodeCount, edgeCount};
    }
}