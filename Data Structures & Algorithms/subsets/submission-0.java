class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int len = nums.length;
        List<Integer> subset = new ArrayList<>();
        addSubsets(res, subset, nums, 0, len);
        return res;
    }

    private void addSubsets(List<List<Integer>> res, List<Integer> subset, int[] nums, int i, int len) {
        if(i<len) {
            subset.add(nums[i]);
            addSubsets(res, subset, nums, i+1, len);
            subset.removeLast();
            addSubsets(res, subset, nums, i+1, len);
        } else{
            res.add(new ArrayList<Integer>(subset));
        }
    }
}
