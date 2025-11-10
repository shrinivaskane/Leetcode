class LC684_RedundantConnection {
    List<List<Integer>> adj = new ArrayList<>();
    boolean[] visited;
    int cycleStart;
    Set<Integer> cycle = new HashSet<Integer>();

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        for(int i = 0; i<= n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        visited = new boolean[n+1];
        dfs(1,-1);

        for(int i = n-1; i>= 0; i--) {
            int[] edge = edges[i];
            int u = edge[0], v = edge[1];
            if(cycle.contains(u) && cycle.contains(v)) {
                return edge;
            }
        }
        return new int[0];
    }

    private boolean dfs(int node, int parent) {
        if(visited[node]) {
            cycleStart = node;
            return true;
        }
        visited[node] = true;

        for(int nei: adj.get(node)) {
            if(nei == parent) continue;
            if(dfs(nei, node)) {
                if(cycleStart != -1) {
                    cycle.add(node);
                }
                if(node == cycleStart) {
                    cycleStart = -1;
                }
                return true;
            }
        }
        return false;
    }
}
