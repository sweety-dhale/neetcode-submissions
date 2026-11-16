class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> combSum = new ArrayList<>();
        int currSum = 0;

        getSum(res, combSum, currSum, 0, nums, target);
        return res;
    }

    private void getSum(List<List<Integer>> res, List<Integer> combSum, int currSum, int idx, int[] nums, int target) {
        if(idx>=nums.length) 
            return;

        currSum += nums[idx];
        combSum.add(nums[idx]);
        if(currSum == target) {
            res.add(new ArrayList<>(combSum));
        } else if(target>currSum){
            getSum(res, combSum, currSum, idx, nums, target);
        }
        currSum -= nums[idx];
        combSum.removeLast();
        getSum(res, combSum, currSum, idx+1, nums, target);
    }
}
