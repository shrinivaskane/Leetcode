class LC994_RottingOranges {
    private static final int[][] directions = new int[][] {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int ROWS = grid.length;
        int COLS = grid[0].length;
        int fresh = 0;
        for(int r = 0; r< ROWS; r++) {
            for(int c = 0; c< COLS; c++) {
                if(grid[r][c] == 2) {
                    queue.offer(new int[] {r,c,0});
                } else if(grid[r][c] == 1) {
                    fresh++;
                }
            }
        }
        // edge case 
        if(fresh == 0) return 0;

        int maxTime = 0;
        while(!queue.isEmpty()) {
            int[] pair = queue.poll();
            int row = pair[0], col = pair[1], time = pair[2];
            for(int[] dir: directions) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(nr< grid.length && nc < grid[0].length && nc >= 0 && nr >= 0 && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    fresh--;
                    queue.add(new int[]{nr, nc, time + 1});
                    maxTime = time + 1;
                }
            }
        }
        return fresh == 0? maxTime: -1;
    }
}
