class L22_GenerateParentheses {
    boolean valid(String s) {
        int open = 0;
        for(Character c: s.toCharArray()) {
            open += c == '('? +1: -1;
            if(open<0) return false;
        }
        return open == 0;
    }

    void dfs(String s, List<String> res, int n) {
        if(s.length() == 2*n) {
            if(valid(s)) {
                res.add(s);
            }
            return;
        }
        dfs(s+"(", res, n);
        dfs(s+")", res, n);
    }

    void backtracking(int open, int close, int n, List<String> res, StringBuilder stack) {
        if(open == close && open == n) {
            res.add(stack.toString());
            return;
        }
        if(open< n) {
            stack.append("(");
            backtracking(open+ 1, close, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if(close < open) {
            stack.append(")");
            backtracking(open, close+1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        /* Brute force approach 
        List<String> res = new ArrayList<>();
        dfs("", res, n);
        return res;
        */

        /* Backtracking and pruning */
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtracking(0, 0, n, res,stack);
        return res;
    }
}
