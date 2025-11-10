class LC261_GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i< n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);   
            adj.get(edge[1]).add(edge[0]);   
        }
        boolean connected = dfs(0,-1, adj, visited);
        return connected && visited.size() == n;
    }

    private boolean dfs(int node, int parent, List<List<Integer>> adj, Set<Integer> visited) {
        if(visited.contains(node)) return false;
        visited.add(node);

        for(int next: adj.get(node)) {
            if(parent == next) continue;
            if(!dfs(next, node, adj, visited)) {
                return false;
            }
        }
        return true;
    }
}
