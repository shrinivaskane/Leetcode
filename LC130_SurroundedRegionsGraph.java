class LC130_SurroundedRegionsGraph {
    int[][] dir = new int[][]{{0,1}, {0, -1}, {-1, 0}, {1,0}};
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int r = 0; r< board.length; r++) {
            if(board[r][0] == 'O') {
                dfs(r,0,board);
            }
            if(board[r][cols-1] == 'O') {
                dfs(r,cols-1,board);
            }
        }
        for(int c = 0; c< board[0].length; c++) {
            if(board[0][c] == 'O') {
                dfs(0, c,board);
            }
            if(board[rows-1][c] == 'O') {
                dfs(rows-1, c,board);
            }
        }
        for(int r = 0; r< board.length; r++) { 
            for(int c = 0;c< board[0].length; c++) {
                if(board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
            }
        }
        for(int r = 0; r< board.length; r++) { 
            for(int c = 0;c< board[0].length; c++) {
                if(board[r][c] == 'S') {
                    board[r][c] = 'O';
                }
            }
        }

    }

    private void dfs(int r, int c, char[][] board) {
        board[r][c] = 'S';
        for(int[] d: dir) {
            int nr = r + d[0];
            int nc = c + d[1];
            if(nr >= 0 && nc >= 0 && nr < board.length && nc < board[0].length && board[nr][nc] == 'O') {
                dfs(nr, nc, board);
            }
        }
    }
}
