class LC79_WordSearch {
    Set<Pair<Integer, Integer>> set = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int r = 0; r< m; r++) {
            for(int c = 0; c< n; c++) {
                if(dfs(board, word, r, c, 0)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i) {
        if(i == word.length()) return true;
        if(r < 0 || c < 0 || r>= board.length || c >= board[0].length || board[r][c] != word.charAt(i) || set.contains(new Pair<>(r,c))) {
            return false;
        }

        set.add(new Pair<>(r,c));
        boolean res = dfs(board, word, r, c+1, i+1)
        || dfs(board, word, r, c-1, i+1)
        || dfs(board, word, r+1, c, i+1)
        || dfs(board, word, r-1, c, i+1);
        set.remove(new Pair<>(r,c));
        return res;
    }

}
