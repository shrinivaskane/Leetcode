class LC17_LetterCombinationsOfPhoneNumber {
    List<String> res = new ArrayList<>();
      String[] digitsToChar = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return res;
        backtrack(0, "", digits);
        return res;
    }

    private void backtrack(int i, String currentStr, String digits) {
        if(currentStr.length() == digits.length()) {
            res.add(currentStr);
            return;
        }
        String chars = digitsToChar[digits.charAt(i) - '0'];
        for(char c: chars.toCharArray()) {
            backtrack(i+1, currentStr + c, digits);
        }
    }

}
