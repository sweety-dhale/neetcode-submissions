class Solution {
    public boolean canJump(int[] nums) {
        int jump = nums[0], idx = 0;
        for(int i=1;i<nums.length; i++) {
            jump--;
            if(jump < 0) {
                return false;
            }
            jump = Math.max(jump, nums[i]);
        }
        return true;
    }
}
