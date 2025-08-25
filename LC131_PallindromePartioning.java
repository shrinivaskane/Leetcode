class LC131_PallindromePartioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        dfs(s, 0, part, res);
        return res;
    }

    private void dfs(String s,int i, List<String> part, List<List<String>> res) {
        if(i >= s.length()) {
            res.add(new ArrayList<String>(part));
        }

        for(int j = i; j< s.length(); j++) {
            if(isPallindrome(s, i, j)) {
                part.add(s.substring(i, j+1));
                dfs(s, j+1, part, res);
                part.remove(part.size() - 1);
            }
        }

    }

    private boolean isPallindrome(String s, int l, int r) {
        while(l<r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
