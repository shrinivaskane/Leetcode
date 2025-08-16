class LC39_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<>();
        dfs(candidates, 0, list, target, res);
        return res;
    }

    private void dfs(int[] candidates, int i, List<Integer> list, int target, List<List<Integer>> res) {
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || i>= candidates.length) return;

        list.add(candidates[i]);
        dfs(candidates, i, list, target - candidates[i], res);
        list.remove(list.size() - 1);
        dfs(candidates, i + 1, list, target, res);
    }
}
