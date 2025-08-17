class LC40_CombinationSum2 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, curr, res);
        return res;
    }

    private void dfs(int[] candidates, int i, int target, List<Integer> curr, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(i >= candidates.length || target < 0) return;

        curr.add(candidates[i]);
        dfs(candidates, i + 1, target - candidates[i], curr, res);
        curr.remove(curr.size() - 1);
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i++;
        }
        dfs(candidates, i+1, target, curr, res);
    }
}
