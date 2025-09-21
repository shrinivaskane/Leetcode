class LC695_MaxAreaOfIslands {
     private static final int[][] directions = new int[][] {{0,1}, {0, -1}, {1,0}, {-1, 0}};
    public int maxAreaOfIsland(int[][] grid) {
       
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int maxCount = 0;
        for(int r = 0; r< ROWS; r++) {
            for(int c = 0; c< COLS; c++) {
                if(grid[r][c] == 1) {
                    int count = dfs(grid, r, c);
                    maxCount = Math.max(maxCount, count);
                }
            }
        }
        return maxCount;
    }

    private int bfs(int[][] grid, int r, int c) {
        int sum = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {r,c});
        grid[r][c] = 0;

        while(!queue.isEmpty()) {
            int[] pair = queue.poll();
            sum++;
            int row = pair[0], col = pair[1];
            
            for(int[] dir: directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == 1) {
                    queue.offer(new int[]{nr, nc});
                    grid[nr][nc] = 0;
                }
            }
        }
        return sum;
    }

    private int dfs(int[][] grid, int r, int c) {
        if(r>= grid.length || c>= grid[0].length || r< 0 || c <  0 || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        int res = 1;
        for(int[] dir: directions) {
            res += dfs(grid, r+dir[0], c+ dir[1]);
        }
        return res;
    }

}
