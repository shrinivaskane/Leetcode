class LC286_WallsAndgates {
    private static final int[][] directions = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    private static final int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        /*
        Queue<int[]> queue = new LinkedList<>();
        int ROWS = grid.length;
        int COLS = grid[0].length;
        for(int r = 0; r< ROWS; r++ ) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 0) {
                    queue.offer(new int[]{r,c});
                }
            }
        }
        while(!queue.isEmpty()) {
        int[] pair = queue.poll();
        int row = pair[0];
        int col = pair[1];

        for(int[] dir: directions) {
            int nr = row + dir[0];
            int nc = col + dir[1];
            if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == INF) {
            grid[nr][nc] = grid[row][col] + 1;
            queue.add(new int[] {nr, nc});
            }
        }
        }
        */
        /* using dfs */
        int ROWS = grid.length;
        int COLS = grid[0].length;
        for(int r = 0; r< ROWS; r++ ) {
            for(int c = 0; c < COLS; c++) {
                if(grid[r][c] == 0) {
                    dfs(grid, r, c, 0);
                }
            }
        }
    }

    private void dfs(int[][] grid, int r, int c, int dist) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == -1) {
            return;
        }
        if(grid[r][c] < dist) {
            return;
        }
        grid[r][c] = dist;
        for(int[] dir: directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(grid, nr, nc, dist+1);    
        }
    }
}
