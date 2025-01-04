public class LC36ValidSuduko {
    public boolean isValidSudoku(char[][] board) {

        /* Using Hashset(One Pass)  TC O(n^2) SC O(n^2)
        Map<Integer, Set<Character>> cols = new HashMap<>();
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') continue;

                String squareKey = (r / 3) + "," + (c / 3);

                if (rows.computeIfAbsent(r, k -> new HashSet<>()).contains(board[r][c]) ||
                    cols.computeIfAbsent(c, k -> new HashSet<>()).contains(board[r][c]) ||
                    squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[r][c])) {
                    return false;
                }

                rows.get(r).add(board[r][c]);
                cols.get(c).add(board[r][c]);
                squares.get(squareKey).add(board[r][c]);
            }
        }
        return true;
        */
    
        /* Using Bitmask */
        int[] rows = new int[9];
        int[] columns = new int[9];
        int[] blocks = new int[9];

        for(int r = 0; r< 9; r++) {
            for(int c = 0; c< 9; c++) {
                if(board[r][c] != '.') {
                    int val = board[r][c] - '1';
                    if((rows[r] & (1 << val)) > 0 || (columns[c] & (1<< val)) > 0 || (blocks[(r/3)*3 + c/3] & (1<<val)) > 0) {
                        return false;
                    }
                rows[r] |= 1<< val;
                columns[c] |= 1<<val;
                blocks[(r/3)*3 + c/3] |= 1<<val;
                }
            }
        }
        return true;
    }
}
