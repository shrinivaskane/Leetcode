class LC212_WordSearch {
    TrieNode[] children = new TrieNode[26];
    int idx = -1;
    int refs = 0;

    public void addWord(String word, int i) {
        TrieNode cur = this;
        cur.refs++;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
            cur.refs++;
        }
        cur.idx = i;
    }
}

class Solution {
    

    List<String> res = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        /* back tracking with TC  O(W* m*n*4^l)
        List<String> ans = new ArrayList<>();
        for(int i=0; i< words.length; i++) {
            boolean flag = false;
            for(int r = 0; r< board.length && !flag; r++) {
            for(int c = 0; c< board[0].length; c++) {
                if (board[r][c] != words[i].charAt(0)) continue;
                if(dfs(board, r, c, 0, words[i])) {
                    flag = true;
                    ans.add(words[i]);
                    break;
                }
            }
            }
        }
        return ans;
        */

        TrieNode root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            root.addWord(words[i], i);
        }

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, root, r, c, words);
            }
        }

        return res;
    }

/* dfs for backtracking 
    private boolean dfs(char[][] board, int r, int c, int i, String word) {
        if(i == word.length()) {
            return true;
        }
        if(r <0 || c <0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(i) || board[r][c] == '#') {
            return false;
        }
        board[r][c] = '#';

        boolean res = dfs(board, r, c+1, i+1, word) || dfs(board, r, c-1, i+1, word) || dfs(board, r+1, c, i+1, word) || dfs(board, r-1, c, i+1, word);

        board[r][c] = word.charAt(i);
        return res;        
}

*/

    private void dfs(char[][] board, TrieNode node, int r, int c, String[] words) {
        if (r < 0 || c < 0 || r >= board.length ||
            c >= board[0].length || board[r][c] == '*' ||
            node.children[board[r][c] - 'a'] == null) {
            return;
        }

        char temp = board[r][c];
        board[r][c] = '*';
        TrieNode prev = node;
        node = node.children[temp - 'a'];
        if (node.idx != -1) {
            res.add(words[node.idx]);
            node.idx = -1;
            node.refs--;
            if (node.refs == 0) {
                node = null;
                prev.children[temp - 'a'] = null;
                board[r][c] = temp;
                return;
            }
        }

        dfs(board, node, r + 1, c, words);
        dfs(board, node, r - 1, c, words);
        dfs(board, node, r, c + 1, words);
        dfs(board, node, r, c - 1, words);

        board[r][c] = temp;
    }
    
}
