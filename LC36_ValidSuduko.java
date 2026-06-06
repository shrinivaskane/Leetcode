class LC36_ValidSuduko {
    public boolean isValidSudoku(char[][] board) {
        /* Using HashSet 
        Set<Character>[] rowSeen = new HashSet[9];
        Set<Character>[] colSeen = new HashSet[9];
        Set<Character>[] boxSeen = new HashSet[9];

        for(int i = 0; i< 9; i++) {
            rowSeen[i] = new HashSet<>();
            colSeen[i] = new HashSet<>();
            boxSeen[i] = new HashSet<>();
        }

        for(int r = 0; r< 9; r++) {
            for(int c = 0; c< 9; c++) {
                if(board[r][c] == '.') continue;
                int boxNum = (r/3)*3 + (c/3);
                if(!rowSeen[r].add(board[r][c])) return false;
                if(!colSeen[c].add(board[r][c])) return false;
                if(!boxSeen[boxNum].add(board[r][c])) return false;               
            }
        }
        return true;

        */

        /* Using Bit Manipulation Approach  */
        int[] rowSeen = new int[9];
        int[] colSeen = new int[9];
        int[] boxSeen = new int[9];

        for(int r = 0; r< 9; r++) {
            for(int c = 0; c< 9; c++) {
                if(board[r][c] == '.') continue;
                int boxNum = (r/3) * 3 + (c/3);
                int bit = 1 << (board[r][c] - '1');

                // AND OPERATION FOR DUPLICATES
                if((bit & rowSeen[r]) > 0) return false;
                if((bit & colSeen[c]) > 0) return false;
                if((bit & boxSeen[boxNum]) > 0) return false;

                // OR OPERATION TO ADD TO THE ARRAYS
                rowSeen[r] |= bit;
                colSeen[c] |= bit;
                boxSeen[boxNum] |=  bit;
               
            }         
        }
        return true;
    }
}
