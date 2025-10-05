class LC417_PacificAtlanticWaterFlowGraph {
    int[][] dir = new int[][]{{0,1}, {0, -1}, {-1, 0}, {1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int rows = heights.length;
        int cols  = heights[0].length;
        boolean[][] pac = new boolean [rows][cols];
        boolean[][] atc = new boolean [rows][cols];
        for(int c = 0; c < cols; c++) {
            dfs(0, c, pac, heights);
            dfs(rows-1, c, atc, heights);
        }
        for(int r = 0; r < rows; r++) {
            dfs(r, 0,  pac, heights);
            dfs(r, cols-1, atc, heights);
        }
        for(int r = 0; r< rows; r++) {
            for(int c = 0; c< cols; c++) {
                if(atc[r][c] && pac[r][c]) {
                    res.add(Arrays.asList(r,c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;
        for(int[] d: dir) {
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr >= 0 && nc >= 0 && nr < heights.length && nc < heights[0].length && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
            dfs(nr, nc, ocean, heights);
            }
        }

    }
}                                                                                                                                                                                                                                                                            
