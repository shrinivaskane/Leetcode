class LC200_NoOfIslands {
    private static final int[][] directions = new int [][]{{0,1}, {0, -1}, {1,0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        /* using bfs 
        int islands = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;
        for(int r = 0; r< ROWS; r++) {
            for(int c = 0; c< COLS; c++) {
                if(grid[r][c] == '1') {
                    bfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
        */

        /* using dfs  */
        int islands = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;
        for(int r = 0; r< ROWS; r++) {
            for(int c = 0; c< COLS; c++) {
                if(grid[r][c] == '1') {
                    dfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for(int[] dir: directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(grid, nr, nc);
            }
        }

    private void bfs(char[][] grid, int r, int c) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r,c});
        grid[r][c] = '0';
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0], col = node[1];
            for(int[] dir: directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                    queue.add(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    } 
}
