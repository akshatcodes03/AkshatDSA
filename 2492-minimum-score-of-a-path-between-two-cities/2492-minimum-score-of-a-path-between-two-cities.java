class Solution {
    public int minScore(int n, int[][] roads) {


        // yaha se 
        List<int[]>[] graph = new ArrayList[n+1];

        for(int i = 1; i<=n; i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            int wt = road[2];

            graph[u].add(new int[]{v,wt});
            graph[v].add(new int[]{u,wt});
        }
        // yaha tak graph banaya hai 
        
        
        // yaha se BFS start kiya hai 
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        q.offer(1);
        visited[1] = true;
        int ans = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            int node = q.poll();

            for(int[] next : graph[node]){
                 int neighbour = next[0];
                 int weight = next[1];

                 ans = Math.min(ans,weight); // yaha pe answer found hua hai shortest road ka weight or ans compare kar ke 

                 if(!visited[neighbour]){
                    visited[neighbour] = true;
                     q.offer(neighbour); 
                    
                     }
            }
        }
        // yaha tak BFS chala hai 



        return ans;
    }
}